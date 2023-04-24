package com.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.SecondPage.choice;

//import javax.naming.directory.SearchControls;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Word Guessing Game");

    //Choose mode image
        ImageView choosemode = new ImageView(getClass().getResource("/com/example/images/choose_mode.png").toExternalForm());
        choosemode.setFitHeight(325);
        choosemode.setPreserveRatio(true);

    //Random Button
        ImageView randomButton = new ImageView(getClass().getResource("/com/example/images/randomButton.png").toExternalForm());
        randomButton.setFitHeight(55);
        randomButton.setPreserveRatio(true);
        randomButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println("TEST: Random Button pressed");
                int mode = (int) (Math.random() * (3+1-1)+1);
                if (mode == 1){
                    //selectAnimals();
                    System.out.println("mode chosen: " + "animals");
                }
                else if(mode == 2){
                    //selectFruit();
                    System.out.println("mode chosen: " + "fruit");
                }
                else{
                    //selectMovie();
                    System.out.println("mode chosen: " + "movies");
                }
                //new Game_screen(stage, mode);
                new SecondPage(stage);
            }
        });
        randomButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                randomButton.setFitHeight(60);
                randomButton.setPreserveRatio(true);
            }
        });
        randomButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                randomButton.setFitHeight(55);
                randomButton.setPreserveRatio(true);
            }
        });

    //Animal Button
        ImageView animalButton = new ImageView(getClass().getResource("/com/example/images/animalButton.png").toExternalForm());
        animalButton.setFitHeight(55);
        animalButton.setPreserveRatio(true);
        animalButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println("TEST: Animal button pressed");
                //new Game_screen(stage, 1);
                new SecondPage(stage);
            }
        });
        animalButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                animalButton.setFitHeight(60);
                animalButton.setPreserveRatio(true);
                choice.choose = 1;
            }
        });
        animalButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                animalButton.setFitHeight(55);
                animalButton.setPreserveRatio(true);
            }
        });

    //Fruits Button
        ImageView fruitsButton = new ImageView(getClass().getResource("/com/example/images/fruitsButton.png").toExternalForm());
        fruitsButton.setFitHeight(55);
        fruitsButton.setPreserveRatio(true);
        fruitsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println("TEST: Fruits button pressed");
                //new Game_screen(stage, 2);
                new SecondPage(stage);
            }
        });
        fruitsButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                fruitsButton.setFitHeight(60);
                fruitsButton.setPreserveRatio(true);
                choice.choose = 2;
            }
        });
        fruitsButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                fruitsButton.setFitHeight(55);
                fruitsButton.setPreserveRatio(true);
            }
        });
    
    //Movies Button
        ImageView moviesButton = new ImageView(getClass().getResource("/com/example/images/moviesButton.png").toExternalForm());
        moviesButton.setFitHeight(55);
        moviesButton.setPreserveRatio(true);
        moviesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println("TEST: Movies button pressed");
                //new Game_screen(stage, 3);
                new SecondPage(stage);
            }
        });
        moviesButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                moviesButton.setFitHeight(60);
                moviesButton.setPreserveRatio(true);
                choice.choose = 3;
            }
        });
        moviesButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                moviesButton.setFitHeight(55);
                moviesButton.setPreserveRatio(true);
            }
        });


    //Layout
        HBox picture = new HBox(choosemode);
        picture.setAlignment(Pos.TOP_CENTER);
        picture.setPadding(new Insets(100,0,50,0));

        HBox buttonsRow = new HBox(animalButton, fruitsButton);
        buttonsRow.setAlignment(Pos.BOTTOM_CENTER);
        buttonsRow.setPadding(new Insets(30));
        buttonsRow.setSpacing(75);

        VBox layoutBox = new VBox(picture, randomButton, buttonsRow, moviesButton);
        layoutBox.setAlignment(Pos.CENTER);
        layoutBox.setPadding(new Insets(0,0,125,0));

    //Scene
        scene = new Scene(layoutBox, 1024, 768);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}