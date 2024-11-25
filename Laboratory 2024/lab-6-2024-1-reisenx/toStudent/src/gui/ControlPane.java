package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import logic.Timer;

public class ControlPane extends VBox{
	
	private Text gameText;
	private Button newGameButton;
	private Button startButton;

	public TicTacToePane getTicTacToePane() {
		return ticTacToePane;
	}

	public void setTicTacToePane(TicTacToePane ticTacToePane) {
		this.ticTacToePane = ticTacToePane;
	}

	private TicTacToePane ticTacToePane;
	private TimerPane tp1;
	private TimerPane tp2;
	
	public ControlPane(TicTacToePane ticTacToePane) {
		super();
		this.ticTacToePane = ticTacToePane;
		//To be implemented
		setAlignment(Pos.CENTER);
		setPrefWidth(300);
		setSpacing(20);
		initializeGameText();
		initializeNewGameButton();
		inttializeTimeText();
		initializeStartButton();
		getChildren().addAll(gameText,newGameButton,startButton);

	}
	
	private void initializeGameText() {
		gameText=new Text("Tic Tac Toe");
		gameText.setFont(new Font(35));

	}

	private void inttializeTimeText(){
		tp1 = new TimerPane(0);
		tp2 = new TimerPane(1);
		GameLogic.setTimerPane(0, tp1);
		GameLogic.setTimerPane(1, tp2);
	}
	
	public void updateGameText(String text) {
		gameText.setText(text);
		
	}
	
	private void initializeNewGameButton() {
		this.newGameButton=new Button("New Game");
		newGameButton.setPrefWidth(100);
		newGameButton.setOnAction(e->newGameButtonHandler());
		
	}
	private void initializeStartButton() {
		this.startButton=new Button("Start");
		startButton.setPrefWidth(100);
		startButton.setOnAction(e->newStartButtonHandler());
	}

	private void newStartButtonHandler() {
		updateGameText("O Turn");
		GameLogic.setGameStart(true);
		GameLogic.getInstance().startCountDownTimer(0);
		GameLogic.getInstance().startCountDownTimer(1);
		getChildren().addAll(tp1,tp2);
		startButton.setDisable(true);
	}
	private void newGameButtonHandler() {
		GameLogic.setGameStart(false);
		getChildren().remove(tp1);
		getChildren().remove(tp2);
		GameLogic.getInstance().newGame();
		updateGameText("Tic Tac Toe");
		for(TicTacToeCell x:ticTacToePane.getAllCells()){
			x.initializeCellColor();
		}
		inttializeTimeText();
		startButton.setDisable(false);
	}
}
