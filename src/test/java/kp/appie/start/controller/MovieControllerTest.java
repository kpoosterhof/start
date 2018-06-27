package kp.appie.start.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	public void testGetMovie() {
		when(ms.getMovie(1L)).thenReturn(movie);
		Movie mv = mc.getMovie(1L);
		
		assertThat(mv.toString(), is("title: title, director: director, genre: genre, year: 2000"));
		
		verify(ms).getMovie(1L);
	}
	
	@Test
	public void testAddMovie() {
		doNothing().when(ms).addMovie(movie);
		mc.addMovie(movie);
		
		verify(ms).addMovie(movie);
	}
	
	@Test
	public void testGetMovies() {
		List<Movie> list = new ArrayList<>();
		list.add(movie);
		when(ms.getMovies()).thenReturn(list);
		List<Movie> mvl = mc.getMovies();
		
		assertThat(mvl.size(), is(1));
		
		verify(ms).getMovies();
	}

}
