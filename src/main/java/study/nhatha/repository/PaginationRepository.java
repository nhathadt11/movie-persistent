package study.nhatha.repository;

import java.io.Serializable;
import java.util.List;

public interface PaginationRepository<T extends Serializable> {
  int PAGE_SIZE = 20;

  List<T> allByPage(final int pageNumber);
}
