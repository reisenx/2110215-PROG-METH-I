package item.armor;

import item.base.BaseArmor;

public class Helmet extends BaseArmor {

    private final int DEF;
    public Helmet() {
        super("Helmet", 5);
        DEF = 1;
    }

    @Override
    public int getDef() {
        return DEF;
    }

}
