package kp.appie.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kp.appie.start.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping("/")
	public String showMovies() {
		return movieService.getMovie().toString();
	}

}
