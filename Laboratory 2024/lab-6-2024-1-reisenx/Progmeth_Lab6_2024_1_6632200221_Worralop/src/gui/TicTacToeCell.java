package gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class TicTacToeCell extends Pane{

	private boolean isDrawn;
	private Color baseColor;

	private int xPosition;
	private int yPosition;
	private String oURL;
	private String xURL;
	private Button button=new Button();

	public TicTacToeCell(int x, int y) {
		super();
		this.oURL = "o.png";
		this.xURL = "x.png";
		this.setxPosition(x);
		this.setyPosition(y);
		setPrefSize(150, 150);
		setPrefHeight(150);
		setBaseColor(Color.MOCCASIN);
		initializeCellColor();




		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
					onClickHandler();
			}
		});
	}

	private void onClickHandler()  {
		if (!GameLogic.getInstance().isGameEnd() && GameLogic.getInstance().isGameStart()) {
			;
			if (!isDrawn) {
				if (GameLogic.getInstance().isOturn()) {

                                draw(new Image(ClassLoader.getSystemResource(oURL).toString()), Color.AQUA);

					GameLogic.getInstance().beginTurns(1);

				} else {

                                draw(new Image(ClassLoader.getSystemResource(xURL).toString()), Color.YELLOW);

					GameLogic.getInstance().beginTurns(0);
				}
				GameLogic.getInstance().drawNumber(xPosition, yPosition);
			}

		}
	}

	public void draw(Image image, Color backgroundColor) {
		getChildren().add(button);
		getChildren().remove(button);
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(150,150,false,false,false,false);
		this.setBackground(new Background(bgFillA));
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		this.setDrawn(true);

	}

	public void initializeCellColor() {
		this.setDrawn(false);
		setBackground(new Background(new BackgroundFill(baseColor,null,null)));
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}


}
