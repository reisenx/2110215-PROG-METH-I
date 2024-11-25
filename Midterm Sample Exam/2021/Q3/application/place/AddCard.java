package application.place;

import application.deck.PremadeDeck;
import application.game.GameManager;
import application.util.ChoiceUtil;
import application.util.StringUtil;
import logic.card.BaseCard;

import java.util.Scanner;

import static java.lang.System.out;

public class AddCard extends Place{
    public AddCard() {
        super("Card Center");
    }

    @Override
    public void run() {
        out.println("You walk into Card Center, you can pick type of card you want to add to your deck");
        int choice = new ChoiceUtil(out, new Scanner(System.in)).getChoice(1, 3, this::printPrompt, this::getCardType);
        BaseCard bc = PremadeDeck.getRandomCard(choice);
        out.println("You add " + StringUtil.getString(bc) + " to your deck");
        GameManager.getPlayerDeck().getDeckList().add(bc);
    }

    void printPrompt(){
        out.println("Pick card type you want to add");
        out.println("1: Orb Card");
        out.println("2: Robot Card");
        out.println("3: Mage Card");
    }

    String getCardType(int n){
        if (n==1){
            return "Orb Card";
        }else if (n==2){
            return "Robot Card";
        }else if (n==3){
            return "Mage Card";
        }
        return "";
    }
}
