package logic.player;

import logic.card.BaseCard;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private int damage;
    private ArrayList<BaseCard> deck;
    private ArrayList<BaseCard> hand;
    private ArrayList<BaseCard> field;
    private int energy;

    public Player() {
        this(new ArrayList<BaseCard>());
    }

    public Player(ArrayList<BaseCard> deck) {
        this.damage = 0;
        this.deck = deck;
        this.field = new ArrayList<BaseCard>(Arrays.asList(null, null, null, null));
        this.hand = new ArrayList<BaseCard>();
        this.energy = 0;
    }

    public boolean playCard(int indexHand, int position){
        BaseCard bc = getHand().get(indexHand);
        if (getField().get(position)==null) {
            bc.play(this);
            getField().set(position, bc);
            getHand().remove(indexHand);
            return true;
        }
        return false;
    }

    public void drawCard(){
        getHand().add(getDeck().remove(0));
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ArrayList<BaseCard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<BaseCard> deck) {
        this.deck = deck;
    }

    public ArrayList<BaseCard> getHand() {
        return hand;
    }

    public void setHand(ArrayList<BaseCard> hand) {
        this.hand = hand;
    }

    public ArrayList<BaseCard> getField() {
        return field;
    }

    public void setField(ArrayList<BaseCard> field) {
        this.field = field;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy<0) energy=0;
        this.energy = energy;
    }
}
