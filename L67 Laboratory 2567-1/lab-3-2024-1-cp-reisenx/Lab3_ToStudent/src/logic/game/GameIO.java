package logic.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import logic.actor.Actor;
import logic.actor.Monk;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.Config;
import utils.GameUtils;

public class GameIO {
	private static final Scanner sc = new Scanner(System.in);
	
	public static Actor selectActor(ArrayList<Actor> actors){
		Actor selectedActor = null;
		int x;
		System.out.print("\n==========Your Actors==========\n");
		for(int i = 0;i < actors.size();++i) {
			System.out.print("<" + i + "> " + actors.get(i).toString() + "\n");
		}
		System.out.print("<" + actors.size() + "> " + "for get a new actor" + "\n");
		
		while (true) {
            try {
            	System.out.print("Please Select Your Actor : ");
            	x = sc.nextInt();
                if (x > actors.size())
                    throw new InputMismatchException();
                else {
                	break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
        }
		
		if(x == actors.size()) {
			buyNewActor();
			return selectActor(actors);
		}
		
		selectedActor = actors.get(x);
		return selectedActor;
	}
	public static void showItemList(ArrayList<Item> items){
		int x;
		System.out.print("\n==========Your Items==========\n");
		for(int i = 0;i < items.size();++i) {
			System.out.print("<" + i + "> " + items.get(i).toString() + "\n");
		}
		System.out.print("<" + items.size() + "> " + "for get a new item" + "\n");
		System.out.print("Or press other key for continue : ");
        x = sc.nextInt();
        if(x == items.size()) {
        	buyNewItem();
        }
	}
	
	public static void showCurrentGhost(ArrayList<Ghost> ghosts) {
		Actor selectedActor = null;
		System.out.print("Current Ghost => \n" + ghosts.get(0).toString() + "\n");
	}
	public static void showGameState() {
		System.out.println("\n\u001B[32m================================\n"
				+ "	Your Score : " + GameController.getInstance().getScore() + "	       \n"
				+ " 	Your HP	   : " + GameController.getInstance().getHp()    + "	       \n"
				+ "================================\u001B[0m\n");
	}
	public static void buyNewActor() {
		int x;
		System.out.print("==========Actor Shop==========\n"
				+ "The Cost of Actor is Actor Level. Your score will be reduced.\n"
				+ "<0> Villager " + Config.VillagerLevel + "\n"
				+ "<1> Monk " + Config.MonkLevel + "\n"
				+ "<2> GhostDoctor " + Config.GhostDoctorLevel + "\n"
				+ "<3> LopburiMonkey " + Config.MonkeyLevel + "\n");
		
		while (true) {
            try {
            	System.out.print("Please Select Your New Actor : ");
            	x = sc.nextInt();
                if (x > 3)
                    throw new InputMismatchException();
                else {
                	break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
        }
		Actor newActor = GameUtils.getNewActor(x);
		if(GameController.getInstance().getScore() < newActor.getLevel()) {
			System.out.println("!!!Cannot buy a new actor!!!\n");
			return;
		}
		GameController.getInstance().addNewActor(newActor);
		GameController.getInstance().setScore(GameController.getInstance().getScore() - newActor.getLevel());
		GameIO.showGameState();
	}
	
	public static void buyNewItem() {
		int x;
		System.out.print("==========Item Shop==========\n"
				+ "The Cost of Item is Item Level. Your score will be reduced.\n"
				+ "<0> Amulet " + Config.AmuletLevel + "\n"
				+ "<1> Banana " + Config.BananaLevel + "\n"
				+ "<2> Leklai " + Config.LeklaiLevel + "\n");
		
		while (true) {
            try {
            	System.out.print("Please Select Your New Item : ");
            	x = sc.nextInt();
                if (x > 2)
                    throw new InputMismatchException();
                else {
                	break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
        }
		Item newItem = GameUtils.getNewItem(x);
		if(GameController.getInstance().getScore() < newItem.getLevel()) {
			System.out.println("!!!Cannot buy a new item!!!\n");
			return;
		}
		GameController.getInstance().addNewItem(newItem);
		GameController.getInstance().setScore(GameController.getInstance().getScore() - newItem.getLevel());
		
		GameIO.showGameState();
		
	}
}
