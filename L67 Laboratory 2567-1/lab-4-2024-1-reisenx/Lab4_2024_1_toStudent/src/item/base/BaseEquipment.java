package item.base;

public abstract class BaseEquipment extends BaseItem {

    private int durability;

    public BaseEquipment(String name, int durability) {
        super(name);
        setDurability(durability);
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = Math.max(durability, 0);
    }
}
