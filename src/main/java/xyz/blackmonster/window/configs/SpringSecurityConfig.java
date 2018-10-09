package xyz.blackmonster.window.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${admin.console.username:admin}")
	private String username;

	@Value("${admin.console.password:admin}")
	private String password;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser(username)
			.password(passwordEncoder().encode(password)).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/assets/**", "/api/order/calculate", "/api/order/**")
				.permitAll()
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/admin/orders")
				.permitAll()
			.and()
			.logout().logoutSuccessUrl("/");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
