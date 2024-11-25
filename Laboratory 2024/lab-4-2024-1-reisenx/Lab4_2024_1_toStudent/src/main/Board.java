package main;

import item.base.BaseItem;
import item.base.BaseWeapon;
import item.weapon.Stick;
import player.Player;
import player.NegativePosException;
import table.BaseTable;
import table.Enchanter;
import table.Oven;
import table.Randomizer;

import java.util.*;

public class Board {

    private int turn;
    private final int MAX_TURN;

    private final ArrayList<Player> PLAYERS;
    private final HashMap<Integer, BaseTable> TABLES;
    private final HashSet<Integer> RANDOMIZER_POS;
    private final Random BOARD_DICE = new Random();
    private final Scanner boardScanner = new Scanner(System.in);

    public Board() throws NegativePosException {
        turn = 1;
        MAX_TURN = 40;

        PLAYERS = new ArrayList<>();
        Player p1 = new Player("P1");
        p1.getInventory().addItem(new Stick());
        Player p2 = new Player("P2");
        p2.getInventory().addItem(new Stick());
        PLAYERS.add(p1);
        PLAYERS.add(p2);

        TABLES = new HashMap<>();
        TABLES.put(2, new Oven());
        TABLES.put(6, new Enchanter());

        RANDOMIZER_POS = new HashSet<>();
        RANDOMIZER_POS.add(0);
        RANDOMIZER_POS.add(4);
        RANDOMIZER_POS.add(8);
    }

    public void startBoard() {
        do {
            for (Player p : PLAYERS) {
                System.out.println("=====================================");
                System.out.println(p.getName() + "'s turn");
                if (p.getHp() > 0) {
                    throwDice(p);
                    printBoard();
                    play(p);
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            turnPass();
            if (countAlivePlayers() <= 1) break;
        }
        while (turn - 1 < MAX_TURN);
        System.out.println("============== Game Ended ===============");
        int highestHp = 0;
        for (Player p : PLAYERS) {
            if (highestHp <= p.getHp()) {
                highestHp = p.getHp();
            }
        }
        System.out.println("Winner(s) :");
        for (Player p : PLAYERS) {
            if (p.getHp() == highestHp) {
                System.out.println(p.getName());
            }
        }
    }

    private int countAlivePlayers() {
        int count = 0;
        for (Player p : PLAYERS) {
            if (p.getHp() > 0) count++;
        }
        return count;
    }

    private void play(Player p) {
        if (RANDOMIZER_POS.contains(p.getPos())) {
            playerInteractRandomizer(p);
        }
        if (TABLES.get(p.getPos()) != null) {
            playerInteractTable(p);
        }
        playerUseInventory(p);
    }

    private void playerInteractRandomizer(Player p) {
        System.out.println("=====================================");
        System.out.println("Randomizer :");
        BaseItem newItem = Randomizer.instance.interact();
        System.out.println(p.getName() + " got a " + newItem.toString());
        p.getInventory().addItem(newItem);
        sleep(1000);
    }

    private void playerInteractTable(Player p) {
        BaseTable table = TABLES.get(p.getPos());
        System.out.println("=====================================");
        System.out.println("[ " + table.getName() + " ]");
        System.out.println("[ " + p.getName() + " inventory ]");
        if (!p.getInventory().getItems().isEmpty()) {
            System.out.println("select item to use with " + table.getName() + " (enter the number)");
            System.out.println("<-1> No");
            p.getInventory().printAllItem();
            String input = boardScanner.nextLine();
            try {
                int idx = Integer.parseInt(input);
                if (idx == -1) {
                    System.out.println("Skip!");
                }
                else {
                    System.out.println(table.interact(p.getInventory().getItems().get(idx)));
                }
            } catch (Exception e) {
                System.out.println("Unknown Input, skip using this table");
            }
        }
        else {
            System.out.println("Inventory is empty, skipping");
        }
        sleep(1000);

    }

    private void playerUseInventory(Player p) {
        System.out.println("=====================================");
        System.out.println("[ " + p.getName() + " Inventory ]");
        System.out.println("--------------Equipment--------------");
        p.printEquipment();
        System.out.println("-------------------------------------");
        if (!p.getInventory().getItems().isEmpty()) {
            System.out.println("select item to use (enter the number)");
            System.out.println("<-1> --SKIP--");
            p.getInventory().printAllItem();
            String input = boardScanner.nextLine();
            try {
                int idx = Integer.parseInt(input);
                if (idx == -1) {
                    System.out.println("Skip!");
                }
                else {
                    BaseItem item = p.getInventory().getItems().get(idx);
                    if (item instanceof BaseWeapon weapon) {
                        for (Player otherP : PLAYERS) {
                            if (p != otherP) {
                                System.out.println(p.useWeapon(weapon, otherP));
                            }
                        }
                    }
                    else {
                        System.out.println(p.useNonWeaponItem(item));
                    }
                }
            } catch (Exception e) {
                System.out.println("Unknown Input, skip using an item");
            }
            sleep(1000);
        }
        else {
            System.out.println(p.getName() + "'s inventory is empty, skip using an item");
            sleep(2000);
        }

    }

    private void printBoard() {
        System.out.println("=============== Board ===============");
        System.out.println("Turn : " + turn + "/" + MAX_TURN);
        System.out.println("=====================================");
        for (int i=0; i<9; i++) {
            String tb = "";
            if (TABLES.get(i) != null) {
                tb += TABLES.get(i).getName() + " ";
            }
            if (RANDOMIZER_POS.contains(i)) {
                tb += "Random ";
            }
            System.out.println("[" + i + "] " + tb );
            for (Player p : PLAYERS) {
                if (p.getPos() == i) {
                    System.out.println("  " + p.getName() + " (HP: " + p.getHp() + "/" + p.getMaxHp() + ", DEF: " + p.calculateDef()
                            + ((p.getBuffRemainingTurn() != 0) ? ", AttBuff +" + p.getAttBuffing() + " (" + p.getBuffRemainingTurn() + " turns))":")"));
                }
            }
        }

    }

    private void throwDice(Player p)  {
        int rolled_number = BOARD_DICE.nextInt(5) + 1;
        try {
            p.setPos((p.getPos() + rolled_number) % 9);
        } catch (NegativePosException e) {
            System.out.println("ERROR");
        }
        System.out.println("ROLLED : " + rolled_number);
        System.out.println(p.getName() + " move to position " + p.getPos());
    }

    private void turnPass() {
        for (Player p : PLAYERS) {
            p.setBuffRemainingTurn(p.getBuffRemainingTurn() - 1);
        }
        turn = turn + 1;
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
