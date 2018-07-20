package study.nhatha;

import study.nhatha.model.Movie;
import study.nhatha.repository.HibernateMovieRepository;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
  public static void main( String[] args )
  {
    HibernateMovieRepository hibernateMovieRepository = HibernateMovieRepository.getInstance();

//    List<Movie> movies = hibernateMovieRepository.findByPageAndTitleLike(1, "star wars");
//    long count = hibernateMovieRepository.countByTitleLike("star wars");

    List<Movie> movies = hibernateMovieRepository.pageAndFullTextSearch(1, "có");

    System.out.println(movies.size());
    movies.forEach(m -> System.out.println(m.getTitle()));
//    System.out.println(count);
  }
}
