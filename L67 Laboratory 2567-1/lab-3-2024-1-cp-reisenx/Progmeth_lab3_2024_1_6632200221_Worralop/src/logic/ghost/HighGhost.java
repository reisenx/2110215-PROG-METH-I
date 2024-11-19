package logic.ghost;

import utils.Config;

public abstract class HighGhost extends Ghost {
	// Constructor Method
	public HighGhost() {
		super(Config.HighGhostHp);
	}
	
	// Methods
	public abstract void damage();
}