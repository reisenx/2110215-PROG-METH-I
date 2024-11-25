package application.game;

import logic.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends Player {

    private String name;
    private ArrayList<CardQueue> queue;

    public Enemy() {
        this("Enemy", new ArrayList<>());
    }
    public Enemy(String name, ArrayList<CardQueue> queue) {
        this.name = name;
        this.queue = queue;
        setHand(new ArrayList<>(Arrays.asList(null, null, null, null)));
    }

    public ArrayList<CardQueue> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<CardQueue> queue) {
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

