package main;

import java.util.ArrayList;
import java.util.Random;

import logic.attack.Attack;
import logic.attack.SPAttack;
import logic.monster.Leader;
import logic.monster.Monster;

//This class offers Utility methods for battle system
public class BattleUtil {
	
	private static Random rng = new Random();
	
	public static ArrayList<Monster> getStartingPlayerParty(){
		ArrayList<Monster> party = new ArrayList<Monster>();
		//Leader
		party.add(new Leader("Zetterburn",20,4,3,new SPAttack(8,"Fire Blast",true),4));
		//Other 3 Random Monster
		party.add(new Monster("Porcuber",6,2,1,new Attack(3,"Scratch",false)));
		party.add(new Monster("Infernacal",10,2,3,new SPAttack(6,"Fire Beam",false)));
		party.add(new Monster("Blazeen",12,5,3,new SPAttack(4,"Eruption",false)));
		
		
		return party;
	}
	
	public static ArrayList<Monster> getStartingEnemyParty(){
		ArrayList<Monster> party = new ArrayList<Monster>();
		//Leader
		party.add(new Leader("Maypul",15,4,3,new Attack(7,"Leaf Blade",true),2));
		//Other 3 Random Monster
		party.add(new Monster("Leffox",8,4,3,new Attack(4,"Stick Bash",false)));
		party.add(new Monster("Folet",6,1,3,new SPAttack(6,"Razor Leaf",false)));
		party.add(new Monster("Boulderoar",14,5,3,new SPAttack(5,"Rock Slide",false)));
		
		
		return party;
	}
	
	public static String getMonsterStatDesc(Monster m) {
		String mainstat = m.getName()+"("+m.getHp()+"/"+m.getMaxhp()+"), DEF: "+m.getDefense()+", SPDEF: "+m.getSpecialDefense();
		if(m instanceof Leader) {
			//Leader-specific state. 
			Leader l = (Leader) m;
			mainstat = mainstat+", CHARGE("+l.getCurrentChargeTurns()+"/"+l.getMaxChargeTurns()+")";
		}
		return mainstat;
	}
	
	public static void printParty(ArrayList<Monster> party) {
		int stindx = 1;
		for(Monster m:party) {
			if(!m.isDead()) {
				System.out.println(stindx+") "+getMonsterStatDesc(m));
				stindx+=1;
			}
		}
	}
	
	public static Monster getRandomMonster(ArrayList<Monster> party,boolean isAttacker) {
		int idx;
		Monster m;
		while(true) {
			idx = rng.nextInt(party.size());
			m = party.get(idx);
			if(!m.isDead()&&(m.isReady()||!isAttacker)) {
			break;	
			}	
		}
		return m;
	}
	
	public static void clearDeadMonster(ArrayList<Monster> party) {
		party.removeIf(e -> e.isDead());
	}
}
