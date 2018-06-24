package study.nhatha.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.util.config.ConfigurationException;
import study.nhatha.hibernate.HibernateUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AbstractHibernateRepository<T extends Serializable> {
  private Class clazz;
  private SessionFactory sessionFactory;

  public AbstractHibernateRepository(Class<T> clazz) {
    this.clazz = clazz;
    this.sessionFactory = HibernateUtils
        .getSessionFactory()
        .orElseThrow(() -> new ConfigurationException("Cannot initialize hibernate SessionFactory"));
  }

  public Optional<T> one(long id) {
    T entity = null;

    try {
      beginTransaction();
      entity = (T) getCurrentSession().get(clazz, id);
      commitTransaction();
    } catch (RuntimeException e) {
      rollbackTransaction();
    }

    return Optional.of(entity);
  }

  public List<T> all() {
    List<T> entities = Collections.emptyList();

    try {
      beginTransaction();
      entities = (List<T>) getCurrentSession()
          .createQuery("FROM " + clazz.getName())
          .list();
      commitTransaction();
    } catch (RuntimeException e) {
      rollbackTransaction();
    }

    return entities;
  }

  public Optional<T> create(T entity) {
    try {
      beginTransaction();
      getCurrentSession().persist(entity);
      commitTransaction();
    } catch (RuntimeException e) {
      rollbackTransaction();
    }

    return Optional.of(entity);
  }

  public Optional<T> update(T entity) {
    try {
      beginTransaction();
      getCurrentSession().merge(entity);
      commitTransaction();
    } catch (RuntimeException e) {
      rollbackTransaction();
    }

    return Optional.of(entity);
  }

  public void delete(T entity) {
    try {
      beginTransaction();
      getCurrentSession().delete(entity);
      commitTransaction();
    } catch (RuntimeException e) {
      rollbackTransaction();
    }
  }

  public void deleteById(long id) {
    one(id).ifPresent(this::delete);
  }

  protected final Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  protected void beginTransaction() {
    getCurrentSession().getTransaction().begin();
  }

  protected void commitTransaction() {
    getCurrentSession().getTransaction().commit();
  }

  protected void rollbackTransaction() {
    getCurrentSession().getTransaction().rollback();
  }
}
