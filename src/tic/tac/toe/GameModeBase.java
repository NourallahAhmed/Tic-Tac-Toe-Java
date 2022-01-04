package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameModeBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button vsComputerBtn;
    protected final Button playOnlineBtn;
    protected final Button playWithFriendBtn;
    protected final FlowPane flowPane;
    //protected final Text playerNameText;
    //protected static Text playerNameText;

    //protected final Label label;
    //protected final Text scoreText;
    //protected static Text scoreText;


    FXMLDocumentController controller=new FXMLDocumentController();
    
    
   
    
    public GameModeBase(Stage stage ) {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        vsComputerBtn = new Button();
        playOnlineBtn = new Button();
        playWithFriendBtn = new Button();
        flowPane = new FlowPane();
        //playerNameText = new Text();
        //label = new Label();
        //scoreText = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(345.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(600.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(548.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(293.0);
        columnConstraints0.setMinWidth(0.0);
        columnConstraints0.setPrefWidth(52.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        vsComputerBtn.setId("playvscomputer");
        vsComputerBtn.setMnemonicParsing(false);
        vsComputerBtn.setOnAction(this::playVsComputer);
        vsComputerBtn.setText("Play Vs Computer");
        GridPane.setMargin(vsComputerBtn, new Insets(0.0, 0.0, 0.0, 250.0));
        vsComputerBtn.setFont(new Font("System Bold", 15.0));

        GridPane.setRowIndex(playOnlineBtn, 2);
        playOnlineBtn.setId("playonline");
        playOnlineBtn.setMnemonicParsing(false);
        playOnlineBtn.setOnAction(this::playOnline);
        playOnlineBtn.setText("Play Online");
        playOnlineBtn.setPrefWidth(150.0);
        GridPane.setMargin(playOnlineBtn, new Insets(0.0, 0.0, 10.0, 250.0));
        playOnlineBtn.setFont(new Font("System Bold", 15.0));

        GridPane.setRowIndex(playWithFriendBtn, 1);
        playWithFriendBtn.setId("playwithfriend");
        playWithFriendBtn.setMnemonicParsing(false);
        playWithFriendBtn.setOnAction(this::playWithFriend);
        playWithFriendBtn.setText("Play With  a friend");
        GridPane.setMargin(playWithFriendBtn, new Insets(0.0, 0.0, 10.0, 250.0));
        playWithFriendBtn.setFont(new Font("System Bold", 15.0));
        setCenter(gridPane);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(110.0);
        flowPane.setPrefWidth(600.0);
        /*
        playerNameText.setId("playername");
        playerNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerNameText.setStrokeWidth(0.0);
        playerNameText.setText("Player name");
        playerNameText.setWrappingWidth(96.03125);
        playerNameText.setFont(new Font("System Bold", 15.0));
        FlowPane.setMargin(playerNameText, new Insets(30.0, 10.0, 10.0, 30.0));

        label.setId("scorestext");
        label.setPrefHeight(21.0);
        label.setPrefWidth(53.0);
        label.setText("Scores");
        FlowPane.setMargin(label, new Insets(30.0, 10.0, 10.0, 310.0));
        label.setFont(new Font("System Bold", 15.0));

        scoreText.setId("scoresnumber");
        scoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(0.0);
        scoreText.setText("2");
        FlowPane.setMargin(scoreText, new Insets(30.0, 10.0, 10.0, 0.0));
        scoreText.setFont(new Font("System Bold", 15.0));
        setTop(flowPane);*/

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(vsComputerBtn);
        gridPane.getChildren().add(playOnlineBtn);
        gridPane.getChildren().add(playWithFriendBtn);
       // flowPane.getChildren().add(playerNameText);
       // flowPane.getChildren().add(label);
        //flowPane.getChildren().add(scoreText);
        
     

        
    }
    
    /*
       public static void name(User user){

//      User user = DAL.selectPalyer();
        playerNameText.setText(user.getUsername());
        scoreText.setText(String.valueOf(user.getScore()));};
    */

    protected void playVsComputer(javafx.event.ActionEvent actionEvent) {
        /*]
        try {
            controller.goToPlayWithFriend(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

    protected void playOnline(javafx.event.ActionEvent actionEvent) {
        try {
            //controller.goToUsersList(actionEvent);
            controller.goToLogin(actionEvent);
            
        } catch (IOException ex) {
            Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void playWithFriend(javafx.event.ActionEvent actionEvent) {
        try {
            controller.goToPlayWithFriend(actionEvent);
        
        } catch (IOException ex) {
            Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
