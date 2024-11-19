package table;

import item.base.BaseItem;
import item.usage.Upgradable;

public class Enchanter extends BaseTable {

    public Enchanter() {
        super("Enchanter");
    }

    @Override
    public String interact(BaseItem item) {
    	if(item instanceof Upgradable) {
    		if(((Upgradable) item).getLevel() < ((Upgradable) item).getMaxLevel()) {
    			((Upgradable) item).setLevel(((Upgradable) item).getLevel() + 1);
    			return "Upgrade successfully";
    		}
    		return "Already max level";
    	}    	
        return "This item cannot be upgraded";
    }
}
