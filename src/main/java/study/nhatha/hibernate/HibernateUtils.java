package study.nhatha.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import study.nhatha.model.Movie;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public final class HibernateUtils {

  private static SessionFactory buildSessionFactory() throws IOException {
    Properties dbConnectionProperties = new Properties();

    dbConnectionProperties.load(HibernateUtils.class.getResourceAsStream("/hibernate.properties"));

    return new Configuration()
        .setProperties(dbConnectionProperties)
        .addAnnotatedClass(Movie.class)
        .buildSessionFactory();
  }

  public static Optional<SessionFactory> getSessionFactory() {
    Optional<SessionFactory> sessionFactory = Optional.empty();

    try {
      sessionFactory = Optional.ofNullable(buildSessionFactory());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return sessionFactory;
  }

  private HibernateUtils() {
  }
}
