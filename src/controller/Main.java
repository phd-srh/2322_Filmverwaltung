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

        Film film = null;
        int filmnummer;
        do {
            System.out.print("Bitte eine Filmnummer eingeben: ");
            filmnummer = eingabe.nextInt();
            eingabe.nextLine(); // Rest der Eingabezeile konsumieren
            // extra feature
            if (filmnummer == 0) {
                filmnummer = filmDB.getHighestMovieNumber() + 1;
                System.out.println("Wir haben die Filmnummer "
                        + filmnummer + " für Sie gewählt.");
            }
            film = filmDB.getMovieByNumber(filmnummer);
            if (film != null) {
                System.out.println("Die Filmnummer ist bereits vergeben für den Titel '"
                    + film.getTitel() + "'");
            }
        } while (film != null);

        String titel;
        do {
            System.out.print("Bitte den Titel eingeben: ");
            titel = eingabe.nextLine();
            if (titel.isBlank()) {
                System.out.println("Dieser Titel ist ungültig");
            }
        } while ( titel.isBlank() );

        String genreBezeichnung;
        Genre genre = null;
        do {
            System.out.print("Bitte Genre auswählen: ");
            genreBezeichnung = eingabe.nextLine();
            if (genreBezeichnung.charAt(0) == '0') {
                List<Genre> genreList = filmDB.getAllGenres();
                int genreIndex = 0;
                do {
                    for (int i = 0; i < genreList.size(); i++) {
                        System.out.println((i + 1) + ": " + genreList.get(i).getBezeichnung());
                    }
                    System.out.print("Ihre Wahl: ");
                    genreIndex = eingabe.nextInt();
                    eingabe.nextLine();
                } while ( genreIndex < 1 || genreIndex >= genreList.size() );
                genre = genreList.get(genreIndex-1);
            }
            else {
                genre = filmDB.getGenreByName(genreBezeichnung);
                if (genre == null) {
                    System.out.print("Unbekanntes Genre '" +
                            genreBezeichnung +
                            "'. Soll dies neu angelegt werden (j/n)?");
                    char auswahl = eingabe.next().toUpperCase().charAt(0);
                    eingabe.nextLine();
                    if (auswahl == 'J') {
                        genre = new Genre(filmDB.getHighestGenreNumber()+1, genreBezeichnung);
                        if ( filmDB.insertGenre(genre) ) {
                            System.out.println("Genre '"
                                    + genreBezeichnung
                                    + "' wurde neu angelegt.");
                        }
                    }
                }
            }
        } while (genre == null);

        // DEBUG Ausgabe
        System.out.println("Filmnummer: " + filmnummer);
        System.out.println("Filmtitel : " + titel);
        System.out.println("Genre     : " + genre);
    }
}
