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

public class ControlPane extends VBox{
	
	private Text gameText;
	private Button newGameButton;
	private TicTacToePane ticTacToePane;
	
	public ControlPane(TicTacToePane ticTacToePane) {
		super();
		this.ticTacToePane = ticTacToePane;
		//To be implemented
		setAlignment(Pos.CENTER);
		setPrefWidth(300);
		setSpacing(20);
		initializeGameText();
		initializeNewGameButton();
		getChildren().addAll(gameText,newGameButton);
		
	}
	
	private void initializeGameText() {
		gameText=new Text("O Turn");
		gameText.setFont(new Font(35));

	}
	
	public void updateGameText(String text) {
		gameText.setText(text);
		
	}
	
	private void initializeNewGameButton() {
		this.newGameButton=new Button("New Game");
		newGameButton.setPrefWidth(100);
		newGameButton.setOnAction(e->newGameButtonHandler());
		
	}
	
	private void newGameButtonHandler() {
		GameLogic.getInstance().newGame();
		updateGameText("O Turn");
		for(TicTacToeCell x:ticTacToePane.getAllCells()){
			x.initializeCellColor();
		}

	}
}
