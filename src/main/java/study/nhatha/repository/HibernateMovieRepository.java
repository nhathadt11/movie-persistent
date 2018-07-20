package study.nhatha.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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
    } finally {
      getCurrentSession().close();
    }

    return movies;
  }

  @Override
  public List<Movie> findByPageAndTitleLike(int pageNumber, String title) {
    if (pageNumber < 1) {
      throw new IllegalArgumentException("Page number must be positive integer");
    }

    List<Movie> movies = Collections.emptyList();

    try {
      super.beginTransaction();

      Criteria criteria = super.getCurrentSession()
          .createCriteria(Movie.class)
          .add(Restrictions.ilike("title", "%" + title + "%"))
          .setFirstResult((pageNumber - 1) * PAGE_SIZE)
          .setMaxResults(PAGE_SIZE);
      movies = criteria.list();

      super.commitTransaction();
    } catch (RuntimeException e) {
      super.rollbackTransaction();
    } finally {
      getCurrentSession().close();
    }

    return movies;
  }

  @Override
  public List<Movie> pageAndFullTextSearch(int pageNumber, String text) {
    List<Movie> result = Collections.emptyList();

    try {
      super.beginTransaction();

      FullTextSession fullTextSession = Search.getFullTextSession(super.getCurrentSession());
      org.apache.lucene.search.Query luceneQuery = getLucenceFullTextQueryFor(text, fullTextSession);

      Query jpaQuery = fullTextSession
          .createFullTextQuery(luceneQuery, Movie.class)
          .setFirstResult((pageNumber - 1) * PAGE_SIZE)
          .setMaxResults(PAGE_SIZE);

      result = jpaQuery.getResultList();

      super.commitTransaction();
    } catch (RuntimeException e) {
      super.rollbackTransaction();
    } finally {
      super.getCurrentSession().close();
    }

    return result;
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
    } finally {
      getCurrentSession().close();
    }

    return count;
  }

  @Override
  public long countByTitleFullTextSearch(String text) {
    List<Movie> result = Collections.emptyList();

    try {
      super.beginTransaction();

      FullTextSession fullTextSession = Search.getFullTextSession(super.getCurrentSession());
      org.apache.lucene.search.Query luceneQuery = getLucenceFullTextQueryFor(text, fullTextSession);

      Query jpaQuery = fullTextSession
          .createFullTextQuery(luceneQuery, Movie.class);

      result = jpaQuery.getResultList();
      super.commitTransaction();
    } catch (RuntimeException e) {
      super.rollbackTransaction();
    } finally {
      super.getCurrentSession().close();
    }

    return result.size();
  }

  private org.apache.lucene.search.Query getLucenceFullTextQueryFor(String text, FullTextSession session) {
    QueryBuilder qb = session
        .getSearchFactory()
        .buildQueryBuilder()
        .forEntity(Movie.class)
        .get();

    return qb
        .bool()
        .should(qb
            .keyword()
            .wildcard()
            .onFields("title", "genre", "year", "plot")
            .matching("*" + text + "*")
            .createQuery()
        )
        .should(qb
            .phrase()
            .withSlop(5)
            .onField("title")
            .andField("genre").andField("year").andField("plot")
            .sentence(text)
            .createQuery()
        )
        .createQuery();
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
