package application.place;

import application.game.CardQueue;
import application.game.Enemy;
import application.game.GameManager;
import application.util.ChoiceUtil;
import application.util.CloneUtil;
import application.util.StringUtil;
import logic.card.BaseCard;
import logic.card.MageCard;
import logic.card.OrbCard;
import logic.player.Player;

import java.util.*;

import static java.lang.System.out;

public class Encounter extends Place{
    private int round;
    private Enemy opponent;

    public Encounter(Enemy opponent) {
        this("Encounter");
        this.opponent = opponent;
    }

    public Encounter(String name) {
        super(name);
        this.round = 0;
    }

    boolean checkEnd(Player player){
        if (player.getDamage()-opponent.getDamage() >= 5){
            return true;
        }
        return opponent.getDamage() - player.getDamage() >= 5;
    }

    @Override
    public void run() {
        out.println("You encounter "+ opponent.getName());
        Player player = new Player(shuffle());
        for (int i=0;i<4;i++){
            if (player.getDeck().isEmpty()) break;
            player.drawCard();
        }
        while (!checkEnd(player)){
            placeIncoming(opponent);
            if (player.getDeck().isEmpty()) {
                out.println("No card left. Can't draw");
            } else {
                player.drawCard();
            }
            player.setEnergy(Math.min(6, round+1));
            playerTurn(player);
            out.println("====================Player Attack====================");
            attack(player, opponent);
            clearDeathCard(opponent.getField());
            clearDeathCard(opponent.getHand());
            if (checkEnd(player)) {
                break;
            }
            moveIncoming(opponent);
            out.println("====================Enemy Attack====================");
            attack(opponent, player);
            clearDeathCard(player.getField());
            round++;
        }
        if (opponent.getDamage()>player.getDamage()){
            out.println("You win, continue to next place");
        }else{
            GameManager.setLife(GameManager.getLife()-1);
            out.println("Player lose 1 life, " + GameManager.getLife() + " Life left.");
        }
    }

    ArrayList<BaseCard> shuffle(){
        Random rand = new Random();
        ArrayList<BaseCard> tempDeck = CloneUtil.cloneDeck(GameManager.getPlayerDeck()).getDeckList();
        ArrayList<BaseCard> playerDeck = new ArrayList<>();
        while (!tempDeck.isEmpty()){
            playerDeck.add(tempDeck.remove(rand.nextInt(tempDeck.size())));
        }
        return playerDeck;
    }

    void moveIncoming(Enemy opponent){
        for(int i=0;i<opponent.getField().size();i++){
            if (opponent.getField().get(i) == null){
                opponent.getField().set(i, opponent.getHand().get(i));
                opponent.getHand().set(i, null);
            }
        }
    }

    void placeIncoming(Enemy opponent){
        for (int i=0;i<opponent.getQueue().size();i++){
            if( opponent.getQueue().get(i).getTurn() > round) break;
            CardQueue cq = opponent.getQueue().get(i);
            if (opponent.getHand().get(cq.getPosition()) == null){
                opponent.getHand().set(cq.getPosition(), CloneUtil.clone(cq.getPlayCard()));
                opponent.getQueue().remove(i);
                i--;
            }
        }
    }

    void printBoardStatus(Player player) {
        out.println("====================Board Status=========================");
        //Enemy Role
        out.println(opponent.getName() + " Damage: " + opponent.getDamage());
        printCardRow(opponent.getHand());
        out.println();
        printCardRow(opponent.getField());
        out.println("-----------------------");
        //Player Role
        printCardRow(player.getField());
        out.println("Player Damage:" + player.getDamage());
        out.println("Energy: " + player.getEnergy());
        out.println("========================================================");
    }

    void printCardRow(ArrayList<BaseCard> cardList){
        out.println("|" + printCardNameOnBoard(cardList.get(0)) + "| " +
                "|" + printCardNameOnBoard(cardList.get(1)) + "| " +
                "|" + printCardNameOnBoard(cardList.get(2)) + "| " +
                "|" + printCardNameOnBoard(cardList.get(3)) + "|");
        out.println("|"+printCardElementOnBoard(cardList.get(0))+"| |"+
                printCardElementOnBoard(cardList.get(1)) +"| |"+
                printCardElementOnBoard(cardList.get(2))+"| |"+
                printCardElementOnBoard(cardList.get(3))+"|");
        out.println("|" + printCardStatOnBoard(cardList.get(0)) + "| " +
                "|" + printCardStatOnBoard(cardList.get(1)) + "| " +
                "|" + printCardStatOnBoard(cardList.get(2)) + "| " +
                "|" + printCardStatOnBoard(cardList.get(3)) + "|");
    }

    String printCardElementOnBoard(BaseCard bc){
        if (bc instanceof MageCard){
            return "-" + ((MageCard) bc).getMageType().toString().charAt(0) + "-";
        }else if (bc instanceof OrbCard){
            return "(" + ((OrbCard) bc).getOrbType().toString().charAt(0) + ")";
        }
        return "   ";
    }

    String printCardNameOnBoard(BaseCard bc) {
        if(bc!=null)
            return String.format("%3.3s", bc.getName());
        else return "   ";
    }
    String printCardStatOnBoard(BaseCard bc) {
        if(bc!=null)
            return (bc.getPower()) + " "
                    + (bc.getHealth());
        else return "   ";
    }

    void playerTurn(Player player){
        while (true){
            int choice = new ChoiceUtil(out, new Scanner(System.in)).getChoice(1, player.getHand().size()+1, ()->promptPlayerTurn(player,opponent), (n)->choicePlayerTurn(n-1,player))-1;
            if (choice>=player.getHand().size()) break;
            BaseCard playCard = player.getHand().get(choice);
            if (playCard.canPlay(player)){
                if (player.getField().stream().anyMatch(Objects::isNull)) {
                    while (true) {
                        int position = new ChoiceUtil(out, new Scanner(System.in)).getChoice(1, player.getField().size()+1, ()->promptPosition(player), this::choicePosition) - 1;
                        if (position>=player.getField().size()) break;
                        if (player.playCard(choice, position)) {
                            printBoardStatus(player);
                            break;
                        }else{
                            out.println("You can't place here");
                        }
                    }
                }else{
                    out.println("You can't place more card");
                }
            }else{
                out.println("You can't play that card now");
            }
        }
    }

    void promptPlayerTurn(Player player, Enemy opponent){
        printBoardStatus(player);
        out.println("Pick Card to play");
        StringUtil.printChoice(player.getHand());
        out.println((player.getHand().size()+1)+": End Turn");
    }

    String choicePlayerTurn(int idx, Player player){
        if (idx < player.getHand().size()){
            return player.getHand().get(idx).getName();
        }else{
            return "End Turn";
        }
    }

    void promptPosition(Player player){
        out.println("Pick Where to play");
        StringUtil.printChoice(player.getField());
        out.println((player.getField().size()+1)+": Back");
    }

    String choicePosition(int idx){
        if (idx < 5){
            return idx+"";
        }else{
            return "Back";
        }
    }

    void attack(Player p1, Player p2){
        for (int i=0;i<4;i++){
            if (p1.getField().get(i)==null) continue;
            BaseCard c1 = p1.getField().get(i);
            if (c1.getPower() ==0) continue;
            if (p2.getField().get(i) == null){
                p2.setDamage(p2.getDamage()+c1.getPower());
                if (p2 instanceof Enemy){
                    out.println("Spot " + (i+1) + ": Opponent taken " + c1.getPower() +" damage from "+  c1.getName());
                }else{
                    out.println("Spot " + (i+1) + ": Player taken " + c1.getPower() +" damage from "+  c1.getName());
                }
            }else{
                BaseCard c2 = p2.getField().get(i);
                int excess = c1.attack(c2);
                out.println("Spot " + (i+1) + ": " +c1.getName() + " attack " + c2.getName() + " with " + c1.getPower() + " damage.");
                if (p2 instanceof Enemy){
                    BaseCard c3 = p2.getHand().get(i);
                    if (c3 != null && excess>0){
                        c3.setHealth(c3.getHealth()-excess);
                        out.println(c3.getName() + " takes " + excess + " excess damage.");
                    }
                }
            }
        }
    }

    void clearDeathCard(ArrayList<BaseCard> checkList){
        for (int i=0;i<checkList.size();i++){
            BaseCard c = checkList.get(i);
            if (c==null) continue;
            if (c.getHealth()<=0){
                checkList.set(i, null);
            }
        }
    }
}
