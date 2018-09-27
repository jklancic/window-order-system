package xyz.blackmonster.window.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import xyz.blackmonster.window.types.Blinds;
import xyz.blackmonster.window.types.Color;
import xyz.blackmonster.window.types.Glazing;
import xyz.blackmonster.window.types.Mosquito;
import xyz.blackmonster.window.types.Shelf;
import xyz.blackmonster.window.types.WindowType;

/**
 * Window configuration
 */
@Entity
public class Window {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String uuid;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "width")
	private int width;
	@Column(name = "height")
	private int height;
	@Column(name = "glazing")
	private Glazing glazing;
	@Column(name = "color")
	private Color color;
	@Column(name = "type")
	private WindowType type;
	@Column(name = "shelf")
	private Shelf shelf;
	@Column(name = "blinds")
	private Blinds blinds;
	@Column(name = "mosquito")
	private Mosquito mosquito;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Glazing getGlazing() {
		return glazing;
	}

	public void setGlazing(Glazing glazing) {
		this.glazing = glazing;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public WindowType getType() {
		return type;
	}

	public void setType(WindowType type) {
		this.type = type;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Blinds getBlinds() {
		return blinds;
	}

	public void setBlinds(Blinds blinds) {
		this.blinds = blinds;
	}

	public Mosquito getMosquito() {
		return mosquito;
	}

	public void setMosquito(Mosquito mosquito) {
		this.mosquito = mosquito;
	}
}
