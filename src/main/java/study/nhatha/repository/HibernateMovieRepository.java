package study.nhatha.repository;

import study.nhatha.model.Movie;

import java.util.Collections;
import java.util.List;

public class HibernateMovieRepository extends GenericHibernateRepository<Movie> implements MovieRepository {

  @Override
  public List<Movie> allByPage(final int pageNumber) {
    if (pageNumber < 1) {
      throw new IllegalArgumentException("Page number must be positive integer");
    }

    List<Movie> movies = Collections.emptyList();

    try {
      super.beginTransaction();
      movies = super.getCurrentSession()
          .createQuery("FROM " + Movie.class.getName())
          .setFirstResult((pageNumber - 1) * PAGE_SIZE)
          .setMaxResults(PAGE_SIZE)
          .getResultList();
      super.commitTransaction();
    } catch (RuntimeException e) {
      super.rollbackTransaction();
    }

    return movies;
  }

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
