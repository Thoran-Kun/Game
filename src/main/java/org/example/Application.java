package org.example;

import org.example.entities.*;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collection collection = new Collection();
        Scanner scanner = new Scanner(System.in);

        try {
            //videogiochi
            collection.addGame(new Videogames(1L, "Elden Ring", 2022, 59.90, "PC", 200, Tipes.AZIONE));
            collection.addGame(new Videogames(2L, "The Witcher 3", 2015, 29.99, "PS5", 150, Tipes.RPG));
            collection.addGame(new Videogames(3L, "FIFA 24", 2023, 69.99, "Xbox", 10, Tipes.SPORT));
            collection.addGame(new Videogames(4L, "Doom Eternal", 2020, 19.90, "PC", 20, Tipes.FPS));
            collection.addGame(new Videogames(5L, "Super Mario Odyssey", 2017, 49.90, "Switch", 100, Tipes.PLATFORM));

            //Giochi da tavolo
            collection.addGame(new BoardGames(6L, "Risiko", 1957, 35.00, 6, 120));
            collection.addGame(new BoardGames(7L, "Monopoly", 1935, 25.00, 8, 180));
            collection.addGame(new BoardGames(8L, "Catan", 1995, 45.00, 4, 90));
            collection.addGame(new BoardGames(9L, "Dixit", 2008, 30.00, 6, 30));
            collection.addGame(new BoardGames(10L, "Gloomhaven", 2017, 140.00, 4, 120));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        boolean operazioni = true;
        while (operazioni) {
            System.out.println("Menu Catalogo: scegli operazioni");
            System.out.println("1. Aggiungi un nuovo Gioco");
            System.out.println("2. Ricerca per ID");
            System.out.println("3. Trova con prezzo più basso");
            System.out.println("4. Ricerca numero giocatori");
            System.out.println("5. Rimuovi inserendo ID");
            System.out.println("6. Aggiorna dati Gioco");
            System.out.println("7. Statistiche catalogo (Totale Giochi presenti, Gioco con prezzo più alto, media prezzi giochi)");
            System.out.println("0. Chiudi terminale operazioni");

            try {
                int opzione = Integer.parseInt(scanner.nextLine());

                switch (opzione) {
                    case 1 -> {
                        System.out.println("Cosa vuoi aggiungere? (1. Videogioco | 2. Gioco da Tavolo)");
                        int tipo = Integer.parseInt(scanner.nextLine());
                        System.out.print("Inserisci ID: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("Inserisci Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.print("Inserisci Anno: ");
                        int anno = Integer.parseInt(scanner.nextLine());
                        System.out.print("Inserisci Prezzo: ");
                        double prezzo = Double.parseDouble(scanner.nextLine());

                        if (tipo == 1) {
                            System.out.print("Inserisci Piattaforma: ");
                            String piattaforma = scanner.nextLine();
                            System.out.println("Scegli Genere: (ACTION, RPG, SPORT, FPS, PLATFORM)");
                            String genereStr = scanner.nextLine().toUpperCase();
                            Tipes genere = Tipes.valueOf(genereStr);
                            System.out.println("inserisci ore di gioco: ");
                            int playTimes = Integer.parseInt(scanner.nextLine());

                            collection.addGame(new Videogames(id, titolo, anno, prezzo, piattaforma, playTimes, genere));
                            System.out.println(collection);
                        } else if (tipo == 2) {
                            System.out.print("Inserisci Numero Giocatori: ");
                            int numG = Integer.parseInt(scanner.nextLine());
                            System.out.print("Inserisci Durata Minuti: ");
                            int min = Integer.parseInt(scanner.nextLine());

                            collection.addGame(new BoardGames(id, titolo, anno, prezzo, numG, min));
                        }
                        System.out.println("Gioco aggiunto con successo!");
                    }

                    case 2 -> {
                        System.out.print("Inserisci l'ID da cercare: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        Games g = collection.ricercaId(id);
                        System.out.println(g != null ? "Trovato: " + g : "Nessun gioco con questo ID.");
                    }

                    case 3 -> {
                        System.out.print("Inserisci il prezzo massimo: ");
                        double p = Double.parseDouble(scanner.nextLine());
                        System.out.println("Giochi trovati: " + collection.lowPrice(p));
                    }

                    case 4 -> {
                        System.out.print("Inserisci numero giocatori: ");
                        int n = Integer.parseInt(scanner.nextLine());
                        System.out.println("Risultati: " + collection.numOfPlayers(n));
                    }

                    case 5 -> {
                        System.out.print("ID del gioco da eliminare: ");
                        Long idRem = Long.parseLong(scanner.nextLine());
                        collection.rimuoviPerId(idRem);
                    }

                    case 6 -> {
                        System.out.println("--- AGGIORNAMENTO GIOCO ---");
                        System.out.print("ID del gioco da aggiornare: ");
                        Long idAgg = Long.parseLong(scanner.nextLine());
                        System.out.print("Nuovo Titolo: ");
                        String nTitolo = scanner.nextLine();
                        System.out.print("Nuovo Prezzo: ");
                        double nPrezzo = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nuovo Anno: ");
                        int nAnno = Integer.parseInt(scanner.nextLine());

                        collection.aggiornaGame(idAgg, nTitolo, nPrezzo, nAnno);
                    }

                    case 7 -> {
                        collection.totalGames();
                        collection.mediaPrice();
                        collection.stampaGiocoPiuCaro();
                    }

                    case 0 -> {
                        operazioni = false;
                        System.out.println("Arrivederci!");
                    }
                    default -> System.out.println("Devi inserire un numero valido!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRORE! Riprova inserendo un numero valido!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
