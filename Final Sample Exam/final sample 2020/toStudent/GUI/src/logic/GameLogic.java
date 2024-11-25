package logic;

import gui.ControlPane;

public class GameLogic {
	
	private static GameLogic instance = null;
	private boolean isGameEnd;
	private boolean isOTurn;
	private ControlPane controlPane;
	private int[][] board = new int[3][3];
	
	private GameLogic() {
		this.newGame();
	}
	
	public void drawNumber(int x, int y) {
		int num = -1;
		if(isOTurn)num = 1;
		else num = 2;
		board[x][y] = num;
		checkGameEnd();
		if(isGameEnd) {
			if(isOTurn)controlPane.updateGameText("O wins!");
			else controlPane.updateGameText("X wins!");
			return;
		}
		
		setOturn(!isOTurn);

		if(isOTurn)controlPane.updateGameText("O Turn");
		else controlPane.updateGameText("X Turn");
		
	}
	
	private void checkGameEnd() {
		int num = -1;
		if(isOTurn)num = 1;
		else num = 2;
		if((board[0][0]==num&&board[0][1]==num&&board[0][2]==num)||
			(board[1][0]==num&&board[1][1]==num&&board[1][2]==num)||
			(board[2][0]==num&&board[2][1]==num&&board[2][2]==num)||
			(board[0][0]==num&&board[1][0]==num&&board[2][0]==num)||
			(board[0][1]==num&&board[1][1]==num&&board[2][1]==num)||
			(board[0][2]==num&&board[1][2]==num&&board[2][2]==num)||
			(board[0][0]==num&&board[1][1]==num&&board[2][2]==num)||
			(board[2][0]==num&&board[1][1]==num&&board[0][2]==num)) {
			this.setGameEnd(true);
		}
	}
	
	public void newGame() {
		this.setGameEnd(false);
		this.setOturn(true);
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public boolean isGameEnd() {
		return isGameEnd;
	}
	public void setGameEnd(boolean gameEnd) {
		isGameEnd = gameEnd;
	}
	public boolean isOturn() {
		return isOTurn;
	}
	public void setOturn(boolean oTurn) {
		isOTurn = oTurn;
	}

	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}
	
	
	
}
