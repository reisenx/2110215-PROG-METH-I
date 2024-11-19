package pane;

import item.Book;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewBookPane extends GridPane {
	// Constructor Methods
	public NewBookPane() {
		super.setPadding(new Insets(12));
		super.setVgap(8);
		TextField name = input();
		TextField author = input();
		TextField rating = input();
		TextField image = input();
		TextField description = input();
		
		ColumnConstraints col01 = new ColumnConstraints();
		ColumnConstraints col02 = new ColumnConstraints();
		col01.setPercentWidth(25);
		col01.setHalignment(HPos.RIGHT);
		col02.setPercentWidth(75);
		
		Button button = new Button("Add");
		button.setMaxWidth(430);
		button.prefHeight(32);
		button.setTextFill(Color.WHITE);
		button.setBackground(Background.fill(Color.DARKCYAN));
		button.setOnMouseClicked(actionEvent -> {
			handleClick(name.getText(),
					author.getText(),
					rating.getText(),
					image.getText(),
					description.getText());
		});
		
		super.getColumnConstraints().add(col01);
		super.getColumnConstraints().add(col02);
		
		super.add(label("Title: "),0,0);
		super.add(label("Author: "),0,1);
		super.add(label("Rating: "),0,2);
		super.add(label("Image: "),0,3);
		super.add(label("Description: "),0,4);
		
		super.add(name,1,0);
		super.add(author,1,1);
		super.add(rating,1,2);
		super.add(image,1,3);
		super.add(description,1,4);
		super.add(button,0,5,2,1);
	}
	
	// Methods
	private Text label(String s) {
		Text label = new Text(s);
		label.setFont(new Font(16));
		return label;
	}
	
	private TextField input() {
		TextField textField = new TextField();
		textField.setBackground(new Background(
				new BackgroundFill(
						Color.WHITE,
						new CornerRadii(16),
						null)));
		textField.setBorder(new Border(
				new BorderStroke(
						Color.DARKCYAN,
						BorderStrokeStyle.SOLID,
						new CornerRadii(16),
						BorderWidths.DEFAULT)));
		return textField;
	}
	
	private void handleClick(String name, String author, String rating, String image, String description) {
		if(name.isBlank() || author.isBlank() || rating.isBlank() || image.isBlank() || description.isBlank()) {
			return;
		}
		Book book = new Book(name, author, rating, image, description);
		BookListPane.getInstance().getBooks().add(book);
		BookListPane.getInstance().setSearchedBooks(
				BookListPane.getInstance().getBooks());
		Goto.mainPage();
	}
}
