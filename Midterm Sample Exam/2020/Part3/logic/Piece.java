package logic;

import java.util.ArrayList;

//Some important thing are missing.
public class Piece {

	protected boolean reverse;
	protected String name;
	protected PositionList movePositions;
	protected Position currentPosition;
	
	public void move(int movePattern);
	public Position attackTargetPosition(int actionPattern);
	
	public Piece(int initialPositionX,int initialPositionY, boolean reverse, String name) {
		movePositions = new PositionList();
		currentPosition = new Position(initialPositionX,initialPositionY);
		currentPosition.normalizedPosition();
		setName(name);
		setReverse(reverse);
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isReverse() {
		return reverse;
	}
	
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}
	
	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
	public Position getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int x,int y) {
		this.currentPosition.setX(x);
		this.currentPosition.setY(y);
	}
	public ArrayList<Position> getMovePositions() {
		return movePositions;
	}
	
	
}
