package org.example;

import org.example.entities.BoardGames;
import org.example.entities.Collection;
import org.example.entities.Videogames;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collection collection = new Collection();
        Scanner scanner = new Scanner(System.in);

        try{
            //videogiochi
            collection.addGame(new Videogames(1L, "Elden Ring", 2022, 59.90, "PC", Tipes.ACTION));
            collection.addGame(new Videogames(2L, "The Witcher 3", 2015, 29.99, "PS5", Tipes.RPG));
            collection.addGame(new Videogames(3L, "FIFA 24", 2023, 69.99, "Xbox", Tipes.SPORT));
            collection.addGame(new Videogames(4L, "Doom Eternal", 2020, 19.90, "PC", Tipes.FPS));
            collection.addGame(new Videogames(5L, "Super Mario Odyssey", 2017, 49.90, "Switch", Tipes.PLATFORM));

            //Giochi da tavolo
            collection.addGame(new BoardGames(6L, "Risiko", 1957, 35.00, 6, 120));
            collection.addGame(new BoardGames(7L, "Monopoly", 1935, 25.00, 8, 180));
            collection.addGame(new BoardGames(8L, "Catan", 1995, 45.00, 4, 90));
            collection.addGame(new BoardGames(9L, "Dixit", 2008, 30.00, 6, 30));
            collection.addGame(new BoardGames(10L, "Gloomhaven", 2017, 140.00, 4, 120));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
}
