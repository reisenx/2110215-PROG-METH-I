package application.util;

import application.deck.Deck;
import logic.card.*;

import java.util.ArrayList;

public class CloneUtil {
    private static OrbCard orbCard = new OrbCard("",1,1,Element.EARTH);
    private static RobotCard robotCard = new RobotCard("", 1,2,3);
    private static MageCard mageCard = new MageCard("",1,2,Element.ICE);

    public static BaseCard clone(BaseCard bc){
        String name = bc.getName();
        int power = bc.getPower();
        int health = bc.getHealth();
        if(bc.getClass().equals(orbCard.getClass())){
            return new OrbCard(name,power,health, ((OrbCard) bc).getOrbType());
        }else if (bc.getClass().equals(robotCard.getClass())){
            return new RobotCard(name,power,health,((RobotCard) bc).getEnergyCost());
        }else if (bc.getClass().equals(mageCard.getClass())){
            return new MageCard(name,power,health,((MageCard) bc).getMageType());
        }
        return null;
    }

    public static Deck cloneDeck(Deck d){
        ArrayList<BaseCard> tempDeck = new ArrayList<>();
        for (BaseCard bc: d.getDeckList()){
            tempDeck.add(clone(bc));
        }
        return new Deck(d.getName(),tempDeck);
    }


}
