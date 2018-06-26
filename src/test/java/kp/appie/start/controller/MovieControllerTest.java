package kp.appie.start.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kp.appie.start.controllers.MovieController;
import kp.appie.start.models.Movie;
import kp.appie.start.services.MovieService;

public class MovieControllerTest {
	private Movie movie;
	
	@InjectMocks
	private MovieController mc;
	
	@Mock
	private MovieService ms;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		movie = new Movie();
		movie.setTitle("title");
		movie.setDirector("director");
		movie.setGenre("genre");
		movie.setYearOfRelease(2000);
	}

	@Test
	public void testShowMovies() {
		when(ms.getMovie(1L)).thenReturn(movie);
		String movie = mc.showMovies();
		
		assertThat(movie, is("title: title, director: director, genre: genre, year: 2000"));
		
		verify(ms).getMovie(1L);
	}

}
