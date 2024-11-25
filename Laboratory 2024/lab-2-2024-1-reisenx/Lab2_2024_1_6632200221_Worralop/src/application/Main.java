package application;

import monkey.*;
import logic.game.GameSystem;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static int playerTurnState; // 0 = showMonkey, 1 = showAction, 2 = attack, 3 = skill
    private static GameSystem gs = GameSystem.getInstance();

    //TODO: add More Text to discribe each action in terminal
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println(" Welcome To Lopburi...The monkey needs your help defeating the Apes! ");
        sc = new Scanner(System.in);
        //!gs.isGameEnd()
        while (true) {
            System.out.println("======================================================================");
            int amount = gs.getMonkeyContainer().size();
            if (amount == 3) {
                System.out.println("If you want to reselect the monkeys please press <0>.");
            } else {
                System.out.println("Please select 3 monkeys before start the game.");
            }
            System.out.println("<0> Select Monkeys for your team");
            System.out.println("<1> START GAME");
            System.out.println("======================================================================");
            int choice = inputCheck(0, 1);
            if (choice == 0) {
                gs.getMonkeyContainer().clear();
                for (int i = 0; i < 3; i++) {
                    ArrayList<String> lst = new ArrayList<>();
                    lst.add("first");
                    lst.add("second");
                    lst.add("third");
                    System.out.println("======================================================================");
                    System.out.println("please select your " + lst.get(i) + " monkey.");
                    selectMonkeyFlow();
                }
                System.out.println("======================================================================");
                System.out.print("Our Army:\n");
                for (BaseMonkey m : gs.getMonkeyContainer()) {
                    System.out.println(m.toString());
                }
            } else if (choice == 1) {
                System.out.println("<1> START GAME");
                startGameFlow();
                if (gs.isGameEnd()) break;
            }
        }
        System.out.println("---------- Game is Over -----------");
    }

    public static void selectMonkeyFlow() {
        System.out.println("<0> BaseMonkey");
        System.out.println("<1> MuscleMonkey");
        System.out.println("<2> MommyMonkey");
        System.out.println("<3> UgabugagaMonkey");
        System.out.println("======================================================================");
        int choice = inputCheck(0, 3);

        switch (choice) {
            case 0 -> gs.getMonkeyContainer().add(new BaseMonkey(100, 15, 10));
            case 1 -> gs.getMonkeyContainer().add(new MuscleMonkey(200, 20, 10));
            case 2 -> gs.getMonkeyContainer().add(new MommyMonkey(80, 0, 10));
            case 3 -> gs.getMonkeyContainer().add(new UgabugagaMonkey(80, 10, 15));
        }
    }

    public static void startGameFlow() {
        while (!gs.isGameEnd()) {
            //playerTurn
            gs.setSp(5);
            BaseMonkey ChosenMonkey = new BaseMonkey();
            while (gs.getSp() > 0) {
                switch (playerTurnState) {
                    case 0 -> ChosenMonkey = showSelectedMonkey();
                    // showAction
                    case 1 -> showAction(ChosenMonkey);
                    // show enemy list input enemy to hit then perform BaseMonkey.attack()
                    case 2 -> attackFlow(ChosenMonkey);
                    // show skill flow for each MonkeyType
                    case 3 -> skillFlow(ChosenMonkey);

                }
                //removeDeadApe
                gs.removeDeadEntity(gs.getApeContainer());
                if (gs.getApeContainer().isEmpty()) {
                    System.out.println("The Apes has been DEFEATED!! Lopburi is now under Monkey's reign!!");
                    gs.setGameEnd(true);
                    break;
                }

            }

            //enemyTurn (loop Through each Ape and randomly attack the Monkey)
            int index = 0;
            for (BaseMonkey ape : gs.getApeContainer()) {

                int randomIndex = (int) (Math.random() * (gs.getMonkeyContainer().size() - 1));
                BaseMonkey targetMonkey = gs.getMonkeyContainer().get(randomIndex);
                double skillChance = Math.random() * 100;
                if (skillChance < 30) { // a 30% chance to use spacial attack AOE attack
                    System.out.println("Ape " + "<" + index + "> attack all of your monkey!");
                    ((Ape) ape).attackAOE();
                } else {
                    System.out.println("Ape " + "<" + index + "> attack your <" + randomIndex + "> " + targetMonkey.getType());
                    ape.attack(targetMonkey);

                }

                gs.removeDeadEntity(gs.getMonkeyContainer());

                if (gs.getMonkeyContainer().isEmpty()) {
                    System.out.println("The Monkeys has been DEFEATED!! Lopburi will never be the same...");
                    gs.setGameEnd(true);
                    break;
                }
                index++;
            }

        }

    }

    public static BaseMonkey showSelectedMonkey() {
        System.out.println("======================================================================");
        System.out.println("Select your monkey to do action.");
        System.out.println("Your remaining skill point: " + gs.getSp());
        ArrayList<BaseMonkey> monkeys = gs.getMonkeyContainer();
        for (int i = 0; i < monkeys.size(); i++) {
//            System.out.println("<" + i + "> " + monkeys.get(i).getType());
            System.out.println("<" + i + ">" + monkeys.get(i));
        }
        System.out.println("<" + monkeys.size() + ">End turn.");
        System.out.println("======================================================================");
        int choice = inputCheck(0, monkeys.size());
        if (choice == monkeys.size()) {
            gs.setSp(0);
            return null;
        } else {
            playerTurnState = 1;
        }
        return gs.getMonkeyContainer().get(choice);
    }

    public static void showAction(BaseMonkey monkey) { //state 1
        System.out.println("======================================================================");
        System.out.println("Please select action.");
        System.out.println("<0>Attack.");
        System.out.println("<1>Special skill.");
        System.out.println("<2>go back.");
        System.out.println("======================================================================");
        int choice = inputCheck(0, 2);
        if (choice == 0) {
            playerTurnState = 2;
        } else if (choice == 1) {
            if (monkey.getType().equals("BaseMonkey")) {
                System.out.println("======================================================================");
                System.out.println("Normal monkey doesn't have special skill!");
            } else if (gs.getSp() < 2) {
                System.out.println("Not enough skill point!");
            } else {
                playerTurnState = 3;
            }
        } else if (choice == 2) {
            playerTurnState = 0;
        }
    }

    public static void attackFlow(BaseMonkey m) {
        System.out.println("======================================================================");
        System.out.println("Select ape you want to attack.");
        ArrayList<BaseMonkey> apeContainer = gs.getApeContainer();
        for (int i = 0; i < apeContainer.size(); i++)
            System.out.println("<" + i + ">" + apeContainer.get(i));
        System.out.println("======================================================================");
        int choice = inputCheck(0, apeContainer.size() - 1);
        BaseMonkey ape = apeContainer.get(choice);
        int beforeAttack = ape.getHp();
        m.attack(ape);
        int afterAttack = ape.getHp();
        int dmg = beforeAttack - afterAttack;
        gs.setSp(gs.getSp() - 1);
        System.out.println("======================================================================");
        System.out.println(m.getType() + " has attacked <" + choice + "> " + ape.getType() + " with " + dmg + " damages!");
        System.out.println("======================================================================");
        playerTurnState = 0;
    }

    public static void skillFlow(BaseMonkey m) {
        if (m instanceof MuscleMonkey) {
            ((MuscleMonkey) m).buff();
            System.out.println("MuscleMonkey has buffed himself.");
        } else if (m instanceof MommyMonkey) {
            ((MommyMonkey) m).birth();
            System.out.println("======================================================================");
            System.out.println("MommyMonkey has given birth.");
            System.out.println("baby BaseMonkey is ready to fight.");
        } else if (m instanceof UgabugagaMonkey) {
            System.out.println("======================================================================");
            System.out.println("Choose our monkey to heal");
            ArrayList<BaseMonkey> monkeyContainer = gs.getMonkeyContainer();
            for (int i = 0; i < monkeyContainer.size(); i++)
                System.out.println("<" + i + ">" + monkeyContainer.get(i));

            int choice = inputCheck(0, monkeyContainer.size() - 1);
            BaseMonkey healedMonkey = monkeyContainer.get(choice);
            ((UgabugagaMonkey) m).heal(healedMonkey);
            System.out.println("======================================================================");

            System.out.println("UgabugagaMonkey has healed <" + choice + "> " + healedMonkey.getType());
        }
        gs.setSp(gs.getSp() - 2);
        playerTurnState = 0;
    }

    public static int inputCheck(int lowestInput, int highestInput) {
        int choice = sc.nextInt();
        while (choice < lowestInput || choice > highestInput) {
            System.out.println("Invalid input");
            choice = sc.nextInt();
        }
        return choice;
    }
}