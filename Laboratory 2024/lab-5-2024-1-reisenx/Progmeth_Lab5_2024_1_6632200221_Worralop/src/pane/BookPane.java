package pane;

import item.Book;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import utils.GetDisplay;
import utils.Goto;

public class BookPane extends GridPane {
	// Constructor Method
	public BookPane(Book book) {
		super.setPrefWidth(428);
		super.setHgap(8);
		super.setPadding(new Insets(4));
		ImageView image = GetDisplay.image(book, 160);
		super.add(image, 0, 0, 1, 4);
		Text name = GetDisplay.name(book, 18, 250, TextAlignment.LEFT);
		super.add(name, 1, 0);
		Text author = GetDisplay.author(book, 16, 250, TextAlignment.LEFT);
		super.add(author, 1, 1);
		Text stars = GetDisplay.stars(book, 16);
		super.add(stars, 1, 3);
		
		super.setOnMouseClicked(event -> Goto.bookPage(book));
	}
}
