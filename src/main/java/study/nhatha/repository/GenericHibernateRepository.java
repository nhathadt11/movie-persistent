package study.nhatha.repository;

import java.io.Serializable;

public class GenericHibernateRepository<T extends Serializable>
    extends AbstractHibernateRepository<T> implements GenericRepository<T> {
  public GenericHibernateRepository(Class<T> clazz) {
    super(clazz);
  }
}
