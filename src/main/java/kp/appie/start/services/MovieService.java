package kp.appie.start.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.appie.start.dao.MovieRepository;
import kp.appie.start.models.Movie;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepo;
	
	public Movie getMovie(long id) {
		return movieRepo.getOne(id);
	}

	public void addMovie(Movie movie) {
		movieRepo.save(movie);
	}

	public List<Movie> getMovies() {
		return movieRepo.findAll();
	}
	
}
