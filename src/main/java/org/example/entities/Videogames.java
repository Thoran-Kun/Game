package org.example.entities;

public class Videogames extends Games {
    //ATTRIBUTI VIDEOGAMES
    private String platforms;
    private int playTimes;
    private Tipes genere;

    //COSTRUTTORE
    public Videogames(Long id, String titolo, int annoPubblicazione, double price, String platforms, int playTimes, Tipes genere) {
        //importiamo dal padre gli attributi fissi
        super(id, titolo, annoPubblicazione, price);
        //costruiamo la nostra Class
        this.platforms = platforms;
        this.playTimes = playTimes;
        this.genere = genere;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(int playTimes) {
        this.playTimes = playTimes;
    }

    public Tipes getGenere() {
        return genere;
    }

    public void setGenere(Tipes genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogames{" +
                "platforms='" + platforms + '\'' +
                ", playTimes=" + playTimes +
                ", genere=" + genere +
                '}';
    }
}
