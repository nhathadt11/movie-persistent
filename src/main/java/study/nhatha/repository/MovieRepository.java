package study.nhatha.repository;

import study.nhatha.model.Movie;

public class MovieRepository extends GenericHibernateRepository<Movie> {

  private MovieRepository(Class<Movie> clazz) {
    super(clazz);
  }

  public MovieRepository() {
    this(Movie.class);
  }
}
