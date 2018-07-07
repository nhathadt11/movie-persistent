package study.nhatha.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

  @Override
  public List<Movie> findByPageAndTitleLike(int pageNumber, String title) {
    List<Movie> movies = Collections.emptyList();

    try {
      super.beginTransaction();

      Criteria criteria = super.getCurrentSession().createCriteria(Movie.class)
          .add(Restrictions.ilike("title", "%" + title + "%"))
          .setFirstResult((pageNumber - 1) * PAGE_SIZE)
          .setMaxResults(PAGE_SIZE);
      movies = criteria.list();

      super.commitTransaction();
    } catch (RuntimeException e) {
      super.rollbackTransaction();
    }

    return movies;
  }

  @Override
  public long countByTitleLike(String title) {
    long count = 0;
    try {
        super.beginTransaction();

        Criteria criteriaCount = super.getCurrentSession()
            .createCriteria(Movie.class)
            .add(Restrictions.ilike("title", "%" + title + "%"))
            .setProjection(Projections.rowCount());
        count = (long) criteriaCount.uniqueResult();

        super.commitTransaction();
    } catch (RuntimeException e) {
      super.rollbackTransaction();
    }

    return count;
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
