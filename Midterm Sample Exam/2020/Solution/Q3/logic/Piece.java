package logic;

import java.util.ArrayList;

//Some important thing are missing.
public abstract class Piece {//base class=abstract

	protected boolean reverse;
	protected String name;
	protected PositionList movePositions;
	protected Position currentPosition;

	public Piece(int initialPositionX,int initialPositionY, boolean reverse, String name) {
		movePositions = new PositionList();
		currentPosition = new Position(initialPositionX,initialPositionY);
		currentPosition.normalizedPosition();//functionเช็คว่าปกติ
		setName(name);
		setReverse(reverse);
	}

	public abstract void move(int movePattern);//แล้วแต่class
	public abstract Position attackTargetPosition(int actionPattern);//แล้วแต่class
	

	
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
