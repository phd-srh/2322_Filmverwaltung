package model;

public class Genre {
    private int genrenummer;
    private String bezeichnung;

    public Genre(int genrenummer, String bezeichnung) {
        this.genrenummer = genrenummer;
        this.bezeichnung = bezeichnung;
    }

    public int getGenrenummer() {
        return genrenummer;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
