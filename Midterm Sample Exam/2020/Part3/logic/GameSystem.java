package logic;

import java.util.ArrayList;

public class GameSystem {
	
	private ArrayList<Piece> allWhitePieces;
	private ArrayList<Piece> allRedPieces;
	private boolean gameEnd;

	public GameSystem() {
		
		allWhitePieces  = new ArrayList<Piece>();
		allRedPieces = new ArrayList<Piece>();
		
		MotherShip wm1 = new MotherShip(3, 0, false,"wm1");
		Fighter wf1 = new Fighter(0, 2, false,"wf1");
		Fighter wf2 = new Fighter(2, 2, false,"wf2");
		Fighter wf3 = new Fighter(4, 2, false,"wf3");
		Fighter wf4 = new Fighter(6, 2, false,"wf4");
		
		MotherShip rm1 = new MotherShip(3,6,true,"rm1");
		Fighter rf1 = new Fighter(0, 4, true,"rf1");
		Fighter rf2 = new Fighter(2, 4, true,"rf2");
		Fighter rf3 = new Fighter(4, 4, true,"rf3");
		Fighter rf4 = new Fighter(6, 4, true,"rf4");
		
		//add all pieces to check pieces that on the board
		allWhitePieces.add(wm1);
		allWhitePieces.add(wf1);
		allWhitePieces.add(wf2);
		allWhitePieces.add(wf3);
		allWhitePieces.add(wf4);
		
		allRedPieces.add(rm1);
		allRedPieces.add(rf1);
		allRedPieces.add(rf2);
		allRedPieces.add(rf3);
		allRedPieces.add(rf4);
		
		setGameEnd(false);
	}
	
	public boolean isGameEnd() {
		if(allRedPieces.isEmpty() || allWhitePieces.isEmpty())gameEnd = true;
		return gameEnd;
	}

	public void setGameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}
	
	public ArrayList<Piece> getAllWhitePieces() {
		return allWhitePieces;
	}

	public ArrayList<Piece> getAllRedPieces() {
		return allRedPieces;
	}

	public void printBoardStatus() {
		for(int i = 0;i<allWhitePieces.size();i++) {
			Piece temp = allWhitePieces.get(i);
			System.out.println(temp.name+ ": ("+ temp.currentPosition.getX()+", "+ temp.currentPosition.getY()+")");
		}
		for(int i = 0;i<allRedPieces.size();i++) {
			Piece temp = allRedPieces.get(i);
			System.out.println(temp.name+ ": ("+ temp.currentPosition.getX()+", "+ temp.currentPosition.getY()+")");
		}
	}
	
	public boolean removeOtherPieces(Piece user,Position position) {
		boolean hasRemoved = false;
		
		for(int j =0;j<allWhitePieces.size();j++) {
			if(user != allWhitePieces.get(j)&& position.equal(allWhitePieces.get(j).getCurrentPosition())) {
				allWhitePieces.remove(j);
				hasRemoved = true;
			}
		}
		for(int j =0;j<allRedPieces.size();j++) {
			if(user != allRedPieces.get(j)&&position.equal(allRedPieces.get(j).getCurrentPosition())) {
				allRedPieces.remove(j);
				hasRemoved = true;
			}
		}	
		
		return hasRemoved;
	}

	public void action(Piece piece, boolean attack, int actionPattern) {
	//Fill your code here
		
	}
	
}
