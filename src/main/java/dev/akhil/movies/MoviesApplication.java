package dev.akhil.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication // this annotation is needed in every MAIN class of every spring boot app (it automatically
// configures the components based on dependencies and treats MAIN file as the configuration file)

@RestController // annotation for a web controller that handles http requests but returns a json obj
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping // annotation lets the framework know that this method is a GET req endpoint
	public String apiRoot() {
		return "Welcome to the Movie";
	}

}
