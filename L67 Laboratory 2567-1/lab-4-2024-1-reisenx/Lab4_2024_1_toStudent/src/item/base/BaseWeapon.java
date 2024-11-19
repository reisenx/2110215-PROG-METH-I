package item.base;

public abstract class BaseWeapon extends BaseEquipment {

    private final int RANGE;

    public BaseWeapon(String name, int durability, int range) {
        super(name, durability);
        RANGE = Math.max(0,range);
    }

    public abstract int getAtt();

    public int getRange() {
        return RANGE;
    }

    @Override
    public String toString() {
        return getName() + " (Att: " + getAtt() + ", Range: " + getRange() + ", " + getDurability() + " uses left)";
    }

}
