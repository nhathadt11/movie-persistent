package study.nhatha.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends Serializable> {
  Optional<T> one(final long id);
  List<T> all();
  Optional<T> create(final T entity);
  Optional<T> update(final T entity);
  void delete(final T entity);
  void deleteById(final long id);
}
