package com.uttl.javatest.movies.data;

import com.uttl.javatest.movies.model.Genre;
import com.uttl.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
     private JdbcTemplate  jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = { id };

        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMappert);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies", movieMappert);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString());
    }


    private  static RowMapper<Movie> movieMappert = (resultSet, i) ->
            new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")));
}
