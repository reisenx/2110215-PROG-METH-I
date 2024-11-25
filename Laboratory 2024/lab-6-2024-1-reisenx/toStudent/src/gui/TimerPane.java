package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import logic.Timer;

public class TimerPane extends VBox{

    private Text header;
    private Text timer;

    private int pl;

    public TimerPane(int pl) {
        super();

        this.setPrefWidth(192);
        this.setPrefHeight(80);
        this.setAlignment(Pos.CENTER);

        if(pl==0){header = new Text("O"+" Timer");}
        else{header = new Text("X"+" Timer");}

        timer = new Text("00:00:00");

        header.setFont(new Font(25));
        timer.setFont(new Font(20));

        this.getChildren().add(header);
        this.getChildren().add(timer);


        setTimer(GameLogic.getPlayerTimer(pl));





    }

    public void setTimer(Timer t) {
        this.getChildren().remove(timer);
        this.getChildren().add(timer);
        timer.setText(t.toString());
    }


}
