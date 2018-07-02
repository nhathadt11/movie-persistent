package study.nhatha.repository;

import study.nhatha.model.Movie;

public interface MovieRepository extends GenericRepository<Movie>, PaginationRepository<Movie> {
}
