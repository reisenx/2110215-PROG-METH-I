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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class TicTacToePane extends GridPane{
	
	private ArrayList<TicTacToeCell> allCells;
	
	public TicTacToePane() {
		super();
		this.allCells = new ArrayList<TicTacToeCell>();
		this.setHgap(8);
		this.setVgap(8);
		this.setPadding(new Insets(8));
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(500);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		for(int i = 0;i<3;i++) {
			for(int j =0;j<3;j++) {
				this.allCells.add(new TicTacToeCell(i,j));
				this.add(allCells.get((i*3)+j), i, j);
			}
		}
	}

	public ArrayList<TicTacToeCell> getAllCells() {
		return allCells;
	}
	
	
}
