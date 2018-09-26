package xyz.blackmonster.window.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("xyz.blackmonster.window")
public class WindowAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindowAppApplication.class, args);
	}
}
