package application.place;

import application.deck.PremadeDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlacesList {
    static PowerBoost buffPower = new PowerBoost(true);
    static PowerBoost buffHealth = new PowerBoost(false);
    static AddCard addCard = new AddCard();
    static Merger merger = new Merger();
    static Encounter encounter1 = new Encounter(PremadeDeck.enemy1);
    static Encounter encounter2 = new Encounter(PremadeDeck.enemy2);
    static Encounter encounter3 = new Encounter(PremadeDeck.enemy3);
    static Encounter encounter4 = new Encounter(PremadeDeck.enemy4);
    static Encounter encounter5 = new Encounter(PremadeDeck.enemy5);
    static Encounter boss1 = new Encounter(PremadeDeck.boss1);
    private static Place[][] placeList = {
            getPlaceZone(),
            getPlaceZone(),
            {encounter1},
            getPlaceZone(),
            getPlaceZone(),
            {encounter2, encounter3},
            getPlaceZone(),
            getPlaceZone(),
            {encounter4, encounter5},
            getPlaceZone(),
            {merger, addCard, new PowerBoost(new Random().nextBoolean())},
            {boss1}
    };

    static Place[] getPlaceZone(){
        Random rand = new Random();
        ArrayList<Place> zone = new ArrayList<>(List.of(addCard, merger, (rand.nextBoolean()?buffPower:buffHealth)));
        zone.remove(rand.nextInt(zone.size()));
        return zone.toArray(new Place[0]);
    }
    public static Place[][] getPlaceList() {
        return placeList;
    }
}
