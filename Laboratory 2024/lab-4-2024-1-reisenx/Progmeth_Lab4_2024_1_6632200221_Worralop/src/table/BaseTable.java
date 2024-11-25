package table;

import item.base.BaseItem;

public abstract class BaseTable {

    private String name;

    public BaseTable(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String interact(BaseItem baseItem);
}
