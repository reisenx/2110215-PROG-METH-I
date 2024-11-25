package application;

import logic.game.GameController;

import java.util.*;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    	System.out.println("\u001B[31m!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\u001B[0m");
    	System.out.println("\u001B[31mo          `O    Oo    `OooOOo.  o.     O oO        o         Oo    o.oOOOo.         \r\n"
    			+ "O           o   o  O    o     `o Oo     o OO       O         o  O    o     o  .oOOo. \r\n"
    			+ "o           O  O    o   O      O O O    O oO       o        O    o   O     O       O \r\n"
    			+ "O           O oOooOoOo  o     .O O  o   o Oo       o       oOooOoOo  oOooOO.       o \r\n"
    			+ "o     o     o o      O  OOooOO'  O   o  O oO       O       o      O  o     `O   .oO  \r\n"
    			+ "O     O     O O      o  o    o   o    O O          O       O      o  O      o      o \r\n"
    			+ "`o   O o   O' o      O  O     O  o     Oo Oo       o     . o      O  o     .O      O \r\n"
    			+ " `OoO' `OoO'  O.     O  O      o O     `o oO       OOoOooO O.     O  `OooOO'  `OooO' ");
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    	System.out.println("                 ___-----------___\r\n"
    			+ " |  |    _-------_               _-------_    |  |\r\n"
    			+ " |  |  /~ OOOOOO  ~\\           /~ OOOOOO  ~\\  |  |\r\n"
    			+ "  ||  |OOO       0OOO|         |OOO       OOO|  ||\r\n"
    			+ "  || | OOO       OOOO|       |  OOO       OOO| ||\r\n"
    			+ "  || | OOO       0OOO|         |OOO       OOO| ||\r\n"
    			+ "  |   \\_ OOOOOOOOO /           \\OOOOOOOOO _/   |\r\n"
    			+ " |      ~~--_____-~    /~V~\\    ~-_____--~~      |\r\n"
    			+ " |                    |     |                    |\r\n"
    			+ "|                    |       |                    |\r\n"
    			+ "|                    |  /^\\  |                    |\r\n"
    			+ " |                    ~~   ~~                    |\r\n"
    			+ "  \\_         _                       _         _/\r\n"
    			+ "    ~--____-~ ~\\                   /~ ~-____--~\r\n"
    			+ "         \\     /\\                 /\\     /\r\n"
    			+ "          \\    | ( ,           , ) |    /\r\n"
    			+ "           |   | (~(__(  |  )__)~) |   |\r\n"
    			+ "            |   \\/ (  (~~|~~)  ) \\/   |\r\n"
    			+ "             |   |  [ [  |  ] ]  /   |\r\n"
    			+ "              |                     |\r\n");
    	System.out.println("=> Press any key for continue : \u001B[0m");
    	sc.nextLine();
    	GameController gameInstance = GameController.getInstance();
    	while(!gameInstance.isGameOver())
    		gameInstance.updateGameController();
        
        System.out.println("  _________    __  _____________ _    ____________ \r\n"
        		+ "  / ____/   |  /  |/  / ____/ __ \\ |  / / ____/ __ \\\r\n"
        		+ " / / __/ /| | / /|_/ / __/ / / / / | / / __/ / /_/ /\r\n"
        		+ "/ /_/ / ___ |/ /  / / /___/ /_/ /| |/ / /___/ _, _/ \r\n"
        		+ "\\____/_/  |_/_/  /_/_____/\\____/ |___/_____/_/ |_|  \r\n"
        		+ "                                                    ");
        
    }
}
