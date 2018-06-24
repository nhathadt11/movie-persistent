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
    HibernateMovieRepository hibernateMovieRepository = new HibernateMovieRepository();

    Movie theJungleBook = new Movie();
    theJungleBook.setTitle("The Jungle Book 3");

    List<Movie> created = hibernateMovieRepository.all();

    System.out.println(created.size());
  }
}
