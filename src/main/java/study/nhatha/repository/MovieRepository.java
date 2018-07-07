package study.nhatha.repository;

import study.nhatha.model.Movie;

import java.util.List;

public interface MovieRepository extends GenericRepository<Movie>, PaginationRepository<Movie> {
  List<Movie> findByPageAndTitleLike(int pageNumber, String title);
  long countByTitleLike(String title);
}
