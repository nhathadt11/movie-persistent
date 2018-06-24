package study.nhatha.repository;

import study.nhatha.model.Movie;

public class HibernateMovieRepository extends GenericHibernateRepository<Movie> implements MovieRepository {

  private HibernateMovieRepository(Class<Movie> clazz) {
    super(clazz);
  }

  public HibernateMovieRepository() {
    this(Movie.class);
  }
}
