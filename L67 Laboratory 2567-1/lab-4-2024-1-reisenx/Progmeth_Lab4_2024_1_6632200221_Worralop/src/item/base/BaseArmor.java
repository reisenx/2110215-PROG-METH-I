package item.base;

public abstract class BaseArmor extends BaseEquipment {

    public BaseArmor(String name, int durability) {
        super(name, durability);
    }

    public abstract int getDef();

    @Override
    public String toString() {
        return getName() + " (Def: " + getDef() + ")";
    }

}
