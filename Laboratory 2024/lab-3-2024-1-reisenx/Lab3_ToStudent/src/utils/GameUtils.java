package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Monk;
import logic.actor.Monkey;
import logic.actor.Villager;
import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.Ghost;
import logic.ghost.MaBongGhost;
import logic.ghost.PongGhost;
import logic.ghost.PooYaGhost;
import logic.ghost.PryGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import logic.item.Leklai;

public class GameUtils {
	
	
	public static Ghost getNewGhost(int x) {
		Random rand = Randomizer.getRandomizer();
		Ghost GaGhost = new GaGhost(1 + rand.nextInt(6));
		Ghost MaBongGhost = new MaBongGhost(1 + rand.nextInt(4), 1);
		Ghost PongGhost = new PongGhost(1 + rand.nextInt(2));
		Ghost PooYaGhost = new PooYaGhost(1 + rand.nextInt(2));
		Ghost PryGhost = new PryGhost(1 + rand.nextInt(3),rand.nextInt(1));
		
		ArrayList<Ghost> GhostList = new ArrayList<Ghost>(Arrays.asList(GaGhost, MaBongGhost, PongGhost, PooYaGhost, PryGhost));
		
		return GhostList.get(x);
		
	}
	public static Ghost getRandomGhost(boolean isAcceptHighGhost) {
		Random rand = Randomizer.getRandomizer();
		int x = rand.nextInt(5);
		while(!isAcceptHighGhost && (x == 3 || x == 2)) x = rand.nextInt(5);
		return getNewGhost(x);
	}
	
	public static Actor getNewActor(int x) {
		Random rand = Randomizer.getRandomizer();
		Actor villager = new Villager();
		Actor monk = new Monk();
		Actor ghostDoctor = new GhostDoctor();
		Actor monkey = new Monkey();
		
		ArrayList<Actor> ActorList = new ArrayList<Actor>(Arrays.asList(villager, monk, ghostDoctor, monkey));
		
		
		GameController.getInstance().setScore(GameController.getInstance().getScore() - ActorList.get(x).getLevel());
		
		return ActorList.get(x);
		
	}
	public static Item getNewItem(int x) {
		Random rand = Randomizer.getRandomizer();
		Item amulet = new Amulet();
		Item banana = new Banana();
		Item leklai = new Leklai();
		
		ArrayList<Item> ItemList = new ArrayList<Item>(Arrays.asList(amulet, banana, leklai));		
		return ItemList.get(x);
	}
}
