package dao;

import model.Film;
import model.Genre;

import java.util.List;

public class SQLFilmDAO implements FilmDAO {

    public SQLFilmDAO() {
        // TODO
    }

    @Override
    public boolean insertMovie(Film f) {
        return false;
    }

    @Override
    public Film getMovieByNumber(int fnr) {
        return null;
    }

    @Override
    public List<Film> getAllMovies() {
        return null;
    }

    @Override
    public boolean updateMovie(int fnr, Film f) {
        return false;
    }

    @Override
    public boolean deleteMovie(int fnr) {
        return false;
    }

    @Override
    public int getHighestMovieNumber() {
        return 0;
    }

    @Override
    public boolean insertGenre(Genre g) {
        return false;
    }

    @Override
    public Genre getGenreByNumber(int gnr) {
        return null;
    }

    @Override
    public Genre getGenreByName(String name) {
        return null;
    }

    @Override
    public List<Genre> getAllGenres() {
        return null;
    }

    @Override
    public boolean updateGenre(int gnr, Genre g) {
        return false;
    }

    @Override
    public boolean deleteGenre(int gnr) {
        return false;
    }

    @Override
    public int getHighestGenreNumber() {
        return 0;
    }
}
