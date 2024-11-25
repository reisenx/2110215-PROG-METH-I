package application;

import application.deck.Deck;
import application.deck.PremadeDeck;
import application.game.GameManager;
import application.place.Places;
import application.place.PlacesList;
import application.util.CloneUtil;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static void printLineSeparator() {
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        PremadeDeck.enemyInit();
        printLineSeparator();
        System.out.println("============ Card Duelist =========");
        printLineSeparator();

        Deck deck = new PlayerSelection(System.out, scanner).runDeckSelection();
        GameManager.setPlayerDeck(CloneUtil.cloneDeck(deck));
        System.out.println("Selected " + deck.getName());
        printLineSeparator();

        System.out.println("Entering the towns");
        while(GameManager.getStage()< PlacesList.getPlaceList().length && GameManager.getLife()>0){
            new Places(System.out, scanner).run();
        }
        printLineSeparator();
        if (GameManager.getLife()>0){
            System.out.println("You are the Card Master");
        }else{
            System.out.println("Try again next time");
        }
    }
}
