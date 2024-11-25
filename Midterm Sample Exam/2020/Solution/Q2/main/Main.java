package main;

import java.util.ArrayList;
import java.util.Scanner;

import logic.monster.Leader;
import logic.monster.Monster;

public class Main {

	
	
	private static ArrayList<Monster> playerParty;
	private static ArrayList<Monster> enemyParty;
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initParty();
		System.out.println("Creatures of ProgMeth");
		
		while(true){
			
			System.out.println("===============================");
			System.out.println("Player's Party.");
			BattleUtil.printParty(playerParty);
			System.out.println("===============================");
			System.out.println("Enemy's Party.");
			BattleUtil.printParty(enemyParty);
			System.out.println("===============================");
			System.out.println("What are you going to do?");
			System.out.println("1) Make a Move");
			System.out.println("2) Guard");
			System.out.println("3) Skip Turn");
			int choice = getChoiceInput();
			System.out.println(choice);
			switch(choice) {
			case 1:
				playerMoveSelect();
				break;
			case 2:
				playerGuard();
				break;
			default:
				System.out.println("Error: Invalid Choice. Skipping this turn...");
				break;
			}
			System.out.println("-------------");
			System.out.println("Enemy's Turn");
			System.out.println("-------------");
			enemyTurns();
			System.out.println("-------------");
			System.out.println("Press Enter to Continue");
			sc.nextLine();
			if(!manageTurnsEnd()) {
				break;
			}
		}
	}

	private static void playerMoveSelect() {
		System.out.println("Choose which monster to make a move.");
		BattleUtil.printParty(playerParty);
		int choice = getChoiceInput();
		System.out.println("===============================");
		System.out.println("Choose which monster to attack.");
		BattleUtil.printParty(enemyParty);
		int choice2 = getChoiceInput();
		
		try {
			performAttack(playerParty.get(choice-1),enemyParty.get(choice2-1));
		}catch(Exception e) {
			System.out.println("Error: Invalid Choice. Skipping this turn...");
		}
	}
	
	private static void playerGuard() {
		Leader l = (Leader) playerParty.get(0);
		leaderGuard(l);
	}
	
	private static void leaderGuard(Leader l) {
		l.setGuard(true);
		System.out.println(l.getName()+" raise up the guard!");
	}
	
	private static void enemyTurns() {
		Monster user = BattleUtil.getRandomMonster(enemyParty,true);
		Monster target = BattleUtil.getRandomMonster(playerParty,false);
		
		performAttack(user,target);
	}
	
	private static void performAttack(Monster user,Monster target) {
		
		if(!user.isReady()) {
			Leader l = (Leader) user; 
			int turnsleft = l.getMaxChargeTurns()-l.getCurrentChargeTurns();
			System.out.println(user.getName()+" cannot attack!\nIt needed "+turnsleft+" "+(turnsleft>1?"turns":"turn")+" more to charge!");
			return;
		}
		
		user.setAttackedStatus(true);
		
		int damage = target.takeDamage(user.getAttack());
		System.out.println(user.getName()+" attacks "+target.getName()+"!");
		if(damage>0) {
			System.out.println(target.getName()+" takes "+damage+" damage!");
			
			if(target.isDead()) {
				System.out.println(target.getName()+" is defeated!");
			}
		}else {
			System.out.println(target.getName()+" takes no damage!");
		}
	}
	
	private static int getChoiceInput() {
		System.out.print(">> ");
		int answer = sc.nextInt();
		sc.nextLine();
		return answer;
	}
	
	private static void initParty() {
		playerParty = BattleUtil.getStartingPlayerParty();
		
		enemyParty = BattleUtil.getStartingEnemyParty();
	}
	
	private static boolean manageTurnsEnd() {
		
		boolean playerDead = false;
		boolean enemyDead = false;
		
		//player's side
		Leader l = (Leader) playerParty.get(0);
		if(l.isDead()) {
			playerDead = true;
		}
		if(l.isGuard()) {
			l.setGuard(false);
		}else{

			if(!l.getAttackedStatus()) {
				l.setCurrentChargeTurns(l.getCurrentChargeTurns()+1);
			}else {
				l.setCurrentChargeTurns(0);
			}
		}
		
		//enemy's side
		l = (Leader) enemyParty.get(0);
		if(l.isDead()) {
			enemyDead = true;
		}
		if(l.isGuard()) {
			l.setGuard(false);
		}else{

			if(!l.getAttackedStatus()) {
				l.setCurrentChargeTurns(l.getCurrentChargeTurns()+1);
			}else {
				l.setCurrentChargeTurns(0);
			}
		}
		
		//unmarked every monster's attack state
		for(Monster m:playerParty) {
			m.setAttackedStatus(false);
		}
		for(Monster m:enemyParty) {
			m.setAttackedStatus(false);
		}
		
		BattleUtil.clearDeadMonster(playerParty);
		BattleUtil.clearDeadMonster(enemyParty);
		
		
		if(playerDead&&enemyDead) {
			System.out.println("Game End! It's a Draw!");
			return false;
			
		}else if(playerDead) {
			System.out.println("Game End! Enemy Wins!");
			return false;
			
		}else if(enemyDead){
			System.out.println("Game End! Player Wins!");
			return false;
		}
		
		return true;
	}
}
