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
}
