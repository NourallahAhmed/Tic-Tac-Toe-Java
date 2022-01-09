/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.*;

public  class GameScene extends BorderPane {

    protected final BorderPane borderPane;
    protected final FlowPane flowPane;
    protected final BorderPane borderPane0;
    protected final Line line;
    protected final FlowPane flowPane0;
    protected final Text Player1Text;
    protected final Text Score1Text;
    protected final Text ONotationText;
    protected final FlowPane flowPane1;
    protected final BorderPane borderPane1;
    protected final Line line0;
    protected final FlowPane flowPane2;
    protected final Text Player2Text;
    protected final Text Score1Text1;
    protected final Text XNotationText;
    protected final BorderPane borderPane2;
    protected final FlowPane flowPane3;
    protected final MenuButton menuList;
    protected final MenuItem homeButton;
    protected final MenuItem resetButton;
    protected final Text gameText;
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
    
    private int playerTurn=0;
    ArrayList<Label> labels;
    
    private Socket server;
    DataInputStream dis;
    PrintStream ps;

    
    public GameScene(Stage stage) {

//        try {
            borderPane = new BorderPane();
            flowPane = new FlowPane();
            borderPane0 = new BorderPane();
            line = new Line();
            flowPane0 = new FlowPane();
            Player1Text = new Text();
            Score1Text = new Text();
            ONotationText = new Text();
            flowPane1 = new FlowPane();
            borderPane1 = new BorderPane();
            line0 = new Line();
            flowPane2 = new FlowPane();
            Player2Text = new Text();
            Score1Text1 = new Text();
            XNotationText = new Text();
            borderPane2 = new BorderPane();
            flowPane3 = new FlowPane();
            menuList = new MenuButton();
            homeButton = new MenuItem();
            resetButton = new MenuItem();
            gameText = new Text();
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

            labels = new ArrayList <>(Arrays.asList(label1,label2,label3,label4,label5,label6,label7,label8,label9));

            labels.forEach(label->
            {
                setUpLabels(label);
                label.setFocusTraversable(false);
            }
            );

            try{
                
            server = new Socket("127.0.0.1", 5005);
            ps = new PrintStream(server.getOutputStream());
            dis = new DataInputStream(server.getInputStream());

            ps.println("Turn x");

        } catch (IOException ex) {
            Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
        }


            setMaxHeight(USE_PREF_SIZE);
            setMaxWidth(USE_PREF_SIZE);
            setMinHeight(USE_PREF_SIZE);
            setMinWidth(USE_PREF_SIZE);
            setPrefHeight(400.0);
            setPrefWidth(600.0);

            BorderPane.setAlignment(borderPane, javafx.geometry.Pos.CENTER);
            borderPane.setPrefHeight(93.0);
            borderPane.setPrefWidth(600.0);

            BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
            flowPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
            flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
            flowPane.setPrefHeight(200.0);
            flowPane.setPrefWidth(200.0);

            borderPane0.setPrefHeight(45.0);
            borderPane0.setPrefWidth(200.0);

            BorderPane.setAlignment(line, javafx.geometry.Pos.CENTER);
            line.setEndX(463.89715576171875);
            line.setEndY(-25.348709106445312);
            line.setStartX(369.604248046875);
            line.setStartY(-25.348724365234375);
            borderPane0.setCenter(line);

            BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
            flowPane0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
            flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
            flowPane0.setPrefHeight(61.0);
            flowPane0.setPrefWidth(200.0);

            Player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            Player1Text.setStrokeWidth(0.0);
            Player1Text.setText("Player 1");
            Player1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            Player1Text.setWrappingWidth(198.134765625);

            Score1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            Score1Text.setStrokeWidth(0.0);
            Score1Text.setText("Score");
            Score1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            Score1Text.setWrappingWidth(195.3603515625);
            borderPane0.setBottom(flowPane0);

            BorderPane.setAlignment(ONotationText, javafx.geometry.Pos.CENTER);
            ONotationText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            ONotationText.setStrokeWidth(0.0);
            ONotationText.setText("O");
            borderPane0.setTop(ONotationText);
            borderPane.setLeft(flowPane);

            BorderPane.setAlignment(flowPane1, javafx.geometry.Pos.CENTER);
            flowPane1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
            flowPane1.setOrientation(javafx.geometry.Orientation.VERTICAL);
            flowPane1.setPrefHeight(200.0);
            flowPane1.setPrefWidth(200.0);

            borderPane1.setPrefHeight(45.0);
            borderPane1.setPrefWidth(200.0);

            BorderPane.setAlignment(line0, javafx.geometry.Pos.CENTER);
            line0.setEndX(463.89715576171875);
            line0.setEndY(-25.348709106445312);
            line0.setStartX(369.604248046875);
            line0.setStartY(-25.348724365234375);
            borderPane1.setCenter(line0);

            BorderPane.setAlignment(flowPane2, javafx.geometry.Pos.CENTER);
            flowPane2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
            flowPane2.setOrientation(javafx.geometry.Orientation.VERTICAL);
            flowPane2.setPrefHeight(61.0);
            flowPane2.setPrefWidth(200.0);

            Player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            Player2Text.setStrokeWidth(0.0);
            Player2Text.setText("Player 2");
            Player2Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            Player2Text.setWrappingWidth(198.134765625);

            Score1Text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            Score1Text1.setStrokeWidth(0.0);
            Score1Text1.setText("Score");
            Score1Text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            Score1Text1.setWrappingWidth(195.3603515625);
            borderPane1.setBottom(flowPane2);

            BorderPane.setAlignment(XNotationText, javafx.geometry.Pos.CENTER);
            XNotationText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            XNotationText.setStrokeWidth(0.0);
            XNotationText.setText("X");
            borderPane1.setTop(XNotationText);
            borderPane.setRight(flowPane1);
            setBottom(borderPane);

            BorderPane.setAlignment(borderPane2, javafx.geometry.Pos.CENTER);
            borderPane2.setPrefHeight(83.0);
            borderPane2.setPrefWidth(600.0);

            BorderPane.setAlignment(flowPane3, javafx.geometry.Pos.CENTER);
            flowPane3.setPrefHeight(24.0);
            flowPane3.setPrefWidth(600.0);

            menuList.setMnemonicParsing(false);
            menuList.setPrefHeight(21.0);
            menuList.setPrefWidth(92.0);
            menuList.setText("Menu");

            homeButton.setMnemonicParsing(false);
            homeButton.setText("Home");

            resetButton.setMnemonicParsing(false);
            resetButton.setText("Reset");
            borderPane2.setTop(flowPane3);

            BorderPane.setAlignment(gameText, javafx.geometry.Pos.CENTER);
            gameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            gameText.setStrokeWidth(0.0);
            gameText.setText("Game");
            gameText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            gameText.setWrappingWidth(98.8447265625);
            gameText.setFont(new Font(18.0));
            borderPane2.setCenter(gameText);
            setTop(borderPane2);

            BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
            anchorPane.setPrefHeight(239.0);
            anchorPane.setPrefWidth(600.0);

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
            //label6.setPrefSize(73.0, 84.0);


            label1.setLayoutX(158.0);
            label1.setLayoutY(27.0);
            label1.setPrefHeight(40.0);
            label1.setPrefWidth(81.0);
            // label1.setPrefSize(73.0, 84.0);

            label2.setLayoutX(258.0);
            label2.setLayoutY(22.0);
            label2.setPrefHeight(44.0);
            label2.setPrefWidth(74.0);
            // label2.setPrefSize(73.0, 84.0);

            label3.setLayoutX(352.0);
            label3.setLayoutY(32.0);
            label3.setPrefHeight(37.0);
            label3.setPrefWidth(73.0);
            //label3.setPrefSize(73.0, 84.0);

            label4.setLayoutX(157.0);
            label4.setLayoutY(82.0);
            label4.setPrefHeight(48.0);
            label4.setPrefWidth(82.0);
            // label4.setPrefSize(73.0, 84.0);

            label5.setLayoutX(255.0);
            label5.setLayoutY(77.0);
            label5.setPrefHeight(54.0);
            label5.setPrefWidth(79.0);
            //label5.setPrefSize(73.0, 84.0);


            label7.setLayoutX(158.0);
            label7.setLayoutY(142.0);
            label7.setPrefHeight(45.0);
            label7.setPrefWidth(84.0);
            // label7.setPrefSize(73.0, 84.0);

            label8.setLayoutX(256.0);
            label8.setLayoutY(141.0);
            label8.setPrefHeight(49.0);
            label8.setPrefWidth(77.0);
            //label8.setPrefSize(73.0, 84.0);


            label9.setLayoutX(347.0);
            label9.setLayoutY(144.0);
            label9.setPrefHeight(45.0);
            label9.setPrefWidth(80.0);
            //label9.setPrefSize(73.0, 84.0);
            setCenter(anchorPane);

            flowPane0.getChildren().add(Player1Text);
            flowPane0.getChildren().add(Score1Text);
            flowPane.getChildren().add(borderPane0);
            flowPane2.getChildren().add(Player2Text);
            flowPane2.getChildren().add(Score1Text1);
            flowPane1.getChildren().add(borderPane1);
            menuList.getItems().add(homeButton);
            menuList.getItems().add(resetButton);
            flowPane3.getChildren().add(menuList);
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

//            homeButton.setOnAction((Action)->{
//                Parent root2 = new Start(stage);
//                Scene scene2 = new Scene(root2);
//                stage.setScene(scene2);
//                stage.show();
//            });

            resetButton.setOnAction((Action)->{
                Parent root2 = new GameScene(stage);
                Scene scene2 = new Scene(root2);
                stage.setScene(scene2);
                stage.show();
            });
            
    }
//    }
    // public void restartGame(ActionEvent event){
      //    labels.forEach(this::resetLabels);
      //}
    
    
    
     // public void resetLabels(Label label){
       //   label.setDisable(false);
         // label.setText("");
          
       //}
       
      private void setUpLabels(Label label){
          JSONObject obj = new JSONObject();
         label.setOnMouseClicked( mouseEvent ->{
              try {
                  
                  
                  int turn = setPlayerSymbol(label);
                  label.setDisable(true);
                  
                  
                  obj.put("turn", turn);
                  obj.put("square", label);
                  
                  ps.print(obj.toString());
                  
                  checkGameIsOver();
              } catch (JSONException ex) {
                  Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
              }
         
         });
         
      }
      
      public int setPlayerSymbol (Label label){
          JSONObject obj = new JSONObject();
          if (playerTurn %2==0){
              try {
                  label.setText("x");
                  playerTurn = 1;
                  obj.put("turn", "x");
                  obj.put("square", label);
                  
                  ps.print(obj.toString());
              } catch (JSONException ex) {
                  Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          else {
              try {
                  label.setText("0");
                  playerTurn =0;
                  obj.put("turn", "o");
                  obj.put("square", label);
                  
                  ps.print(obj.toString());
              } catch (JSONException ex) {
                  Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          return playerTurn;
      }
      
       public void checkGameIsOver(){
          
         for (int a =0 ; a<8; a++){
             
         String line="" ;
                        
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
              
             default : line="";
                 
         }
         if (line.equals("xxx")){
           Score1Text.setText("1");
         
         }
         else if( line.equals("000")){
          Score1Text.setText("0");
         } 
         
         }
        
      }

    
}