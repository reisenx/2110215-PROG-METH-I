package logic;

import java.util.ArrayList;

//Some important thing are missing.
public class Fighter extends Piece {

	private boolean promoted;
	private PositionList promotedMovePositions;;

	public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
		super(initialPositionX, initialPositionY, reverse, name);
		promotedMovePositions= new PositionList();//สร้างตัวใหม่
		movePositions.add(-1,2);//บลาๆ
		movePositions.add(1,2);
		promotedMovePositions.add(0,2);
		promotedMovePositions.add(1,0);
		promotedMovePositions.add(0,-2);
		promotedMovePositions.add(-1,0);
		if(isReverse()){//reverse
			for(Position position:movePositions){
				position.reverse();
			}
			for(Position position:promotedMovePositions){
				position.reverse();
			}

		}
		setPromoted(false);
	}

	public PositionList getPromotedMovePositions() {
		return promotedMovePositions;
	}

	public  void move(int movePattern){
		if(isPromoted()) {//แปลไทยเอาคู่อันดับมาจากListกันแล้วบวกตำแหน่งปัจจุุบัน ถ้าpromotedแล้วใข้list get promoted.
			setCurrentPosition(getCurrentPosition().addPositionValue(getPromotedMovePositions().get(movePattern)));
		}
		else{setCurrentPosition(getCurrentPosition().addPositionValue(getMovePositions().get(movePattern)));
		}
		this.currentPosition.normalizedPosition();

	}
	public Position attackTargetPosition(int actionPattern){
		//Attack ตัวที่ห่างจากตัวนี้เป็นระยะตามMovepositionsช่องที่actionPattern;
		Position targetPosition = this.currentPosition.addPositionValue(movePositions.get(actionPattern));
		targetPosition.normalizedPosition();
		setCurrentPosition(targetPosition);
		return targetPosition;

	}

	public boolean isPromoted() {
		return promoted;
	}

	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}


	

}
