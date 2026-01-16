package org.example.entities;

public abstract class Games {
    //ATTRIBUTI
    private Long id;
    private String titolo;
    private int annoPubblicazione;
    private double price;

    //COSTRUTTORE
    public Games(Long id, String titolo, int annoPubblicazione, double price) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
