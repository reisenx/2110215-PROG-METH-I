package application.deck;

import application.game.CardQueue;
import application.game.Enemy;
import logic.card.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PremadeDeck {

    static OrbCard earthOrb = new OrbCard("Earth Orb", 0, 2, Element.EARTH);
    static OrbCard waterOrb = new OrbCard("Water Orb", 0, 2, Element.WATER);
    static OrbCard windOrb = new OrbCard("Ice Orb", 0, 2, Element.ICE);
    static OrbCard fireOrb = new OrbCard("Fire Orb", 0, 2, Element.FIRE);

    static RobotCard turret = new RobotCard("Nano Bot", 1, 1, 1);
    static RobotCard robot = new RobotCard("Robot", 2, 3, 3);
    static RobotCard ruinGuard = new RobotCard("Ruin Guard", 3, 3, 4);

//    static MageCard earthMage = new MageCard("Ningguang", 3, 3, Element.EARTH);
    static MageCard waterMage = new MageCard("Kokomi", 3, 3, Element.WATER);
    static MageCard windMage = new MageCard("Ganyu", 4, 2, Element.ICE);
    static MageCard fireMage = new MageCard("Klee", 4, 2, Element.FIRE);

    static ArrayList<BaseCard> orbDeckList = new ArrayList<>(List.of(earthOrb, waterOrb, windOrb, fireOrb));
    static ArrayList<BaseCard> robotDeckList = new ArrayList<>(List.of(turret, turret, robot, ruinGuard));
    static ArrayList<BaseCard> mageDeckList = new ArrayList<>(List.of(fireMage, waterMage, fireOrb, waterOrb));
    static ArrayList<BaseCard> mixDeckList = new ArrayList<>(List.of(windMage, windOrb, turret, robot));

    static Deck orbDeck = new Deck("Orb Deck", orbDeckList);
    static Deck robotDeck = new Deck("Robot Deck", robotDeckList);
    static Deck mageDeck = new Deck("Mage Deck", mageDeckList);
    static Deck mixDeck = new Deck("Mix Deck", mixDeckList);
    public static List<Deck> premadeDecks = new ArrayList<>(List.of(orbDeck, robotDeck, mageDeck, mixDeck));

    static ArrayList<CardQueue> enemyCard1 = new ArrayList<>();
    public static Enemy enemy1;

    static ArrayList<CardQueue> enemyCard2 = new ArrayList<>();
    public static Enemy enemy2;

    static ArrayList<CardQueue> enemyCard3 = new ArrayList<>();
    public static Enemy enemy3;

    static ArrayList<CardQueue> enemyCard4 = new ArrayList<>();
    public static Enemy enemy4;

    static ArrayList<CardQueue> enemyCard5 = new ArrayList<>();
    public static Enemy enemy5;

    static ArrayList<CardQueue> bossCard1 = new ArrayList<>();
    public static Enemy boss1;
    static Random rand = new Random();
    public static void enemyInit(){
        enemyCard1.add(createCardQueue( 0, new RobotCard("Blob", 1,1, 0)));
        int randPos1 = rand.nextInt(4);
        enemyCard1.add(new CardQueue(randPos1, 1, new OrbCard("Geo Slime", 2, 1,Element.EARTH)));
        enemyCard1.add(new CardQueue(randPos1,2, new RobotCard("Fortified Slime", 2, 3, 0)));

        BaseCard zombie = new RobotCard("Zombie", 1,2,0);
        enemyCard2.add(createCardQueue(0, zombie));
        enemyCard2.add(createCardQueue( 1, zombie));
        enemyCard2.add(createCardQueue( 1, zombie));
        enemyCard2.add(createCardQueue( 2, zombie));
        enemyCard2.add(createCardQueue( 3, zombie));
        enemyCard2.add(createCardQueue(3, zombie));
        enemyCard2.add(createCardQueue( 6, new RobotCard("Big Zombie", 3, 6, 5)));

        BaseCard hilichurl = new RobotCard("Hilichurl", 1,1, 0);
        enemyCard3.add(createCardQueue(0, hilichurl));
        enemyCard3.add(createCardQueue(1, hilichurl));
        enemyCard3.add(createCardQueue(1, new MageCard("Cryo Shooter Hilichurl",2,1, Element.ICE)));
        enemyCard3.add(createCardQueue(2, new RobotCard("Fighter Hilichur",3, 1, 0)));
        enemyCard3.add(createCardQueue( 3, new MageCard("Pyro Shooter Hilichurl", 3, 1, Element.FIRE)));
        enemyCard3.add(createCardQueue( 3, hilichurl));
        enemyCard3.add(createCardQueue(6, new RobotCard("Mitachurl", 4, 5, 5)));

        enemyCard4.add(createCardQueue(0, new RobotCard("Pirate (Undead)",2,3,0)));
        enemyCard4.add(createCardQueue(1, new RobotCard("Elf (Undead)",3,2,0)));
        enemyCard4.add(createCardQueue(2, new RobotCard("Knight (Undead)",3,3,0)));
        enemyCard4.add(createCardQueue(3, new RobotCard("Maid (Undead)",3,2,0)));
        enemyCard4.add(createCardQueue(3, new RobotCard("Demon (Undead)",4,3,0)));
        enemyCard4.add(createCardQueue(4, new RobotCard("Vampire (Undead)",3,5,0)));
        enemyCard4.add(createCardQueue(7, new RobotCard("Succubus (Undead)",4,5,0)));
        enemyCard4.add(createCardQueue(8, new RobotCard("Time Traveler (Undead)",6,6,0)));

        enemyCard5.add(createCardQueue(0, new RobotCard("Cat",3,2,0)));
        enemyCard5.add(createCardQueue(1, new RobotCard("Dog",2,3,0)));
        enemyCard5.add(createCardQueue(2, new RobotCard("Wolf",3,3,0)));
        enemyCard5.add(createCardQueue(3, new RobotCard("Fox",2,3,0)));
        enemyCard5.add(createCardQueue(3, new RobotCard("Orca",4,4,0)));
        enemyCard5.add(createCardQueue(4, new RobotCard("Shark",3,3,0)));
        enemyCard5.add(createCardQueue(7, new RobotCard("Phoenix",5,4,0)));
        enemyCard5.add(createCardQueue(8, new RobotCard("Dragon",6,6,0)));

        int posBarrier = rand.nextInt(4);
        bossCard1.add(createCardQueue((posBarrier+1)%4, 0, new RobotCard("Guard", 1,3,0)));
        bossCard1.add(createCardQueue((posBarrier+2)%4, 0, new RobotCard("Guard", 1,3,0)));
        bossCard1.add(createCardQueue((posBarrier+3)%4, 0, new RobotCard("Guard", 1,3,0)));
        bossCard1.add(createCardQueue((posBarrier+1)%4, 2, new RobotCard("Fighter", 3,2,0)));
        bossCard1.add(createCardQueue(2, new RobotCard("Fighter", 3,2,0)));
        bossCard1.add(createCardQueue(3, new RobotCard("Heavy", 1,4,0)));
        bossCard1.add(createCardQueue(3, new RobotCard("Heavy", 1,4,0)));
        bossCard1.add(createCardQueue(4, new RobotCard("Solder", 3,5,0)));
        bossCard1.add(createCardQueue(4, new RobotCard("Treasure Hoarder", 4,4,0)));
        bossCard1.add(createCardQueue(5, new MageCard("Cryogunner", 4,6,Element.ICE)));
        bossCard1.add(createCardQueue(5, new MageCard("Pyroslinger", 4,6,Element.FIRE)));



        enemy1 = new Enemy("Slime", enemyCard1);
        enemy2 = new Enemy("Zombie", enemyCard2);
        enemy3 = new Enemy("Hilichurl", enemyCard3);
        enemy4 = new Enemy("Necromancer", enemyCard4);
        enemy4.getField().set(rand.nextInt(4), new RobotCard("Fence", 0, 3, 0));
        enemy5 = new Enemy("Tamer", enemyCard5);
        enemy4.getField().set(rand.nextInt(4), new RobotCard("Boulder", 0, 3, 0));
        boss1 = new Enemy("Gym Leader", bossCard1);
        boss1.getField().set(rand.nextInt(4), new RobotCard("Barrier", 0, 5, 0));
    }

    static CardQueue createCardQueue(int idx, int turn, BaseCard bc){
        return new CardQueue(idx, turn, bc);
    }
    static CardQueue createCardQueue(int turn, BaseCard bc){
        return new CardQueue(rand.nextInt(4), turn, bc);
    }

    public static BaseCard getRandomCard(int type) {
        if (type==1){
            return getRandomOrbCard();
        }
        if(type==2) {
            return getRandomRobotCard();
        }
        return getRandomMageCard();
    }

    static BaseCard[] randomOrbCardList = {
            new OrbCard("Explosion Water Orb", 3, 1, Element.WATER),
            new OrbCard("Explosion Earth Orb", 3, 1, Element.EARTH),
            new OrbCard("Explosion Fire Orb", 3, 1, Element.FIRE),
            new OrbCard("Explosion Ice Orb", 3, 1, Element.ICE),
            new OrbCard("Large Fire Orb", 1, 4, Element.FIRE),
            new OrbCard("Large Ice Orb", 1, 4, Element.ICE),
            new OrbCard("Large Water Orb", 1, 4, Element.WATER),
            new OrbCard("Large Earth Orb", 1, 4, Element.EARTH),
            new OrbCard("Earth Orb", 0, 2, Element.EARTH),
            new OrbCard("Water Orb", 0, 2, Element.WATER),
            new OrbCard("Ice Orb", 0, 2, Element.ICE),
            new OrbCard("Fire Orb", 0, 2, Element.FIRE),
    };

    static BaseCard[] randomRobotCardList = {
            new RobotCard("Tank Bot", 1, 5, 4),
            new RobotCard("Mini Bot", 2, 1, 2),
            new RobotCard("Super Idol Bot", 4, 4, 5),
            new RobotCard("Nano Bot", 1, 1 , 1),
            new RobotCard("Robot", 2, 3, 3),
            new RobotCard("Ruin Guard", 3, 3, 4),
            new RobotCard("Roboco", 5,5,5),
            new RobotCard("Turret", 3,2,2),
    };

    static BaseCard[] randomMageCardList = {
            new MageCard("Ningguang", 3, 3, Element.EARTH),
            new MageCard("Kokomi", 3, 3, Element.WATER),
            new MageCard("Ganyu", 4, 2, Element.ICE),
            new MageCard("Klee", 4, 2, Element.FIRE),
            new MageCard("Zhongli", 2, 4, Element.EARTH),
            new MageCard("Barbara", 2, 4, Element.WATER),
            new MageCard("Ayaka", 3, 3, Element.ICE),
            new MageCard("Yanfei", 3, 3, Element.FIRE),
            new MageCard("Geodude", 4, 2, Element.EARTH),
            new MageCard("Squirtle", 4, 2, Element.WATER),
            new MageCard("Eiscue", 2, 4, Element.ICE),
            new MageCard("Lizardon", 2, 4, Element.FIRE),
    };
    static BaseCard getRandomOrbCard(){
        return randomOrbCardList[rand.nextInt(randomOrbCardList.length)];
    }
    static BaseCard getRandomRobotCard(){
        return randomRobotCardList[rand.nextInt(randomRobotCardList.length)];
    }
    static BaseCard getRandomMageCard(){
        return randomMageCardList[rand.nextInt(randomMageCardList.length)];
    }
}

