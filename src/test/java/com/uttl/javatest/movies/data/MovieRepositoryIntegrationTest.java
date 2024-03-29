package com.uttl.javatest.movies.data;

import com.uttl.javatest.movies.model.Genre;
import com.uttl.javatest.movies.model.Movie;
import org.h2.Driver;
import org.hamcrest.CoreMatchers;
import org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {


        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJdbc.findById(2);
        assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER)));

    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie("Super 8", 122, Genre.THRILLER);
        movieRepositoryJdbc.saveOrUpdate(movie);
        Movie movieFromDb= movieRepositoryJdbc.findById(4);

        assertThat(movieFromDb, CoreMatchers.is(new Movie(4, "Super 8", 122, Genre.THRILLER)));
    }

    @After
    public void tearDown() throws Exception {

        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough

    }
}