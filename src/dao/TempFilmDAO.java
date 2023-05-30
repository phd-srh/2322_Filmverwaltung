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
        filmListe.add( new Film(50, "American Pie", g3, 3.5, 1999) );
    }

    @Override
    public boolean insertMovie(Film f) {
        Film film = getMovieByNumber( f.getFilmnummer() );
        if (film != null) return false;
        filmListe.add( f.clone() );
        return true;
    }

    @Override
    public Film getMovieByNumber(int fnr) {
        for (int i=0; i < filmListe.size(); i++) {
            if (filmListe.get(i).getFilmnummer() == fnr)
                return filmListe.get(i).clone();
        }
        return null;
    }

    @Override
    public List<Film> getAllMovies() {
        List<Film> copyList = new ArrayList<>( filmListe.size() );
        for (Film f : filmListe) {
            // copyList.add(f); // <-- shallow copy :( -- so auch nicht
            copyList.add( f.clone() ); // so ist richtig, deep copy
        }
        return copyList;
        //return filmListe; -- so auf keinen Fall!
    }

    @Override
    public boolean updateMovie(int fnr, Film f) {
        deleteMovie(fnr);
        return insertMovie(f);
    }

    @Override
    public boolean deleteMovie(int fnr) {
        for (int i=0; i < filmListe.size(); i++) {
            if (filmListe.get(i).getFilmnummer() == fnr) {
                filmListe.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getHighestMovieNumber() {
        int maxFilmnummer = 0;
        for (int i=0; i<filmListe.size(); i++) {
            if (filmListe.get(i).getFilmnummer() > maxFilmnummer)
                maxFilmnummer = filmListe.get(i).getFilmnummer();
        }
        return maxFilmnummer;
    }

    @Override
    public boolean insertGenre(Genre g) {
        Genre g2 = getGenreByNumber( g.getGenrenummer() );
        if (g2 != null) return false;
        genreListe.add( g.clone() );
        return true;
    }

    @Override
    public Genre getGenreByNumber(int gnr) {
        for (int i=0; i < genreListe.size(); i++) {
            if (genreListe.get(i).getGenrenummer() == gnr)
                return genreListe.get(i).clone();
        }
        return null;
    }

    @Override
    public Genre getGenreByName(String name) {
        for (int i=0; i < genreListe.size(); i++) {
            if (genreListe.get(i).getBezeichnung().equals(name))
                return genreListe.get(i).clone();
        }
        return null;
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> copyList = new ArrayList<>( genreListe.size() );
        for (Genre g : genreListe) {
            copyList.add( g.clone() );
        }
        return copyList;
    }

    @Override
    public boolean updateGenre(int gnr, Genre g) {
        deleteGenre(gnr);
        return insertGenre(g);
    }

    @Override
    public boolean deleteGenre(int gnr) {
        for (int i=0; i < genreListe.size(); i++) {
            if (genreListe.get(i).getGenrenummer() == gnr) {
                genreListe.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getHighestGenreNumber() {
        int maxGenrenummer = 0;
        for (int i=0; i<genreListe.size(); i++) {
            if (genreListe.get(i).getGenrenummer() > maxGenrenummer)
                maxGenrenummer = genreListe.get(i).getGenrenummer();
        }
        return maxGenrenummer;
    }
}
