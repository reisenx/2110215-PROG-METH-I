package main;

import gui.ControlPane;
import gui.TicTacToePane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setPrefHeight(400);

		root.setPrefWidth(800);
		
		TicTacToePane ticTacToePane = new TicTacToePane();
		ControlPane controlPane = new ControlPane(ticTacToePane);
		
		GameLogic.getInstance().setControlPane(controlPane);
		
		root.getChildren().add(ticTacToePane);
		root.getChildren().add(controlPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
