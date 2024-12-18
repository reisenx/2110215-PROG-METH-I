package pane;

import java.util.ArrayList;

import item.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SearchPane extends HBox {
	// Constructor Method
	public SearchPane() {
		super.setAlignment(Pos.CENTER);
		TextField textField = new TextField();
		textField.setPromptText("Find the book");
		textField.setPrefWidth(250);
		Button button = new Button("Search");
		button.setBackground(Background.fill(Color.DARKCYAN));
		button.setTextFill(Color.WHITE);
		button.setOnAction(actionEvent -> {
			ArrayList<Book> results = new ArrayList<Book>(
					BookListPane.getInstance().getBooks());
			String search = textField.getText();
			if(!(search.isBlank())) {
				results.removeIf(
						book -> !(book.getName().contains(search)));
			}
			BookListPane.getInstance().setSearchedBooks(results);
		});
		getChildren().add(textField);
		getChildren().add(button);
	}
}
