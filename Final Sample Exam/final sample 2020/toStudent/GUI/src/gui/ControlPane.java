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
		
	}
	
	private void initializeGameText() {
		//To be implemented
		
	}
	
	public void updateGameText(String text) {
		//To be implemented
		
	}
	
	private void initializeNewGameButton() {
		//To be implemented
		
	}
	
	private void newGameButtonHandler() {
		//To be implemented
		
	}
}
