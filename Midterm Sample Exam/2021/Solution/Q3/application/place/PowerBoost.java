package application.place;

import application.game.GameManager;
import application.util.ChoiceUtil;
import application.util.StringUtil;
import logic.card.BaseCard;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class PowerBoost extends Place{

    private boolean power;

    public PowerBoost(boolean power) {
        super("Charger");
        this.power = power;
    }

    public PowerBoost(String name, boolean power) {
        super(name);
        this.power = power;
    }

    @Override
    public void run() {
        out.println("You walk to Charger, you can charge your unit to make its more powerful");
        ArrayList<BaseCard> bcl = GameManager.getPlayerDeck().getDeckList();
        int choice = new ChoiceUtil(out, new Scanner(System.in)).getChoice(1, bcl.size(), this::printPrompt, n->bcl.get(n-1).getName());
        BaseCard bc = bcl.get(choice-1);
        if (power){
            bc.setPower(bc.getPower()+1);
            out.println("Upgrade attack power for " + bc.getName() + " to " + bc.getPower());
        }else{
            bc.setHealth(bc.getHealth()+1);
            out.println("Upgrade health point for " + bc.getName() + " to " + bc.getHealth());
        }
    }

    void printPrompt(){
        if (power){
            out.println("Pick card to +1 attack power");
        }else{
            out.println("Pick card to +2 health point");
        }
        StringUtil.printChoice(GameManager.getPlayerDeck().getDeckList());
    }
}
