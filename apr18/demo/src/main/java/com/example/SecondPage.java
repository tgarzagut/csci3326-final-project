package com.example;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SecondPage {
    public static TextField messageinput = new TextField();
    public static Label wordLabel = new Label("_ _ _ _ _");
    //label can be changed
    public Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C:/Users/poket/Downloads/java-labs/FinalJAVA/csci3326-final-project/apr18/demo/src/sampleDB.db";  
        Connection conn = null;  
        try {
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }
    public String selectAnimals(){  
        String sql = "SELECT * FROM animals";  
        String H = "";
        int random = (int)(Math.random()*521)+1;  
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            for(int i = 0; i<=random;i++) {
                rs.next();  
                if(i==random){
                    H = rs.getString("animal");
                }
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return H;  
    }  
    
    public String selectFruit(){  
        String sql = "SELECT * FROM fruits";  
        String H = "";
        int random = (int)(Math.random()*93)+1;  
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            for(int i = 0; i<=random;i++) {
                rs.next();  
                if(i==random){
                    H = rs.getString("fruit");
                }
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return H;  
    }
    
    public String selectMovie(){  
        String sql = "SELECT * FROM movies";  
        String H = "";
        int random = (int)(Math.random()*250)+1;  
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            for(int i = 0; i<=random;i++) {
                rs.next();  
                if(i==random){
                    H = rs.getString("movie");
                }
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return H;  
    }
    public char hint(String s, char g)
    {
        char let=' ';
        char hints []= new char [s.length()];
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!=g)
            {
                hints[i] = s.charAt(i);
            }
        }
        for(int x=0; x<hints.length; x++)
        {
            int rando= (int)(Math.random()*s.length());
            if(hints[x]!=g && hints[x]!=' ')
            {
                return hints[rando];
            }
        }
        return let;
    }
    public Boolean guess(String s, char g)
    {
        for(int i =0; i<s.length();i++)
        {
            if(s.charAt(i)==g)
            {
                return true;
            }
        }
        return false;
    }
    public Boolean guessWord(String s, String g)
    {
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!=g.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
    public static class choice{
        public static int choose;
    }
    public static class gcounter{
        public static int couter = 0;
    }
    public static class hcounter{
        public static int couter = 0;
    }
    public static class ccounter{
        public static int couter = 0;
    }
    public static class dword{
        public static String word = set();
    }
    public static String set(){
        String word = " ";
        //sets up cab
        SecondPage cab = new SecondPage(null);
        if(choice.choose == 1){
            word = cab.selectAnimals();
        }else if(choice.choose == 2){
            word = cab.selectFruit();
        }else{
            word = cab.selectMovie();
        }
        return word;
    }
    public String getSize(String s)
    {
        String g=s;
        for(int i=0; i<s.length();i++)
        {
            g.replace(g.charAt(i), '_');
        }
        System.out.println(g);
        return g;
    }
    Image hanImage = new Image(getClass().getResource("/com/example/images/hangman_1.png").toExternalForm());
    ImageView hangman = new ImageView();

    String insidechar = "Wrong guesses: ";
    Label wrong_guess = new Label(insidechar);

    String insideCchar = "Correct guesses: ";
    Label corr_guess = new Label(insideCchar);

    String ichar = "Hints: ";
    Label hints_store = new Label(ichar);
    

    public SecondPage(Stage oldStage){
        //wrong_guess.setPrefHeight(200);
        //corr_guess.setPrefHeight(200);
        wrong_guess.setFont(Font.font
        ("Helvetica",FontWeight.NORMAL, 36));
        corr_guess.setFont(Font.font("Helvetica",FontWeight.NORMAL, 36));
        hangman.setImage(hanImage);
        hangman.setFitHeight(300);
        hangman.setPreserveRatio(true);
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        newStage.setTitle("Hangman Deluxe! - Game");

        Region spacer0 = new Region();
        spacer0.setPrefWidth(50);
        //draw hearts (lives) and you can change the color to white if you lose a life
        SVGPath heart1 = new SVGPath();
        heart1.setContent("M0,20 C0,9 8,-8 32,0 C56,-8 68,9 68,20 C68,30 63,37 50,50 L32,68 L14,50 C1,37 -4,30 -4,20 C-4,4 14,-8 32,4 C50,-8 62,4 68,20 C68,31 68,39 68,20 C68,9 60,-8 32,0 C4,-8 0,9 0,20");
        heart1.setFill(Color.RED);
        SVGPath heart2 = new SVGPath();
        heart2.setContent("M0,20 C0,9 8,-8 32,0 C56,-8 68,9 68,20 C68,30 63,37 50,50 L32,68 L14,50 C1,37 -4,30 -4,20 C-4,4 14,-8 32,4 C50,-8 62,4 68,20 C68,31 68,39 68,20 C68,9 60,-8 32,0 C4,-8 0,9 0,20");
        heart2.setFill(Color.RED);
        SVGPath heart3 = new SVGPath();
        heart3.setContent("M0,20 C0,9 8,-8 32,0 C56,-8 68,9 68,20 C68,30 63,37 50,50 L32,68 L14,50 C1,37 -4,30 -4,20 C-4,4 14,-8 32,4 C50,-8 62,4 68,20 C68,31 68,39 68,20 C68,9 60,-8 32,0 C4,-8 0,9 0,20");
        heart3.setFill(Color.RED);
        VBox heartbox = new VBox(heart1, heart2, heart3);
        heartbox.setAlignment(Pos.CENTER);

        //draws the hangman, It doesnt change but if we need it to ig we will add it
        // Canvas canvas = new Canvas(225, 225);
        // GraphicsContext gc = canvas.getGraphicsContext2D();
        // gc.setFill(Color.web("#f4f4f4"));
        // gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // gc.setStroke(Color.BLACK);
        // gc.setLineWidth(4);
        // //x1, y1, x2, y2
        // //bottom line
        // gc.strokeLine(50, 200, 150, 200);
        // //line down
        // gc.strokeLine(100, 200, 100, 20);
        // gc.strokeLine(100, 20, 160, 20);
        // gc.strokeLine(160, 20, 160, 40);
        // //head
        // gc.strokeOval(145, 40, 30, 30);
        // //torso
        // gc.strokeLine(160, 70, 160, 120);
        // //legs
        // gc.strokeLine(160, 120, 145, 140);
        // gc.strokeLine(175, 140, 160, 120);
        // gc.strokeLine(160, 80, 145, 90);
        // gc.strokeLine(160, 80, 175, 90);


        //button for the hint, I didnt put any options but it would just make a letter pop up?? I think we can make it disappear after 1 hint
        Label hint_label = new Label("Hint");
        hint_label.setFont(Font.font("Helvetica",FontWeight.NORMAL, 36));
        ImageView hint = new ImageView(getClass().getResource("/com/example/images/hint.png").toExternalForm());
        hint.setFitHeight(100);
        hint.setPreserveRatio(true);
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        hint.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if(hcounter.couter==3)
                {
                    hint.setEffect(colorAdjust);
                    hint.disableProperty();
                }
                 else
                { 
                    if(hcounter.couter==2)
                {
                    hint.setEffect(colorAdjust);
                }
                hcounter.couter=hcounter.couter+1;
                System.out.println("Hint pressed.");
                System.out.println(hint(dword.word, messageinput.getText().charAt(0)));

                ichar = ichar + " " + hint(dword.word, messageinput.getText().charAt(0));

                hints_store.setText(ichar);
                }
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
        //spacers
        




        Label entermessage = new Label("Enter Letter Guess!");
        entermessage.setFont(Font.font("Arial"));
        entermessage.setStyle("-fx-font-size: 36px");

        messageinput.setPrefWidth(150);
        messageinput.setFont(new Font(20));


       
        //button if you want to guess the word
        Button button = new Button("Guess Word!");
        button.setStyle("-fx-background-color: purple; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px"); 
        button.setPrefWidth(120);
        button.setPrefHeight(50);
        button.setOnAction(event -> {
            //if(button.isPressed()){
                if(gcounter.couter==3)
                {
                    button.disableProperty();
                    new Lose(newStage);
                        heart3.setFill(Color.BLACK);
                }
                else
                {
                    gcounter.couter= gcounter.couter+1;
                    System.out.println(dword.word);    
                    System.out.println(guessWord(dword.word,messageinput.getText()));
                    if(guessWord(dword.word, messageinput.getText())==true)
                    {
                        new Win(newStage);
                    }
                    else 
                    {
                        if(gcounter.couter==1)
                        {
                            heart1.setFill(Color.BLACK);
                        }
                        else if(gcounter.couter==2)
                        {
                            heart2.setFill(Color.BLACK);
                        }
                    }
                }

            //}
        });
        Button guesscharButton = new Button("Guess character");
        guesscharButton.setStyle("-fx-background-color: purple; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px"); 
        guesscharButton.setPrefWidth(120);
        guesscharButton.setPrefHeight(50);
        guesscharButton.setOnAction(event -> {
            if(guess(dword.word, messageinput.getText().charAt(0))==false){
                ccounter.couter = ccounter.couter+1;
                insidechar = insidechar + " " + messageinput.getText().charAt(0);
                wrong_guess.setText(insidechar);
            }
            else{
                insideCchar = insideCchar + " " + messageinput.getText().charAt(0);
            corr_guess.setText(insideCchar);
            }
            if(ccounter.couter==1){
                Image hang0Image = new Image(getClass().getResource("/com/example/images/hangman_2.png").toExternalForm());
                hangman.setImage(hang0Image);
                hangman.setFitHeight(300);
                hangman.setPreserveRatio(true);
            }
            else if(ccounter.couter==2){
                Image hang1Image = new Image(getClass().getResource("/com/example/images/hangman_3.png").toExternalForm());
                hangman.setImage(hang1Image);
                hangman.setFitHeight(300);
                hangman.setPreserveRatio(true);
            }
            else if(ccounter.couter==3){
                Image hang2Image = new Image(getClass().getResource("/com/example/images/hangman_4.png").toExternalForm());
                hangman.setImage(hang2Image);
                hangman.setFitHeight(300);
                hangman.setPreserveRatio(true);
            }
            else if(ccounter.couter==4){
                Image hang3Image = new Image(getClass().getResource("/com/example/images/hangman_5.png").toExternalForm());
                hangman.setImage(hang3Image);
                hangman.setFitHeight(300);
                hangman.setPreserveRatio(true);
                new Lose(newStage);
            }
            System.out.println(dword.word);    
            System.out.println(guess(dword.word,messageinput.getText().charAt(0)));
        });
        HBox hintbox = new HBox(hint_label, hint);


        HBox toprow = new HBox(heartbox, hangman, hint);
        toprow.setAlignment(Pos.TOP_CENTER);
        toprow.setSpacing(150);

        HBox buttonsrow = new HBox(button, guesscharButton);
        buttonsrow.setAlignment(Pos.CENTER);
        buttonsrow.setSpacing(20);


        HBox guess = new HBox(entermessage, messageinput, buttonsrow);
        guess.setPadding(new Insets(30));
        guess.setAlignment(Pos.CENTER);
        guess.setSpacing(50);

        wordLabel.setFont(new Font(20));
        VBox charbox = new VBox(wrong_guess, corr_guess, hints_store);
        charbox.setSpacing(20);
        charbox.setAlignment(Pos.BOTTOM_LEFT);
        charbox.setPadding(new Insets(0, 0, 0, 125));

        
        VBox mainContainer = new VBox(toprow, wordLabel, guess, charbox);
        mainContainer.setSpacing(10);
        mainContainer.setAlignment(Pos.CENTER);
        
        Scene currentScene = new Scene(mainContainer, 1024, 768);
        newStage.setScene(currentScene);
        newStage.show();
        }





}
