package tic.tac.toe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import org.json.JSONException;
import org.json.JSONObject;

public class GameOnlineBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Line HLine1;
    protected final Line VLine2;
    protected final Line HLine2;
    protected final Line VLine1;
    protected final Label label6;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
    protected final Line line1;
    protected final Line line2;
    protected final Line line3;
    protected final Text gameInfo;
    protected final Button btn_back;
    protected final Line line4;
    
    private boolean turnX = true;
    private boolean playerTurn = true;
    private boolean gameOver = false;
    
    ArrayList<Label> labels;
    ConnectToServer connect = new ConnectToServer();
    FXMLDocumentController controller = new FXMLDocumentController();
    String username, sender, reciever, userXorO;
    
    Label RecLabel;
    Button record = new Button();
    Button load = new Button();
    Record r = new Record();
    String[][] Moves;
    ListView list;
    boolean recflag = false;

    public GameOnlineBase(Stage stage, String player1, String player2, String turn, boolean flag) {

        anchorPane = new AnchorPane();
        HLine1 = new Line();
        VLine2 = new Line();
        HLine2 = new Line();
        VLine1 = new Line();
        label6 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        line1 = new Line();
        line2 = new Line();
        line3 = new Line();
        gameInfo = new Text();
        btn_back = new Button();
        line4 = new Line();
        
        ListView<String> list = new ListView<String>();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        anchorPane.setLayoutX(-18.0);
        anchorPane.setMaxWidth(Double.MAX_VALUE);
        anchorPane.setMinWidth(USE_PREF_SIZE);
        anchorPane.setPrefHeight(700.0);
        anchorPane.setPrefWidth(612.0);

        HLine1.setEndX(121.0);
        HLine1.setLayoutX(428.0);
        HLine1.setLayoutY(55.0);
        HLine1.setStartX(-334.0);

        VLine2.setEndX(52.0);
        VLine2.setEndY(334.0);
        VLine2.setLayoutX(347.0);
        VLine2.setLayoutY(178.0);
        VLine2.setStartX(52.0);
        VLine2.setStartY(-123.0);

        HLine2.setEndX(277.0);
        HLine2.setEndY(-2.0);
        HLine2.setLayoutX(272.0);
        HLine2.setLayoutY(207.0);
        HLine2.setStartX(-178.0);

        VLine1.setEndX(-17.0);
        VLine1.setEndY(364.0);
        VLine1.setLayoutX(262.0);
        VLine1.setLayoutY(148.0);
        VLine1.setStartX(-17.0);
        VLine1.setStartY(-91.0);

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setLayoutX(399.0);
        label6.setLayoutY(205.0);
        label6.setPrefHeight(156.0);
        label6.setPrefWidth(150.0);
        label6.setFont(new Font(64.0));
        label6.setId("label6");

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(93.0);
        label1.setLayoutY(56.0);
        label1.setPrefHeight(150.0);
        label1.setPrefWidth(150.0);
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setFont(new Font(64.0));
        label1.setId("label1");

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label2.setLayoutX(246.0);
        label2.setLayoutY(57.0);
        label2.setPrefHeight(150.0);
        label2.setPrefWidth(150.0);
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setFont(new Font(64.0));
        label2.setId("label2");

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setLayoutX(399.0);
        label3.setLayoutY(55.0);
        label3.setPrefHeight(150.0);
        label3.setPrefWidth(150.0);
        label3.setFont(new Font(64.0));
        label3.setId("label3");

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setLayoutX(93.0);
        label4.setLayoutY(208.0);
        label4.setPrefHeight(150.0);
        label4.setPrefWidth(150.0);
        label4.setFont(new Font(64.0));
        label4.setId("label4");

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label5.setLayoutX(245.0);
        label5.setLayoutY(208.0);
        label5.setPrefHeight(150.0);
        label5.setPrefWidth(155.0);
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setFont(new Font(64.0));
        label5.setId("label5");

        label7.setAlignment(javafx.geometry.Pos.CENTER);
        label7.setLayoutX(92.0);
        label7.setLayoutY(361.0);
        label7.setPrefHeight(150.0);
        label7.setPrefWidth(150.0);
        label7.setFont(new Font(64.0));
        label7.setId("label7");

        label8.setAlignment(javafx.geometry.Pos.CENTER);
        label8.setLayoutX(246.0);
        label8.setLayoutY(361.0);
        label8.setPrefHeight(150.0);
        label8.setPrefWidth(150.0);
        label8.setFont(new Font(64.0));
        label8.setId("label8");

        label9.setAlignment(javafx.geometry.Pos.CENTER);
        label9.setLayoutX(399.0);
        label9.setLayoutY(358.0);
        label9.setPrefHeight(150.0);
        label9.setPrefWidth(150.0);
        label9.setFont(new Font(64.0));
        label9.setId("label9");
        
        labels = new ArrayList <>(Arrays.asList(label1,label2,label3,label4,label5,label6,label7,label8,label9));

        labels.forEach(label->
        {
            printPlayerMove(label);
            label.setFocusTraversable(false);
        }
        );

        line1.setEndX(100.0);
        line1.setLayoutX(449.0);
        line1.setLayoutY(57.0);
        line1.setStartX(100.0);
        line1.setStartY(455.20709228515625);

        line2.setEndX(93.0);
        line2.setEndY(56.0);
        line2.setStartX(92.0);
        line2.setStartY(511.0);

        line3.setEndX(92.2928466796875);
        line3.setEndY(363.0);
        line3.setLayoutY(-4.0);
        line3.setStartX(549.5);
        line3.setStartY(363.0);

        gameInfo.setLayoutX(223.0);
        gameInfo.setLayoutY(560.0);
        gameInfo.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        gameInfo.setStrokeWidth(0.0);
        gameInfo.setFont(new Font(24.0));

        btn_back.setLayoutX(263.0);
        btn_back.setLayoutY(628.0);
        btn_back.setMnemonicParsing(false);
        btn_back.setOnAction(this::backToOnline);
        btn_back.setText("Back To Online");
        btn_back.setVisible(false);

        line4.setEndX(530.5);
        line4.setEndY(508.70709228515625);
        line4.setLayoutY(4.0);
        line4.setStartX(74.5);
        line4.setStartY(507.70709228515625);

        anchorPane.getChildren().add(HLine1);
        anchorPane.getChildren().add(VLine2);
        anchorPane.getChildren().add(HLine2);
        anchorPane.getChildren().add(VLine1);
        anchorPane.getChildren().add(label6);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        anchorPane.getChildren().add(label5);
        anchorPane.getChildren().add(label7);
        anchorPane.getChildren().add(label8);
        anchorPane.getChildren().add(label9);
        anchorPane.getChildren().add(line1);
        anchorPane.getChildren().add(line2);
        anchorPane.getChildren().add(line3);
        anchorPane.getChildren().add(gameInfo);
        anchorPane.getChildren().add(btn_back);
        anchorPane.getChildren().add(record);
        anchorPane.getChildren().add(load);
        getChildren().add(anchorPane);
        getChildren().add(line4);
        
        
        
        record.setText("Record");
        load.setText("Load");
        
        record.setPrefHeight(21.0);
        record.setPrefWidth(92.0);
        record.setLayoutX(20.0);
        record.setLayoutY(100);
        load.setPrefHeight(21.0);
        load.setPrefWidth(92.0);
        load.setLayoutX(20.0);
        load.setLayoutY(50);
        record.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                recflag = true;
            }
        });
        
        
        load.setOnAction((ActionEvent Action) -> {
            clearBoard();
            ObservableList<String> items = r.retriveAllFiles();
            list.setItems(items);
            list.setPrefWidth(100);
            list.setPrefHeight(100);
            list.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    clearBoard();

                    new Thread() {
                        @Override
                        public void run() {

                            try {
                                String path = (String) list.getSelectionModel().getSelectedItem();
                                Moves = r.read(path);
                                for (int i = 0; i < Moves.length; i++) {
                                    if (Moves[i][0] != null) {

                                        String Turn = Moves[i][0].toString();
                                        String value = Moves[i][1].toString();
                                        //      DrawonBoard(Turn, value);
                                        Platform.runLater(() -> {
                                            switch (Turn) {

                                                case "label1": {
                                                    label1.setText(value);
                                                    break;
                                                }
                                                case "label2": {
                                                    label2.setText(value);
                                                    break;
                                                }
                                                case "label3": {
                                                    label3.setText(value);
                                                    break;
                                                }
                                                case "label4": {
                                                    label4.setText(value);
                                                    break;
                                                }
                                                case "label5": {
                                                    label5.setText(value);
                                                    break;
                                                }
                                                case "label6": {
                                                    label6.setText(value);
                                                    break;
                                                }
                                                case "label7": {
                                                    label7.setText(value);
                                                    break;
                                                }
                                                case "label8": {
                                                    label8.setText(value);
                                                    break;
                                                }
                                                case "label9": {
                                                    label9.setText(value);
                                                    break;
                                                }
                                            }
                                        });
                                    
                                    try {

                                        sleep(1000);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    }
                                }

                            } catch (IOException ex) {
                                Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }.start();

                }

            });                  
     
                anchorPane.getChildren ().add(list);
            
        });    
        
        
        if(turn.equals("X")){
            playerTurn = true;
            userXorO = "X";
            System.out.println("you are player X");
        } else {
            playerTurn = false;
            userXorO = "O";
            System.out.println("turn: " + "you are player O");
        }
        
        if(flag){
            username = player2;
            sender = player2;
            reciever = player1;
        } else {
            username = player1;
            sender = player1;
            reciever = player2;
            
        }
        
        
        gameInfo.setText(player1 + " VS " + player2);
        
        System.out.println("user is: " + username);
        System.out.println("sender is: " + sender);
        System.out.println("reciever is: " + reciever);
        
        new Thread(){
        
            @Override
            public void run(){
                while(true){
                    
                    JSONObject obj = connect.moveRecieved();
                    System.out.println("recieved: " + obj);
                    
                    try {
                        
                        
                        String turn = obj.getString("turn");
                        String square = obj.getString("square");
                        String sender = obj.getString("sender");
                        String reciever = obj.getString("reciever");
                        
                        if(turn.equals("X")){
                            turnX = false;
                            
                        } else {
                            turnX = true;
                        }
                        
                        
                        switch(square){
                                case "label1":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label1.setText(turn);
                                        r.SaveMoves("label1", turn);
                                        gameOver = checkGameIsOver(null);

                                        label1.setDisable(true);
                                    }

                                    });

                                    break;

                                case "label2":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label2.setText(turn);
                                        label2.setDisable(true);
                                        r.SaveMoves("label2", turn);
                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label3":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label3.setText(turn);
                                        label3.setDisable(true);
                                         r.SaveMoves("label3", turn);
                                         gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label4":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label4.setText(turn);
                                        label4.setDisable(true);
                                        r.SaveMoves("label4", turn);

                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label5":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label5.setText(turn);
                                        label5.setDisable(true);
                                        r.SaveMoves("label5", turn);
                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label6":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label6.setText(turn);
                                        label6.setDisable(true);
                                        r.SaveMoves("label6", turn);
                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label7":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label7.setText(turn);
                                        label7.setDisable(true);
                                        r.SaveMoves("label7", turn);
                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label8":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label8.setText(turn);
                                        label8.setDisable(true);
                                        r.SaveMoves("label8", turn);
                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                case "label9":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label9.setText(turn);
                                        label9.setDisable(true);
                                        r.SaveMoves("label9", turn);
                                        gameOver = checkGameIsOver(null);
                                    }

                                    });
                                    break;

                                default: 
                                    System.out.println("error");
                                    
                                    break;
                            
                            }
                        
                            playerTurn = true;
                        
                    } catch (JSONException ex) {
                        Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }.start();
        

    }

    private void printPlayerMove(Label label){
        
        label.setOnMouseClicked( mouseEvent ->{
            
            if(!gameOver && playerTurn){
                
                boolean turnX = setPlayerTurn(label);
                label.setDisable(true);

                String turn = "";
                if(!turnX){ turn = "X"; } else { turn = "O"; }
                
                if (recflag == true) {
                    r.SaveMoves(label.getId(), turn);
                }
                
                connect.sendMove(sender, reciever, turn, label.getId());
                playerTurn = false;
                
                checkGameIsOver(mouseEvent);
                
           }
        });
    }
      
    public boolean setPlayerTurn (Label label){
        if (turnX == true){

            label.setText("X");
            connect.sendMove(sender, reciever, "X", label.getId());
            turnX = false;
        }

        else {
            label.setText("O");
            connect.sendMove(sender, reciever, "O", label.getId());
            turnX = true;

        }
        return turnX;
      }
    
    
    public boolean checkGameIsOver(MouseEvent mouseEvent){
          
        for (int a = 0 ; a < 8; a++){

            String line = "" ;

            switch(a){

                case 0 :
                    line = label1.getText()+label2.getText()+label3.getText();
                     break;

                case 1 :
                    line = label4.getText()+label5.getText()+label6.getText();
                    break;

                case 2 :
                    line = label7.getText()+label8.getText()+label9.getText();
                    break;

                case 3 :
                    line = label3.getText()+label5.getText()+label7.getText();
                    break;

                case 4 :
                    line = label1.getText()+label4.getText()+label6.getText();
                    break;

                case 5 :
                    line = label2.getText()+label5.getText()+label8.getText();
                    break;

                case 6 :
                    line = label3.getText()+label6.getText()+label9.getText(); 
                    break;

                case 7 :
                    line = label1.getText()+label5.getText()+label9.getText(); 
                    break;

                default : line="";

            }

            if (line.equals("XXX")){
     //           Score1Text.setText("1");
               gameOver = true;
                if(userXorO.equals("X") && mouseEvent!=null){
                    try {
                    
                    controller.goToVideo(mouseEvent, username);
                } catch (IOException ex) {
                    Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                } else {
                    gameInfo.setText("You lost!");
                    btn_back.setVisible(true);
                }
                
                System.out.println("Player X wins");

            }
            
            else if( line.equals("OOO")){
     //          Score1Text.setText("o");
               gameOver = true;
               
                if(userXorO.equals("O") && mouseEvent!=null){
                    
                    try {
                    controller.goToVideo(mouseEvent, username);
                } catch (IOException ex) {
                    Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                }else {
                    gameInfo.setText("You lost!");
                    btn_back.setVisible(true);
                }
                
                System.out.println("Player O wins");
            } 

        }
        
        return gameOver;
        
    }
    
    
     public void clearBoard() {
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
        label7.setText("");
        label8.setText("");
        label9.setText("");

    }

    protected void backToOnline(javafx.event.ActionEvent actionEvent) {
        try {
            controller.goToGameMode(actionEvent);
        
        } catch (IOException ex) {
            Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
