package application.deck;

import logic.card.BaseCard;

import java.util.ArrayList;

public class Deck {
    // TODO: constructor
    private String name;
    private ArrayList<BaseCard> deckList;

    public Deck(String name, ArrayList<BaseCard> deckList) {
        this.name = name;
        this.deckList = deckList;
    }

    public void insertCard(BaseCard card){
        deckList.add(card);
    }

    public BaseCard removeCard(int slotNumber){
        return deckList.remove(slotNumber);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("{").append(this.getName()).append("}")
                .append("(").append(this.getDeckList().size()).append(" deck size)")
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BaseCard> getDeckList() {
        return deckList;
    }

    public void setDeckList(ArrayList<BaseCard> deckList) {
        this.deckList = deckList;
    }

}
