package table;

import item.armor.Boots;
import item.armor.Helmet;
import item.armor.Suit;
import item.base.BaseItem;
import item.consumption.*;
import item.weapon.Bow;
import item.weapon.Stick;
import item.weapon.Sword;

import java.util.Random;

public class Randomizer {

    public static final Randomizer instance = new Randomizer();
    private String name;
    private final ItemRandomWeight[] ITEM_RANDOM_WEIGHT;

    public Randomizer() {
        setName("Randomizer");
        ITEM_RANDOM_WEIGHT = new ItemRandomWeight[] {
                // Weapon
                new ItemRandomWeight(new Stick(), 4),
                new ItemRandomWeight(new Sword(), 2),
                new ItemRandomWeight(new Bow(), 2),

                //Armor
                new ItemRandomWeight(new Suit(), 2),
                new ItemRandomWeight(new Boots(), 1),
                new ItemRandomWeight(new Helmet(), 1),

                //Consumption
                new ItemRandomWeight(new HealingPotion(), 4),
                new ItemRandomWeight(new StrengthPotion(), 2),
                new ItemRandomWeight(new UltimatePotion(), 1),
                new ItemRandomWeight(new Pill(), 4),
                new ItemRandomWeight(new GoldenApple(), 3),
                new ItemRandomWeight(new Pork(), 4)
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseItem interact() {
        return randomItem();
    }

    private BaseItem randomItem() {
        Random random = new Random();
        int result = random.nextInt(sumTotalWeight() - 1) + 1; //Random from 1 to sumWeight

        int cumulativeWeight = 0;
        for (ItemRandomWeight irw : ITEM_RANDOM_WEIGHT) {
            cumulativeWeight += irw.getWeight();
            if (cumulativeWeight >= result) {
                BaseItem item = irw.getItem();
                if (item instanceof Sword) return new Sword();
                if (item instanceof Stick) return new Stick();
                if (item instanceof Bow) return new Bow();
                if (item instanceof Suit) return new Suit();
                if (item instanceof Boots) return new Boots();
                if (item instanceof Helmet) return new Helmet();
                if (item instanceof HealingPotion) return new HealingPotion();
                if (item instanceof StrengthPotion) return new StrengthPotion();
                if (item instanceof UltimatePotion) return new UltimatePotion();
                if (item instanceof Pill) return new Pill();
                if (item instanceof GoldenApple) return new GoldenApple();
                if (item instanceof Pork) return new Pork();
            }
        }
        return null;
    }

    private int sumTotalWeight() {
        int stw = 0;
        for (ItemRandomWeight irw : ITEM_RANDOM_WEIGHT) {
            stw += irw.getWeight();
        }
        return stw;
    }
}
