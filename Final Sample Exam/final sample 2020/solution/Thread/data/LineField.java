package data;

import javafx.collections.FXCollections;
import application.Main;
import javafx.collections.ObservableList;

public class LineField {
	
	private final ObservableList<Line> lineList;	
	private int lineCount = 0;
		
	public LineField(){
		this.lineList = FXCollections.observableArrayList();
	}	
		
	public void addLineList() {
		lineList.add(new Line(Main.width / 2, Main.height / 2));
		lineCount++;
	}

	public ObservableList<Line> getLineList() {
		return lineList;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setBallCount(int ballCount) {
		this.lineCount = ballCount;
	}
	
}
