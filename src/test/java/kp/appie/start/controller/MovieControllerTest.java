package kp.appie.start.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import kp.appie.start.controllers.MovieController;

public class MovieControllerTest {
	@InjectMocks
	private MovieController mc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShowMovies() {
		String movie = mc.showMovies();
		
		assertThat(movie, is("Movie"));
	}

}
