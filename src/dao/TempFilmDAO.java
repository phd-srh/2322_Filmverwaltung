package dao;

import model.Film;
import model.Genre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TempFilmDAO implements FilmDAO {

    // das ist ein statisches, d.h. fixes Array
//    Film[] meineListeVonFilmen = new Film[ 1000 ];

    // ein dynamisches Array
    private List<Film> filmListe = new ArrayList<>();
    private List<Genre> genreListe = new ArrayList<>();

    // in-memory Datenbank
    public TempFilmDAO() {
        // ein paar nützliche Datensätze
        Genre g1 = new Genre(1, "Action");
        Genre g2 = new Genre(2, "Drama");
        Genre g3 = new Genre(3, "Comedy");
        genreListe.add( g1 );
        genreListe.add( g2 );
        genreListe.add( g3 );

        filmListe.add( new Film(1, "Matrix", g1, 4.3, 1999) );
        filmListe.add( new Film(2, "Herr der Fliegen", g2, 3.2, 1990) );
        filmListe.add( new Film(3, "Bruce allmächtig", g3, 3.4, 2003) );
        filmListe.add( new Film(4, "Stirb langsam", g1, 4.1, 1988) );
        filmListe.add( new Film(5, "American Pie", g3, 3.5, 1999) );
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
