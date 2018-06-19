package kp.appie.start.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kp.appie.start.dao.MovieRepository;
import kp.appie.start.models.Movie;
import kp.appie.start.services.MovieService;

public class MovieServiceTest {
	private Movie movie;
	
	@InjectMocks
	MovieService ms;
	
	@Mock
	MovieRepository mr;
	
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
		when(mr.getOne(1L)).thenReturn(movie);
		
		Movie mv = ms.getMovie(1L);
		
		assertThat(mv.toString(), is("title: title, director: director, genre: genre, year: 2000"));
		
		verify(mr).getOne(1L);
	}

}
