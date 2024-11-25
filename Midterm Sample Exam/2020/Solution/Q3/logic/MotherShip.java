package logic;

import java.util.ArrayList;

public class MotherShip extends Piece{
	
	private PositionList attackPositions;
	
	public MotherShip(int initialPositionX, int initialPositionY,boolean reverse,String name) {
		super(initialPositionX, initialPositionY,reverse,name);
		// TODO Auto-generated constructor stub
		
		attackPositions = new PositionList();
		
		//addMoveSet
		movePositions.add(0,1);
		
		//addAttackSet
		attackPositions.add(0,2);
		
		if(isReverse()) {
			for(int i = 0;i<attackPositions.size();i++) {
				attackPositions.get(i).reverse();
			}
			for(int i = 0;i<movePositions.size();i++) {
				movePositions.get(i).reverse();
			}
		}
		
	}

	@Override
	public Position attackTargetPosition(int actionPattern) {
		// TODO Auto-generated method stub
		Position targetPosition = this.currentPosition.addPositionValue(attackPositions.get(actionPattern));
		move(0);
		return targetPosition;
	}

	@Override
	public void move(int movePattern) {
		// TODO Auto-generated method stub
		Position targetPosition = this.currentPosition.addPositionValue(movePositions.get(movePattern));
		setCurrentPosition(targetPosition);
		this.currentPosition.normalizedPosition();
		
	}

	public ArrayList<Position> getAttackPosition() {
		return attackPositions;
	}
	
	

	
}
