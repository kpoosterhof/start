package kp.appie.start.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@RequestMapping("/")
	public String showMovies() {
		return "Movie";
	}

}
