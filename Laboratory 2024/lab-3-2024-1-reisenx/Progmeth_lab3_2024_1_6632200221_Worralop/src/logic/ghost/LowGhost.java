package logic.ghost;

import utils.Config;

public abstract class LowGhost extends Ghost {
	// Constructor Method
	public LowGhost() {
		super(Config.LowGhostHp);
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.LowGhostLevel;
	}
}
