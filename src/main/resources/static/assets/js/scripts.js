var order = { windows: [] };
var step_index = 0;

var translations = {};
$.getJSON("assets/translation/messages.json", function(json) {
	translations = json.translations;
});

function scroll_to_class(element_class, removed_height) {
	var scroll_to = $(element_class).offset().top - removed_height;
	if($(window).scrollTop() != scroll_to) {
		$('html, body').stop().animate({scrollTop: scroll_to}, 0);
	}
}

function bar_progress(progress_line_object, direction) {
	var number_of_steps = progress_line_object.data('number-of-steps');
	var now_value = progress_line_object.data('now-value');
	var new_value = 0;
	if(direction == 'right') {
		new_value = now_value + ( 100 / number_of_steps );
	}
	else if(direction == 'left') {
		new_value = now_value - ( 100 / number_of_steps );
	}
	progress_line_object.attr('style', 'width: ' + new_value + '%;').data('now-value', new_value);
}

function cost_update(cost) {

	$('#windowCost').html(cost.windowCost + ' &euro;');
	$('#serviceCost').html(cost.serviceCost + ' &euro;');
	$('#valueAddedTaxPercentage').html(cost.valueAddedTaxPercentage + ' %');
	$('#totalCost').html(cost.totalCost + ' &euro;');
}

function retrieve_window() {

	// retrieving window data
	var newWindow = {};
	newWindow.quantity = $('#quantity').val();
	newWindow.width = $('#width').val();
	newWindow.height = $('#height').val();
	newWindow.glazing = $('#glazing').val();
	newWindow.color = $('#color').val();
	newWindow.type = $('#type').val();
	newWindow.shelf = $('#shelf').val();
	newWindow.blinds = $('#blinds').val();
	newWindow.mosquito = $('#mosquito').val();

	// resetting window form fields
	$('#quantity').val('');
	$('#width').val('');
	$('#height').val('');
	$('#glazing').val($('#glazing option:first').val());
	$('#color').val($('#color option:first').val());
	$('#type').val($('#type option:first').val());
	$('#shelf').val($('#shelf option:first').val());
	$('#blinds').val($('#blinds option:first').val());
	$('#mosquito').val($('#mosquito option:first').val());

	return newWindow;
}

function retrieve_service() {

	var service = {};
	service.deinstallation = $('#deinstallation').is(':checked');
	service.disposal = $('#disposal').is(':checked');
	service.shipping = $('#shipping').is(':checked');
	service.installation = $('#installation').is(':checked');
	service.finalization = $('#finalization').is(':checked');
	service.distance = $('#distance').val();

	return service;
}

function retrieve_email() {

	return $('#email').val();
}

function add_window(newWindow) {

	// dynamically creating new row
	var newRow = '<tr><td>' + newWindow.quantity + '</td>';
	newRow = newRow.concat('<td>' + newWindow.width + 'x' + newWindow.height + '</td>');
	newRow = newRow.concat('<td>' + getTranslation('glazing', newWindow.glazing) + '</td>');
	newRow = newRow.concat('<td>' + getTranslation('color', newWindow.color) + '</td>');
	newRow = newRow.concat('<td>' + getTranslation('type', newWindow.type) + '</td>');
	newRow = newRow.concat('<td>' + getTranslation('shelf', newWindow.shelf) + '</td>');
	newRow = newRow.concat('<td>' + getTranslation('blinds', newWindow.blinds) + '</td>');
	newRow = newRow.concat('<td>' + getTranslation('mosquito', newWindow.mosquito) + '</td>');
	newRow = newRow.concat('<td><i class="fa fa-minus-circle" aria-hidden="true"></i></td></tr>');

	// adding window to list
	$('.window-list').append(newRow);
}

function getTranslation(domain, term) {
	if (term === 'NONE') {
		return translations.none;
	}

	var domainTranslations = translations[domain];
	return domainTranslations[term.toLowerCase()];
}

function show_error(selector, message) {
	$(selector).append('<div class="alert alert-danger" role="alert">' + message + '</div>');
	setTimeout(function() {
	  $('.alert-danger').fadeTo(500, 0).slideUp(500, function(){
			$(this).remove();
		});
	  }, 3000);
}

function show_success(selector, message) {
	$(selector).append('<div class="alert alert-success" role="alert">' + message + '</div>');
	setTimeout(function() {
		$('.alert-success').fadeTo(500, 0).slideUp(500, function(){
			$(this).remove();
		});
	}, 3000);
}

jQuery(document).ready(function() {

    /*
        Fullscreen background
    */
    $.backstretch('assets/img/backgrounds/1.jpg');

    $('#top-navbar-1').on('shown.bs.collapse', function(){
    	$.backstretch('resize');
    });
    $('#top-navbar-1').on('hidden.bs.collapse', function(){
    	$.backstretch('resize');
    });

    /*
        Form
    */
    $('.f1 fieldset:first').fadeIn('slow');

    $('.f1 input[type="text"], .f1 input[type="password"], .f1 textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    // next step
    $('.f1 .btn-next').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
    	// navigation steps / progress steps
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');

    	// fields validation
    	if (step_index === 0 && order.windows.length === 0) {
				next_step = false;
				show_error('div.error-step-1', 'Seznam oken je prazen');
			} else if (step_index == 1) {
				if (($('#shipping').is(':checked')) && (!$('#distance').val() || $('#distance').val() == "")) {
					next_step = false;
					show_error('div.error-step-2', 'Vnesi kilometrino, da se lahko izračunajo stroški z dostavo.');
				}
				order.service = retrieve_service();
				$.ajax({
					type: 'POST',
					async: false,
					headers: {
						'Accept': 'application/json',
						'Content-Type': 'application/json'
					},
					url: '/api/order/calculate',
					data: JSON.stringify(order),
					dataType: 'json'
				}).success(function(cost) {
					cost_update(cost);
				}).error(function() {
					next_step = false;
				});
			}

    	// fields validation
    	if( next_step ) {
				step_index++;
    		parent_fieldset.fadeOut(400, function() {
    			// change icons
    			current_active_step.removeClass('active').addClass('activated').next().addClass('active');
    			// progress bar
    			bar_progress(progress_line, 'right');
    			// show next step
	    		$(this).next().fadeIn();
	    		// scroll window to beginning of the form
    			scroll_to_class( $('.f1'), 20 );
	    	});
    	}

    });

    // previous step
    $('.f1 .btn-previous').on('click', function() {
    	// navigation steps / progress steps
		step_index--;
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');

    	$(this).parents('fieldset').fadeOut(400, function() {
    		// change icons
    		current_active_step.removeClass('active').prev().removeClass('activated').addClass('active');
    		// progress bar
    		bar_progress(progress_line, 'left');
    		// show previous step
    		$(this).prev().fadeIn();
    		// scroll window to beginning of the form
			scroll_to_class( $('.f1'), 20 );
    	});
    });

    // submit
    $('.f1 .btn-submit').on('click', function(e) {

    	var email = retrieve_email();
			var emailValidation = /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}/igm;
    	// fields validation
			if (!email || email == '' || !(emailValidation.test(email))) {
				show_error('div.error-step-3', 'Elektronski naslov manjka.');
				return;
			}

			order.email = email;
			$.ajax({
				type: 'POST',
				async: false,
				headers: {
					'Content-Type': 'application/json'
				},
				url: '/api/order/send',
				data: JSON.stringify(order),
				success: function() {
					show_success('div.error-step-3', 'Konfiguracija poslana. Izračun bi moral prispet v kratkem.')
				},
				error: function() {
					show_error('div.error-step-3', 'Prišlo je do napake. Prosim se enkrat klikni "Pošlji".')
				}
			});
    });

	$('.btn-add-window').on('click', function() {
		var parent_fieldset = $(this).parents('fieldset');
		var next_step = true;

		// fields validation
		parent_fieldset.find('input[type="text"]').each(function() {
				if( $(this).val() == "" ) {
						next_step = false;
				}
		});

		if (next_step) {
			var newWindow = retrieve_window();
			order.windows.push(newWindow);
			add_window(newWindow);
		} else {
			show_error('div.error-step-1', 'Vnesi količino in dimenzije');
		}
	});

	$(document.body).on('click', '.fa-minus-circle', function() {
		var index = $('.fa-minus-circle').index(this);
    	$(this).parents('tr').remove();
		order.windows.splice(index, 1);
	});

	$(".distance-row").hide();
	$('#shipping').click(function() {
	    if( $(this).is(':checked')) {
	        $(".distance-row").show();
	    } else {
	        $(".distance-row").hide();
	    }
	});
});
