package logic;

import java.util.ArrayList;

public class PositionList extends ArrayList<Position>{
	
	public PositionList() {
		super();
	}
	
	public void add(int x,int y) {
		this.add(new Position(x,y));
	}
}
