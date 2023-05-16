package dao;

import model.Film;
import model.Genre;

import java.util.List;

public interface FilmDAO {

    boolean insertMovie(Film f);
    Film getMovieByNumber(int fnr);
    List<Film> getAllMovies();
    boolean updateMovie(int fnr, Film f);
    boolean deleteMovie(int fnr);
    int getHighestMovieNumber();

    boolean insertGenre(Genre g);
    Genre getGenreByNumber(int gnr);
    Genre getGenreByName(String name);
    List<Genre> getAllGenres();
    boolean updateGenre(int gnr, Genre g);
    boolean deleteGenre(int gnr);
    int getHighestGenreNumber();

}
