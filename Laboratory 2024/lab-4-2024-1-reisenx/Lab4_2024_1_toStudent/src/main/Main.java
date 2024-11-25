package main;

import player.NegativePosException;

public class Main {

    public static void main(String[] args) {
        try {
            Board b = new Board();
            b.startBoard();
        } catch (NegativePosException ignored) {}

    }

}
