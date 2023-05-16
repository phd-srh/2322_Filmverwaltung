package controller;

import dao.FilmDAO;
import dao.SQLFilmDAO;
import dao.TempFilmDAO;
import model.Film;
import model.Genre;

public class Main {
    public static void main(String[] args) {

        FilmDAO filmDB = new TempFilmDAO();

        filmDB.insertMovie( new Film(1, "A", new Genre(2, "B"), 2.3, 1970) );

    }
}
