package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import utils.Config;

public class Banana extends Item{

	@Override
	public void effect() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			System.out.print(ghost + " ");
		}
		System.out.print("\n");
	}
	
	//TODO implements here
}
