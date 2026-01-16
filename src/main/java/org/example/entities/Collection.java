package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    //ATTRIBUTI
    private List<Games> listaGiochi;

    //COSTRUTTORE
    public Collection() {
        this.listaGiochi = new ArrayList<>();
    }

    public List<Games> getListaGiochi() {
        return listaGiochi;
    }

    public void setListaGiochi(List<Games> listaGiochi) {
        this.listaGiochi = listaGiochi;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "listaGiochi=" + listaGiochi +
                '}';
    }

    //1 METODO AGGIUNTA DI UN GIOCO
    public void addGame(Games newGame) {
        boolean presente = listaGiochi.stream()
                .anyMatch(g -> g.getId().equals(newGame.getId()));
        if (presente) {
            throw new RuntimeException("Errore: il gioco con ID " + newGame.getId() + " è già presente.");
        }
        listaGiochi.add(newGame);
    }

    //2 METODO RICERCA PER ID
    public Games ricercaId(Long id) {
        return listaGiochi.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("il tuo gioco con id: " + id + " non è presente nella collezione!"));
    }

    //3 METODO RICERCA PREZZO CHE RITORNA UNA LISTA GIOCHI CON PREZZO INFERIORE AL PREZZO INSERITO
    public List<Games> lowPrice(double price) {
        return listaGiochi.stream().filter(g -> g.getPrice() < price).toList();
    }

    //4 RICERCA PER NUMERO DI GIOCATORI
    public List<BoardGames> numOfPlayers(int n) {
        return listaGiochi.stream()
                .filter(g -> g instanceof BoardGames)
                .map(g -> (BoardGames) g)
                .filter(singleBGame -> singleBGame.getNumPlayers() == n)
                .toList();
    }

    //5 RIMOZIONE DI UN GIOCO DATO UN ID
    public void rimuoviPerId(Long id) {
        listaGiochi.removeIf(g -> g.getId().equals(id));
    }

    //6 AGGIORNAMENTO ELEMENTO ESISTENTE TRAMITE ID
    public void aggiornaGame(Long id, String newTitle, double newPrice, int newYear) throws Exception {
        Games gameFound = ricercaId(id);
        if (gameFound == null) {
            throw new Exception("impossibile aggiornare gioco: " + id + " ID non trovato");
        }
        gameFound.setTitolo(newTitle);
        gameFound.setPrice(newPrice);
        gameFound.setAnnoPubblicazione(newYear);

        System.out.println("Aggiornamento del prodotto avvenuto con successo");
    }

    //7 MEDIA PRODOTTI PER GIOCHI TOTALI PRESENTI NEL CATALOGO, GIOCO CON PREZZO PIU' ALTO, MEDIA PREZZI ELEMENTI
    //totale presente nel catalogo
    public void totalGames() {
        System.out.println("il totale dei giochi presenti nel catalogo è: " + listaGiochi.size());
    }

    //gioco col prezzo più alto
    public void stampaGiocoPiuCaro() {
        listaGiochi.stream()
                // Cerchiamo il massimo in base al prezzo
                .max((g1, g2) -> Double.compare(g1.getPrice(), g2.getPrice()))
                // Se lo trovi, fai questo; altrimenti, fai quello
                .ifPresentOrElse(
                        gioco -> System.out.println("Il gioco col prezzo più alto è: " + gioco.getTitolo()),
                        () -> System.out.println("Il catalogo è vuoto, non posso calcolare il prezzo più alto.")
                );
    }

    //media totale dei giochi presenti
    public void mediaPrice() {
        listaGiochi.stream()
                .mapToDouble(g -> g.getPrice())
                .average()
                .orElse(0.0);
    }
}
