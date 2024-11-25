package application.place;

import application.ShopApp;
import application.game.GameManager;
import application.util.StringUtil;

import java.io.PrintStream;
import java.util.Scanner;

public class Places extends ShopApp {
    public Places(PrintStream out, Scanner in) {
        super(out, in);
    }

    public void run() {
        Place[] placeList = PlacesList.getPlaceList()[GameManager.getStage()];
        int choice = this.getChoice(1, placeList.length+1, true, this::prompt,n->{
            String s = (n - 1) < placeList.length ? placeList[n - 1].getName() : "View Deck";
            return s;
        })-1;
        while (choice>=placeList.length){
            StringUtil.printChoice(GameManager.getPlayerDeck().getDeckList());
            choice = this.getChoice(1, placeList.length+1, true, this::prompt,n->{
                String s = (n - 1) < placeList.length ? placeList[n - 1].getName() : "View Deck";
                return s;
            })-1;
        }
        placeList[choice].run();
        GameManager.increaseStage();
    }

    public void prompt(){
        Place[] placeList = PlacesList.getPlaceList()[GameManager.getStage()];
        out.println("Select Place :");
        StringUtil.printChoice(placeList);
        out.println(placeList.length+1 + ": View Deck");
    }
}
