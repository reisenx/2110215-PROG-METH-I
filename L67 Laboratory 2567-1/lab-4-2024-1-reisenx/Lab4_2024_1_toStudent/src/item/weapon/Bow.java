package item.weapon;

import item.base.BaseWeapon;
import item.usage.Upgradable;

public class Bow extends BaseWeapon implements Upgradable {

    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT;

    public Bow() {
        super("Bow",10,2);
        setLevel(0);
        MAX_LEVEL = 3;
        ATT = new int[]{2,3,5,8};
    }

    @Override
    public int getAtt() {
        return ATT[getLevel()];
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        if (0 <= level && level <= getMaxLevel() ) {
            this.level = level;
        } else {
            this.level = 0;
        }
    }

    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public String toString() {
        return getName() + " (Att: " + getAtt() + ", Range: " + getRange() + ", Level: " + getLevel() + ", " + getDurability() + " uses left)";
    }

}
