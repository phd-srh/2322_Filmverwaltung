package model;

public class Film {
    private int filmnummer;
    private String titel;
    private Genre genre;
    private double rating;
    private int erscheinungsjahr;

    public Film(int filmnummer, String titel, Genre genre, double rating, int erscheinungsjahr) {
        this.filmnummer = filmnummer;
        this.titel = titel;
        this.genre = genre;
        this.rating = rating;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public int getFilmnummer() {
        return filmnummer;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public Film clone() {
        return new Film(filmnummer, titel, genre.clone(), rating, erscheinungsjahr);
    }

    @Override
    public String toString() {
        return String.format("%3d | %-30s (%4d), %-10s : %.1f",
                filmnummer, titel, erscheinungsjahr, genre, rating);
    }
}
