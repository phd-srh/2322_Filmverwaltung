package controller;

import dao.FilmDAO;
import dao.SQLFilmDAO;
import dao.TempFilmDAO;
import model.Film;
import model.Genre;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final FilmDAO filmDB = new TempFilmDAO();
    private static final Scanner eingabe = new Scanner(System.in);

    public static void main(String[] args) {
        Hauptschleife:
        while (true) {
            System.out.println("Hauptmenu");
            System.out.println("=========");
            System.out.println("1 - Neuen Film anlegen");
            System.out.println("2 - Film löschen");
            System.out.println("3 - Alle Filme anzeigen");
            System.out.println("9 - Programm beenden");

            int auswahl = eingabe.nextInt();
            switch (auswahl) {
                case 1:
                    neuenFilmAnlegen();
                    break;
                case 2:
                    filmLöschen();
                    break;
                case 3:
                    filmeAnzeigen();
                    break;
                case 9:
                    // Programm beenden
                    break Hauptschleife;
                default:
                    System.out.println("Ungültige Eingabe, bitte nochmal versuchen");
            }
        }
        System.out.println("Vielen Dank und auf Wiedersehen");
    }

    private static void filmeAnzeigen() {
        List<Film> filmListe = filmDB.getAllMovies();
        for (Film film : filmListe) {
            System.out.println(film);
        }
    }

    private static void filmLöschen() {
        System.out.print("Bitte die zu löschende Filmnummer eingeben: ");
        int filmnummer = eingabe.nextInt();
        Film film = filmDB.getMovieByNumber(filmnummer);
        if (film != null) {
            System.out.println("Achtung. Sie wollen den Film '" +
                    film.getTitel() +
                    "' löschen.");
            System.out.print("Wirklich löschen (j/n)? ");
            char auswahl = eingabe.next().toUpperCase().charAt(0);
            eingabe.nextLine();
            if (auswahl == 'J') {
                if ( filmDB.deleteMovie(filmnummer) ) {
                    System.out.println("Film '"
                            + film.getTitel()
                            + "' wurde gelöscht.");
                }
            }
        }
    }

    private static void neuenFilmAnlegen() {
        
    }
}
