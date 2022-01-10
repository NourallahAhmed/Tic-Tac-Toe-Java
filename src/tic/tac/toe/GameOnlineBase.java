package tic.tac.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
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

    private boolean turnX = true;
    private boolean gameOver = false;
    ArrayList<Label> labels;
    
    private Socket server;
    DataInputStream dis;
    PrintStream ps;
    
    public GameOnlineBase(Stage stage) {

        
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

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setLayoutX(-18.0);
        anchorPane.setMaxWidth(Double.MAX_VALUE);
        anchorPane.setMinWidth(USE_PREF_SIZE);
        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(612.0);

        HLine1.setEndX(135.0);
        HLine1.setLayoutX(295.0);
        HLine1.setLayoutY(75.0);
        HLine1.setStartX(-138.0);

        VLine2.setEndX(52.0);
        VLine2.setEndY(48.0);
        VLine2.setLayoutX(290.0);
        VLine2.setLayoutY(149.0);
        VLine2.setStartX(52.0);
        VLine2.setStartY(-123.0);

        HLine2.setEndX(130.0);
        HLine2.setLayoutX(301.0);
        HLine2.setLayoutY(137.0);
        HLine2.setStartX(-143.0);

        VLine1.setEndX(-17.0);
        VLine1.setEndY(79.0);
        VLine1.setLayoutX(266.0);
        VLine1.setLayoutY(118.0);
        VLine1.setStartX(-17.0);
        VLine1.setStartY(-91.0);

        label6.setLayoutX(345.0);
        label6.setLayoutY(79.0);
        label6.setPrefHeight(53.0);
        label6.setPrefWidth(86.0);
        label6.setId("label6");

        label1.setLayoutX(158.0);
        label1.setLayoutY(27.0);
        label1.setPrefHeight(40.0);
        label1.setPrefWidth(81.0);
        label1.setId("label1");

        label2.setLayoutX(258.0);
        label2.setLayoutY(22.0);
        label2.setPrefHeight(44.0);
        label2.setPrefWidth(74.0);
        label2.setId("label2");

        label3.setLayoutX(352.0);
        label3.setLayoutY(32.0);
        label3.setPrefHeight(37.0);
        label3.setPrefWidth(73.0);
        label3.setId("label3");

        label4.setLayoutX(157.0);
        label4.setLayoutY(82.0);
        label4.setPrefHeight(48.0);
        label4.setPrefWidth(82.0);
        label4.setId("label4");

        label5.setLayoutX(255.0);
        label5.setLayoutY(77.0);
        label5.setPrefHeight(54.0);
        label5.setPrefWidth(79.0);
        label5.setId("label5");

        label7.setLayoutX(158.0);
        label7.setLayoutY(142.0);
        label7.setPrefHeight(45.0);
        label7.setPrefWidth(84.0);
        label7.setId("label7");

        label8.setLayoutX(256.0);
        label8.setLayoutY(141.0);
        label8.setPrefHeight(49.0);
        label8.setPrefWidth(77.0);
        label8.setId("label8");

        label9.setLayoutX(347.0);
        label9.setLayoutY(144.0);
        label9.setPrefHeight(45.0);
        label9.setPrefWidth(80.0);
        label9.setId("label9");


        labels = new ArrayList <>(Arrays.asList(label1,label2,label3,label4,label5,label6,label7,label8,label9));

        labels.forEach(label->
        {
            setUpLabels(label);
            label.setFocusTraversable(false);
        }
        );

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
        getChildren().add(anchorPane);

        try {
        
//        server = new Socket("127.0.0.1", 5005);
        server = new Socket("172.16.12.11", 5005);
        ps = new PrintStream(server.getOutputStream());
        dis = new DataInputStream(server.getInputStream());
        
//        ps.println("Turn X");


        

        new Thread(){

            @Override
            public void run() {
                while(true){
                    
                    try {

                        String msg = dis.readLine();
                        System.out.println("client: " + msg);
                        JSONObject obj = new JSONObject(msg);
                        System.out.println(obj.getString("turn"));
                        System.out.println(obj.getString("square"));
                        
                        String turn = obj.getString("turn");
                        String square = obj.getString("square");
                        
                        switch(square){

                                case "label1":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label1.setText(turn);
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
                                    }

                                    });
                                    break;

                                case "label3":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label3.setText(turn);
                                        label3.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label4":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label4.setText(turn);
                                        label4.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label5":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label5.setText(turn);
                                        label5.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label6":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label6.setText(turn);
                                        label6.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label7":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label7.setText(turn);
                                        label7.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label8":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label8.setText(turn);
                                        label8.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label9":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label9.setText(turn);
                                        label9.setDisable(true);
                                    }

                                    });
                                    break;
                                    
                                default: 
                                    System.out.println("error");
                            }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(PlayOnline.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JSONException ex) {
                        Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }.start();

        } catch (IOException ex) {
            Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        setLabelWithSymbol(label1, "X");

    }
    
    private void setLabelWithSymbol(Label label, String turn){
        setClientSymbol(label, turn);
        label.setDisable(true);
    }
    
    public void setClientSymbol (Label label, String turn){
        
        label.setText(turn);
        
    }
    
    
    private void setUpLabels(Label label){
        
        JSONObject obj = new JSONObject();
        
        label.setOnMouseClicked( mouseEvent ->{
            
            if(!gameOver){
                
                try {
//                    server = new Socket("127.0.0.1", 5005);
                    
                    server = new Socket("172.16.12.11", 5005);
                    ps = new PrintStream(server.getOutputStream());
                    dis = new DataInputStream(server.getInputStream());

                    boolean turnX = setPlayerSymbol(label);
                    label.setDisable(true);

                    String turn = "";
                    if(!turnX){ turn = "X"; } else { turn = "O"; }
//                    obj.put("turn", turn);
//                    obj.put("square", label.getId());

                    obj.put("username", "Nour");
                    obj.put("password", "1234");


//                    ps.println(obj.toString());
                    ps.println(obj);
                    ps.println("Turn X");

                    checkGameIsOver();

                } catch (JSONException ex) {
                      Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
                } catch(IOException iex){
                    Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, iex);
                }

           }
        });
    }
      
    
    public boolean setPlayerSymbol (Label label){
          JSONObject obj = new JSONObject();
          if (turnX == true){
              try {
                  
                  label.setText("X");
//                  System.out.println("player X played On: " + label.getId());
                  
                  obj.put("turn", "X");
                  obj.put("square", label.getId());
//                  turnX = false;
                  
//                  ps.println(obj.toString());
                  ps.println(obj);
                    turnX = false;
//                  ps.println("Turn X");
              } catch (JSONException ex) {
                  Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          
          else {
              try {
                  label.setText("O");
//                  System.out.println("player O played On: " + label.getId());
                  
//                  ps.println("Turn O");
                  obj.put("turn", "O");
                  obj.put("square", label.getId());
//                  turnX = true;
                  
//                  ps.println(obj.toString());
                  ps.println(obj);
                  turnX = true;
              } catch (JSONException ex) {
                  Logger.getLogger(GameOnlineBase.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          return turnX;
      }
    
    
    public void checkGameIsOver(){
          
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
               System.out.println("Player X wins");
               gameOver = true;

            }
            else if( line.equals("OOO")){
     //          Score1Text.setText("o");
               System.out.println("Player O wins");
               gameOver = true;
            } 

        }
        
    }
    
}
