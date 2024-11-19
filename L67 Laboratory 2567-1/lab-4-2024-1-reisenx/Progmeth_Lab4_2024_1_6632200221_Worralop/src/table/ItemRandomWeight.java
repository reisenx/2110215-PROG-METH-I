package table;

import item.base.BaseItem;

public class ItemRandomWeight {

    private BaseItem item;
    private int weight;

    public ItemRandomWeight(BaseItem baseItem, int weight) {
        setItem(baseItem);
        setWeight(weight);
    }

    public BaseItem getItem() {
        return item;
    }

    public void setItem(BaseItem item) {
        this.item = item;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
