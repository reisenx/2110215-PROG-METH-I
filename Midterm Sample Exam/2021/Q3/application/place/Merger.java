package application.place;

import application.game.GameManager;
import application.util.ChoiceUtil;
import application.util.CloneUtil;
import application.util.StringUtil;
import logic.card.BaseCard;

import java.util.*;

import static java.lang.System.out;

public class Merger extends Place{

    ArrayList<Integer> bcl = new ArrayList<>();

    public Merger() {
        super("Merger");
    }
    public Merger(String name) {
        super(name);
    }

    @Override
    public void run() {
        bcl = new ArrayList<>();
        out.println("You walk into Merger");
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<BaseCard> cardlist = GameManager.getPlayerDeck().getDeckList();
        for (int i =0;i<cardlist.size();i++){
            BaseCard bc = cardlist.get(i);
            String name = bc.getName();
            if (map.containsKey(name)){
                int idx = map.get(name);
                if (idx>=0){
                    bcl.add(idx);
                    bcl.add(i);
                    map.put(name, -1);
                }
            }else{
                map.put(name,i);
            }
        }
        if (bcl.size()>0){
            out.println("You can merge 2 cards with same name.");
            int choice = new ChoiceUtil(out, new Scanner(System.in)).getChoice(1, bcl.size()/2, this::printPrompt, this::returnChoice);
            choice = (choice-1)*2;
            BaseCard c2 = GameManager.getPlayerDeck().getDeckList().remove((int)bcl.get(choice+1));
            BaseCard c1 = GameManager.getPlayerDeck().getDeckList().remove((int)bcl.get(choice));
            c1.setPower(c1.getPower()+c2.getPower());
            c1.setHealth(c1.getHealth()+c2.getHealth());
            out.println("You merge " + StringUtil.getString(c1) + " to your deck");
            GameManager.getPlayerDeck().getDeckList().add(c1);
        }else{
            Random rand = new Random();
            Set<Integer> set = new HashSet<>();
            while (set.size()<Math.min(cardlist.size(), 3)){
                set.add(rand.nextInt(cardlist.size()));
            }
            ArrayList<BaseCard> bcList = new ArrayList<>();
            for (int a: set){
                bcList.add(cardlist.get(a));
            }
            out.println("You don't have card to merge, so add card that you have to your deck");
            int choice = new ChoiceUtil(out, new Scanner(System.in)).getChoice(1, set.size(), ()->{
                out.println("Pick card to add to your deck.");
                StringUtil.printChoice(bcList);
            }, (n) -> bcList.get(n-1).getName());
            out.println("You add " + StringUtil.getString(bcList.get(choice-1)) + " to your deck.");
            GameManager.getPlayerDeck().getDeckList().add(CloneUtil.clone(bcList.get(choice-1)));
        }

    }

    void printPrompt(){
        out.println("Pick cards to merge.");
        for (int i=0;i<bcl.size();i+=2){
            BaseCard c1 = GameManager.getPlayerDeck().getDeckList().get(bcl.get(i));
            BaseCard c2 = GameManager.getPlayerDeck().getDeckList().get(bcl.get(i+1));
            out.println((i+1) + ": " + StringUtil.getTypeDisplay(c1) + " "+ String.format("ATK: %d+%d HP: %d+%d", c1.getPower(),c2.getPower(), c1.getHealth(), c2.getHealth()));
        }
    }

    String returnChoice(int n){
        return GameManager.getPlayerDeck().getDeckList().get(bcl.get(n-1)).getName();
    }
}
