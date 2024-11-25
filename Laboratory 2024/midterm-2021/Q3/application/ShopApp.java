package application;

import application.util.ChoiceUtil;
import logic.card.BaseCard;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopApp extends ChoiceUtil {
    public ShopApp(PrintStream out, Scanner in) {
        super(out, in);
    }

    public BaseCard getCardChoice(List<BaseCard> cards, Runnable prompt) {
        int choice = getChoice(1, cards.size(), prompt);
        return cards.get(choice - 1);
    }

    public BaseCard getCardChoice(BaseCard[] cards, Runnable prompt) {
        int choice = getChoice(1, cards.length, prompt);
        return cards[choice - 1];
    }

    public ArrayList<BaseCard> getDeckChoice(List<ArrayList<BaseCard>> decks, Runnable prompt) {
        int choice = getChoice(1, decks.size(), prompt);
        return decks.get(choice - 1);
    }
}
