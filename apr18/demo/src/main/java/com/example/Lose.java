package com.example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lose {
    public Lose(Stage oldStage){
        Stage newStage = new Stage();

        newStage.initOwner(oldStage);

        Label game_status = new Label("You lose!");
        game_status.setStyle("-fx-font-size: 36px");

        Label congrats = new Label("Oh no!");
        congrats.setStyle("-fx-font-size: 36px");
        
        VBox finalBox = new VBox(congrats, game_status);
        finalBox.setSpacing(30);
        finalBox.setAlignment(Pos.CENTER);

        Scene currentScene = new Scene(finalBox, 412, 284);
        newStage.setScene(currentScene);
        newStage.show();
        
    }
}