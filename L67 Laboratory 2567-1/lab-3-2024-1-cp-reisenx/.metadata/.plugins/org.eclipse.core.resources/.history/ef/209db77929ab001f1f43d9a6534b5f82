package logic.game;

import java.util.ArrayList;
import logic.actor.Actor;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.GameUtils;

public class GameController {
    
    private int hp;
    private int score;
    private static GameController instance;
    private ArrayList <Actor> actors;
    private ArrayList <Ghost> ghosts;
    private ArrayList <Item> items;
    
    public GameController() {
        
        this.actors = new ArrayList <Actor> ();
        this.ghosts = new ArrayList <Ghost> ();
        this.items = new ArrayList <Item> ();

        initGame();
        
    }
    
    public static GameController getInstance() {
        if(instance == null)
            instance = new GameController();
        return instance;
    }
    
    // Implement play()
    public void play(Actor selectedActor) {
        // Activate all item in items list
    	for(Item item : getInstance().getItems()) {
    		item.effect();
    	}
    	// Assign local variable as the first ghost
    	Ghost ghost = getInstance().getGhosts().get(0);
    	// Current ghost attacks
    	ghost.attack();
    	// Actor attack ghost
    	selectedActor.attack();
    	// Remove dead ghost and increase player's score
    	int RemovedGhost = 0;
    	for(int i = getInstance().getGhosts().size() - 1 ; i >= 0; i--) {
    		if(getInstance().getGhosts().get(i).getHp() <= 0) {
    			int PlayerScore = getInstance().getScore();
    			int GhostLevel = getInstance().getGhosts().get(i).getLevel();
    			getInstance().setScore(PlayerScore + GhostLevel);
    			getInstance().getGhosts().remove(i);
    			RemovedGhost++;
    		}
    	}
    	// Add new ghosts
    	for(int i = 0; i < RemovedGhost; i++) {
    		GameUtils.getRandomGhost(true);
    	}
    }
    
    public void updateGameController() {
        GameIO.showGameState();
        GameIO.showCurrentGhost(ghosts);
        Actor selectedActor = GameIO.selectActor(this.actors);
        GameIO.showItemList(this.items);
        play(selectedActor);
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getScore() {
        return score;
    }
    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void addNewActor(Actor actor) {
        this.actors.add(actor);
    }
    public void addNewItem(Item item) {
        this.items.add(item);
    }
    public void addNewGhost(Ghost ghost) {
        this.ghosts.add(ghost);
    }
    
    // Implement initGame()
    public void initGame() {
    	this.setHp(10);
    	this.setScore(0);
    	this.addNewActor(new Villager());
    	for(int i = 0; i < 10; i++) {
    		GameUtils.getRandomGhost(false);
    	}
    }
    
    // Implement isGameOver()
    public boolean isGameOver() {
    	return this.actors.isEmpty()|| this.getHp() <= 0;
    }
}