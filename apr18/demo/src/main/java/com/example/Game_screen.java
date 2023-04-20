package com.example;

import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Game_screen {
    int inc_char_guess = 0;
    Boolean game_won = false;

    public Game_screen(Stage oldStage, int gamemode){
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        String mode = " ";
        if (gamemode == 1){
            mode = "Animals";
        }
        else if (gamemode == 2){
            mode = "Fruits";
        }
        else{
            mode = "Movies";
        }
        
        newStage.setTitle("Hangman Category: " + mode);

        
    // public Game_screen(Stage oldStage, int gamemode){
    //     Stage newStage = new Stage();

    //     newStage.initOwner(oldStage);
    //     if (gamemode == 1){
    //         System.out.println("new scene mode: 1");
    //     }
    //     else if (gamemode == 2){
    //         System.out.println("new scene mode: 2");
    //     }
    //     else if (gamemode == 3){
    //         System.out.println("new scene mode: 3");
    //     }
    //     Button win_button = new Button("Win");
    //     Button lose_button = new Button("Win");

    //     win_button.onAction()
//Hearts
        ImageView heart1 = new ImageView(getClass().getResource("/com/example/images/full_heart.png").toExternalForm());
        heart1.setFitHeight(50);
        heart1.setPreserveRatio(true);

        ImageView heart2 = new ImageView(getClass().getResource("/com/example/images/full_heart.png").toExternalForm());
        heart2.setFitHeight(50);
        heart2.setPreserveRatio(true);

        ImageView heart3 = new ImageView(getClass().getResource("/com/example/images/full_heart.png").toExternalForm());
        heart3.setFitHeight(50);
        heart3.setPreserveRatio(true);

    //Hint 
        Text hint_label = new Text("Hint");
        hint_label.setFont(Font.font("Helvetica",FontWeight.NORMAL, 36));
        ImageView hint = new ImageView(getClass().getResource("/com/example/images/hint.png").toExternalForm());
        hint.setFitHeight(100);
        hint.setPreserveRatio(true);
        hint.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                inc_char_guess+=1;
                System.out.println("Hint pressed." + inc_char_guess);
            }
        });
        hint.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                hint.setFitHeight(105);
                hint.setPreserveRatio(true);
            }
        });
        hint.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                hint.setFitHeight(100);
                hint.setPreserveRatio(true);
            }
        });

    //Hangman Pic
        ImageView hangman = new ImageView(getClass().getResource("/com/example/images/hangman_1.png").toExternalForm());
        hangman.setFitHeight(300);
        hangman.setPreserveRatio(true);


        if (inc_char_guess == 0){
            hangman = new ImageView(getClass().getResource("/com/example/images/hangman_1.png").toExternalForm());
            hangman.setFitHeight(300);
            hangman.setPreserveRatio(true);
        }
        else if (inc_char_guess == 1){
            hangman = new ImageView(getClass().getResource("/com/example/images/hangman_2.png").toExternalForm());
            hangman.setFitHeight(300);
            hangman.setPreserveRatio(true);
        }
        else if (inc_char_guess == 2){
            hangman = new ImageView(getClass().getResource("/com/example/images/hangman_3.png").toExternalForm());
            hangman.setFitHeight(300);
            hangman.setPreserveRatio(true);
        }
        else if (inc_char_guess == 3){
            hangman = new ImageView(getClass().getResource("/com/example/images/hangman_4.png").toExternalForm());
            hangman.setFitHeight(300);
            hangman.setPreserveRatio(true);
        }
        else if (inc_char_guess == 4){
            hangman = new ImageView(getClass().getResource("/com/example/images/hangman_5.png").toExternalForm());
            hangman.setFitHeight(300);
            hangman.setPreserveRatio(true);
        }
    //Layout
        VBox hearts = new VBox(heart1, heart2, heart3);
        hearts.setAlignment(Pos.TOP_LEFT);
        hearts.setPadding(new Insets(50, 0, 0, 100));
        hearts.setSpacing(20);

        VBox hangbox = new VBox(hangman);
        hangbox.setAlignment(Pos.TOP_CENTER);

        VBox hints = new VBox(hint_label, hint);
        hints.setAlignment(Pos.CENTER);
        hints.setPadding(new Insets(-50, 0, 0, 0));
        hints.setSpacing(20);

        HBox toprow = new HBox(hearts, hangman, hints);
        //toprow.setAlignment(Pos.TOP_CENTER);
        toprow.setPadding(new Insets(50, 0, 0, 0));
        toprow.setSpacing(250);


        VBox check = new VBox(toprow);
    
        Scene currentScene = new Scene(check, 1024, 768);
        newStage.setScene(currentScene);
    
        newStage.show();
    // }
    }
}
