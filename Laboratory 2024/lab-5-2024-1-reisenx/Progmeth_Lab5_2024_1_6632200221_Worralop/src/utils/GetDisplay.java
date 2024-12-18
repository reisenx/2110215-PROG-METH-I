package utils;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import item.Book;

public class GetDisplay {
	// Methods
	public static Text Description(Book book, int fontSize, int wrappingWidth) {
		Text description = new Text(book.getDescription());
		description.setFont(new Font(fontSize));
		description.setWrappingWidth(wrappingWidth);
		return description;
	}
	
	public static ImageView image(Book book, int fitHeight) {
		ImageView image = new ImageView(book.getImage());
		image.setPreserveRatio(true);
		image.setFitHeight(fitHeight);
		return image;
	}
	
	public static Text name(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment) {
		Text name = new Text(book.getName());
		name.setFont(new Font(fontSize));
		name.setWrappingWidth(wrappingWidth);
		name.setTextAlignment(textAlignment);
		return name;
	}
	
	public static Text author(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment) {
		Text author = new Text(book.getAuthor());
		author.setFill(Color.GRAY);
		author.setFont(new Font(fontSize));
		author.setWrappingWidth(wrappingWidth);
		author.setTextAlignment(textAlignment);
		return author;
	}
	
	public static Text stars(Book book, int fontSize) {
		int score = book.getStars();
		Text stars = new Text("\u2605".repeat(score) + "\u2606".repeat(5-score));
		stars.setFill(Color.DARKRED);
		stars.setFont(new Font(fontSize));
		return stars;
	}
}