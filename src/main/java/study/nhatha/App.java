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

    List<Movie> movies = hibernateMovieRepository.all();

    System.out.println(movies.size());
  }
}
