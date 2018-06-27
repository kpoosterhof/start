package kp.appie.start.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		// Only return movies with a release year that is equal to or higher than 2000
		
		return movieRepo.findAll().stream().filter(x -> (x.getYearOfRelease() >= 2000)).collect(Collectors.toList());
		
		
		// map the movie stream to a stream of movie id's and then map that to a stream of duplicate movies
		/*
		return movieRepo.findAll().stream().map(x -> x.getId()).map(x -> { 
			Movie movie = new Movie();
			movie.setId(x);
			movie.setTitle("DUPLICATE");
			movie.setDirector("DUPLICATOR");
			movie.setGenre("DUPLE");
			movie.setYearOfRelease(1999);
			return movie;
		}).collect(Collectors.toList());
		*/
		
		// Add additional info to the title if the release year of a movie is below 2000
		/*
		return movieRepo.findAll()
			.stream()
			.map(x -> {
				if (x.getYearOfRelease() < 2000) {
				String title = x.getTitle();
				x.setTitle(title + " (OLD MOVIE!)");
				}
				return x;
			})
			.collect(Collectors.toList());
		*/
		
		//return movieRepo.findAll().stream().sorted(Comparator.comparing(x -> x.))
	}	
}
