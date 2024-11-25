package application;

import java.util.Random;

import data.Line;
import data.LineField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static LineField lineField;	
	private static Button createLine;	
	public int frames = 10;
	public String title = "My App";
	public static int width = 600;
	public static int height = 400;
	public static Random random = new Random();
	Canvas canvas = new Canvas();
	GraphicsContext ctx = canvas.getGraphicsContext2D();

	@Override
	public void start(Stage stage) throws Exception {
		setup();
		canvas.setHeight(height);
		canvas.setWidth(width);
		lineField = new LineField();
		VBox root = new VBox();
		createLine = new Button("Create Line");
		StackPane raiz = new StackPane(canvas);
		root.getChildren().addAll(createLine, raiz);
		stage.setTitle(title);
		stage.setScene(new Scene(root, width, height));
		stage.show();
		
		drawBackground();
		
		createLine.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				lineField.addLineList();
				initalizeNewLine(lineField.getLineCount()-1);
			}
		});
		canvas.requestFocus();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
	void setup() {
		title = "Bouncing Ball";
		width = 800;
		height = 600;
	}

	void drawBackground() {
		ctx.setFill(Color.LIGHTGRAY);
		ctx.fillRect(0, 0, width, height);
	}

	
	void initalizeNewLine(int code) {		
		/*====================FILL CODE============================
		Add something on the code below to make new line appear while application
		can be responded*/
		updateLineMovement(code);						
		/*========================================================*/
	}

	void updateLineMovement(int code) {
		try {
		while(true) {
				/*===================!DO NOT CHANGE THIS LINE!===========*/
				Thread.sleep(10);
				/*========================================================*/
				
				/*====================FILL CODE============================
				There is JavaFX commands inside the code below
				Add something to the code below to make JavaFX commands can
				function in the thread
				*/
				// Hint : GraphicsContext ctx is related to JavaFX, look at the certain method below.
				lineField.getLineList().get(code).update();
				Line b = lineField.getLineList().get(code);
				drawLine(b);
				/*========================================================*/
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	void drawLine(Line b) {
		ctx.setFill(b.getC());
		ctx.fillOval(b.getX(), b.getY(), b.getR(), b.getR());
	}
	
}