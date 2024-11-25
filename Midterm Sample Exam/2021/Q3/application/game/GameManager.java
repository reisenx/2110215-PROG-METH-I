package application.game;

import application.deck.Deck;

public class GameManager {
    private static Deck playerDeck;
    private static int stage=0;
    private static int life=2;

    public static Deck getPlayerDeck() {
        return playerDeck;
    }

    public static void setPlayerDeck(Deck playerDeck) {
        GameManager.playerDeck = playerDeck;
    }

    public static int getStage() {
        return stage;
    }

    public static void setStage(int stage) {
        GameManager.stage = stage;
    }

    public static void increaseStage() {
        GameManager.stage++;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        GameManager.life = life;
    }
}
