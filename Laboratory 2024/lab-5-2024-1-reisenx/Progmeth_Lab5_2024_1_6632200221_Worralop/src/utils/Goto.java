package utils;

import utils.GetDisplay;
import item.Book;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.NewBookPane;
import pane.RootPane;
import pane.SearchPane;

public class Goto {
	// Class Properties
	private static RootPane rootPane;
	
	// Methods
	public static void clear() {
		if(Goto.rootPane.getChildren().size() > 1) {
			Goto.rootPane.getChildren().removeIf(
					node -> rootPane.getChildren().indexOf(node) > 0);
		}
	}
	
	public static void mainPage() {
		Goto.clear();
		ScrollPane scrollPane = new ScrollPane(BookListPane.getInstance());
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		
		Goto.rootPane.getChildren().add(new SearchPane());
		Goto.rootPane.getChildren().add(scrollPane);
	}
	
	public static Button backToMainPageButton() {
		Button button = new Button("Back");
		button.setBorder(
				new Border(
						new BorderStroke(
								Color.DARKCYAN,
								BorderStrokeStyle.SOLID,
								CornerRadii.EMPTY,
								new BorderWidths(2))));
		button.setBackground(Background.fill(Color.WHITE));
		button.setTextFill(Color.DARKCYAN);
		button.setPrefWidth(300);
		button.setOnAction(ActionEvent -> Goto.mainPage());
		return button;
	}
	
	public static void bookPage(Book book) {
		Goto.clear();
		Text name = GetDisplay.name(book, 28, 336, TextAlignment.CENTER);
		Text author = GetDisplay.author(book, 24, 336, TextAlignment.CENTER);
		author.setText("By " + author.getText());
		ImageView image = GetDisplay.image(book, 320);
		Text stars = GetDisplay.stars(book, 24);
		Text description = GetDisplay.Description(book, 16, 336);
		
		Goto.rootPane.getChildren().add(Goto.backToMainPageButton());
		Goto.rootPane.getChildren().add(name);
		Goto.rootPane.getChildren().add(author);
		Goto.rootPane.getChildren().add(image);
		Goto.rootPane.getChildren().add(stars);
		Goto.rootPane.getChildren().add(description);
	}
	
	public static void addNewBookPage() {
		Goto.clear();
		Goto.rootPane.getChildren().add(Goto.backToMainPageButton());
		Goto.rootPane.getChildren().add(new NewBookPane());
	}
	
	// Getters & Setters
	public static void setRootPane(RootPane rootPane) {
		Goto.rootPane = rootPane;
	}
	
}
