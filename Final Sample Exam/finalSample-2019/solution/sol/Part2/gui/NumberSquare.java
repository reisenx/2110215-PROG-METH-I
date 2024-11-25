package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NumberSquare extends HBox {
	
	private int number;
	private boolean isDrawn;
	private Text numberText;

	public NumberSquare() {
		BingoUtil.initializeNumberSquare(this);	
		this.setAlignment(Pos.CENTER);
		this.setBorder(new Border(new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, new BorderWidths(1, 0, 0, 1))));
		this.numberText = new Text();
		
		
		
	}

	public void setupNumber(int number) {
		this.getChildren().clear();
		this.number =number;
		this.isDrawn=false;
		Text a=new Text(String.valueOf(number));
		this.setNumberText(a);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		this.getChildren().add(this.numberText);
	}	
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		this.isDrawn=true;
	}
	
	public int getNumber() {
		return number;
	}	

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setNumberText(Text numberText) {
		this.numberText = numberText;
		numberText.setFont(Font.font(20));
	}
}
