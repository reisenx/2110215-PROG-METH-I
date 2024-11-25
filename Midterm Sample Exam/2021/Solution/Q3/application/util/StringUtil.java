package application.util;

import application.deck.Deck;
import application.place.Place;
import logic.card.BaseCard;
import logic.card.MageCard;
import logic.card.OrbCard;
import logic.card.RobotCard;

import java.util.ArrayList;

public class StringUtil {
    public static <T> void printChoice(ArrayList<T> l){
        for (int i=0;i<l.size();i++){
            System.out.println((i+1) + ": " + getString(l.get(i)));
        }
    }

    public static <T> void printChoice(T[] l){
        for (int i=0;i<l.length;i++){
            System.out.println((i+1) + ": " + getString(l[i]));
        }
    }

    public static String getString(Object o){
        if (o instanceof Place){
            return ((Place) o).getName();
        }else if (o instanceof BaseCard){

            return getTypeDisplay(((BaseCard) o)) + " ATK:" + ((BaseCard) o).getPower() + " HP:" + ((BaseCard) o).getHealth();
        }else if (o instanceof Deck){
            return ((Deck) o).getName();
        }
        return "";
    }

    public static String getTypeDisplay(BaseCard bc){
        if (bc instanceof OrbCard){
            return bc.getName() + " (" + ((OrbCard) bc).getOrbType().toString() +" ORB)";
        }else if (bc instanceof RobotCard){
            return bc.getName() + " (Energy Cost:" + ((RobotCard) bc).getEnergyCost()+ ")";
        }else if (bc instanceof MageCard){
            return bc.getName() + " (" + ((MageCard) bc).getMageType().toString() +" MAGE)";
        }
        return "";
    }
}
