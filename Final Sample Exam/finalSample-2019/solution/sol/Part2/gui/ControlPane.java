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

//You might need to do something to the following line
public class ControlPane extends VBox{
	
	private Text drawnNumberText;
	private Text drawCountText;
	private Text bingoText;
	private Button drawButton;
	private Button newRoundButton;
	private NumberGrid numberGrid;

	
	public ControlPane(NumberGrid numberGrid) {
		this.numberGrid=numberGrid;
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		BorderStroke bds = new BorderStroke(Color.LIGHTGRAY,
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
                BorderWidths.DEFAULT);
		Border bd= new Border(bds);
		this.setBorder(bd);
		this.drawnNumberText = new Text("");
		drawnNumberText.setFont(Font.font(20));
		this.drawCountText = new Text();
		initializeBingoText();
		initializeDrawButton();
		 initializeNewRoundButton();
		this.getChildren().add(this.drawnNumberText);
		 this.getChildren().add(this.drawButton);
		 this.getChildren().add(this.newRoundButton);
		 this.getChildren().add(this.bingoText);
	
	    
	    this.getChildren().add(this.drawCountText);
		BingoUtil.setTextsBeginning(this.drawnNumberText, this.drawCountText);
		
		
	}
	
	private void initializeBingoText() {
		this.bingoText=new Text("Bingo!!");
		this.bingoText.setFont(Font.font(40));
		this.bingoText.setVisible(false);

	}

	private void initializeDrawButton() {
		this.drawButton=new Button("Draw a number");
		this.drawButton.setPrefWidth(100);
		this.drawButton.setOnAction(e->drawButtonHandler());

	}

	private void initializeNewRoundButton() {
		this.newRoundButton=new Button("New Round");
		this.newRoundButton.setPrefWidth(100);
		this.newRoundButton.setDisable(true);
		this.newRoundButton.setOnAction(e->newRoundButtonHandler());
	}
	
	private void drawButtonHandler() {
	    int i;
	    i=BingoUtil.drawNumber();
	    numberGrid.highlightNumber(i);
	    
		if (BingoUtil.isBingo(numberGrid)) {
			this.bingoText.setVisible(true);
			this.drawButton.setDisable(true);
			this.newRoundButton.setDisable(false);
			
			
		}
		BingoUtil.updateTextsAfterDrawn(i, this.drawnNumberText, this.drawCountText);
	
		
	}
	
	private void newRoundButtonHandler() {
		BingoUtil.assignRandomNumbers(numberGrid.getNumberSquares());
		this.bingoText.setVisible(false);
		this.drawButton.setDisable(false);
		this.newRoundButton.setDisable(true);
		BingoUtil.setTextsBeginning(this.drawnNumberText, this.drawCountText);
		
	}

}
