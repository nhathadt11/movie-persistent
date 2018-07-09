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

    dbConnectionProperties.setProperty("hibernate.connection.url",      System.getenv("JDBC_DATABASE_URL"));
    dbConnectionProperties.setProperty("hibernate.connection.username", System.getenv("JDBC_DATABASE_USERNAME"));
    dbConnectionProperties.setProperty("hibernate.connection.password", System.getenv("JDBC_DATABASE_PASSWORD"));

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
