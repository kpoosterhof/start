package kp.appie.start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.appie.start.dao.MovieRepository;
import kp.appie.start.models.Movie;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepo;
	
	public Movie getMovie() {
		return movieRepo.getOne(1L);
	}
	
}
