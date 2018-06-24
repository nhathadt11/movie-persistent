package study.nhatha.repository;

import study.nhatha.model.Movie;

public class HibernateMovieRepository extends GenericHibernateRepository<Movie> implements MovieRepository {

  private static class HibernateMovieRepositoryHolder {
    static final HibernateMovieRepository INSTANCE = new HibernateMovieRepository();
  }

  private HibernateMovieRepository(Class<Movie> clazz) {
    super(clazz);
  }

  private HibernateMovieRepository() {
    this(Movie.class);
  }

  public static HibernateMovieRepository getInstance() {
    return HibernateMovieRepositoryHolder.INSTANCE;
  }
}
