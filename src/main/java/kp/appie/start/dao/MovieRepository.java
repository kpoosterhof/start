package kp.appie.start.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kp.appie.start.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
