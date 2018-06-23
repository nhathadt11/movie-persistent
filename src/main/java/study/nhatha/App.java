package study.nhatha;

import study.nhatha.model.Movie;
import study.nhatha.repository.MovieRepository;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
  public static void main( String[] args )
  {
    MovieRepository movieRepository = new MovieRepository();

    Movie theJungleBook = new Movie();
    theJungleBook.setTitle("The Jungle Book 3");

    List<Movie> created = movieRepository.all();

    System.out.println(created.size());
  }
}
