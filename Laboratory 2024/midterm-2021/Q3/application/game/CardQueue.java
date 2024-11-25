package application.game;

import application.util.CloneUtil;
import logic.card.BaseCard;

public class CardQueue {
    private int position;
    private int turn;
    private BaseCard playCard;

    public CardQueue(int position, int turn, BaseCard playCard) {
        this.position = position;
        this.turn = turn;
        this.playCard = CloneUtil.clone(playCard);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public BaseCard getPlayCard() {
        return playCard;
    }

    public void setPlayCard(BaseCard playCard) {
        this.playCard = playCard;
    }
}
