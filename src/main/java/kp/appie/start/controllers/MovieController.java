package kp.appie.start.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kp.appie.start.models.Movie;
import kp.appie.start.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") long id) {
		return movieService.getMovie(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}

}
