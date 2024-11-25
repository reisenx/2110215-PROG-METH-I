package application;

import application.deck.Deck;
import application.deck.PremadeDeck;
import application.util.StringUtil;

import java.io.PrintStream;
import java.util.Scanner;

public class PlayerSelection extends ShopApp{
    public PlayerSelection(PrintStream out, Scanner in) {
        super(out, in);
    }

    public Deck runDeckSelection() {
        int choice;
        choice = this.getChoice(1, PremadeDeck.premadeDecks.size(), this::printDecks, this::printCardinDeck);

        return PremadeDeck.premadeDecks.get(choice-1);
    }

    private void printDecks() {
        out.println("Select your Deck: ");
        int index = 1;
        for (Deck deck : PremadeDeck.premadeDecks) {
            out.println(index + ": " + deck.toString());
            index += 1;
        }
    }

    private String printCardinDeck(int index){
        index--;
        out.println("Card in deck:");
        StringUtil.printChoice(PremadeDeck.premadeDecks.get(index).getDeckList());
        return PremadeDeck.premadeDecks.get(index).getName();
    }
}
