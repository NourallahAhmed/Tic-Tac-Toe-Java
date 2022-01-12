package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ListViewBase extends AnchorPane {

    protected static ListView ListView;
    protected final Label label;
    protected final Text playername;
    protected final Text Score;
    protected final Label label0;
    protected final Label label1;
    protected final Button button;
    protected final Button backbtn;
    protected final Button enter;
    Stage mystage;
        FXMLDocumentController controller = new FXMLDocumentController();

    public ListViewBase( Stage stage) {
        
        mystage =stage;

        ListView = new ListView();
        label = new Label();
        playername = new Text();
        Score = new Text();
        label0 = new Label();
        label1 = new Label();
        button = new Button();
        backbtn = new Button();
        enter = new Button();

        setId("AnchorPane");
        setPrefHeight(555.0);
        setPrefWidth(597.0);

        ListView.setLayoutX(15.0);
        ListView.setLayoutY(147.0);
        ListView.setPrefHeight(370.0);
        ListView.setPrefWidth(565.0);

        label.setLayoutX(15.0);
        label.setLayoutY(20.0);
        label.setPrefHeight(25.0);
        label.setPrefWidth(105.0);
        label.setText("Player Name");
        label.setFont(new Font("System Bold", 16.0));

        playername.setLayoutX(141.0);
        playername.setLayoutY(39.0);
        playername.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playername.setStrokeWidth(0.0);
        playername.setText("Text");
        playername.setWrappingWidth(54.13671875);
        playername.setFont(new Font(15.0));

        Score.setLayoutX(147.0);
        Score.setLayoutY(63.0);
        Score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Score.setStrokeWidth(0.0);
        Score.setText("0");
        Score.setFont(new Font(15.0));

        label0.setLayoutX(14.0);
        label0.setLayoutY(45.0);
        label0.setPrefHeight(25.0);
        label0.setPrefWidth(54.0);
        label0.setText("Score");
        label0.setFont(new Font("System Bold", 16.0));

        label1.setLayoutX(15.0);
        label1.setLayoutY(93.0);
        label1.setPrefHeight(30.0);
        label1.setPrefWidth(174.0);
        label1.setText("Select A player ");
        label1.setFont(new Font("System Bold", 20.0));

        button.setLayoutX(517.0);
        button.setLayoutY(97.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::sendRequest);
        button.setText("Request");
        button.setFont(new Font(13.0));

        AnchorPane.setRightAnchor(backbtn, 14.0);
        backbtn.setLayoutX(571.0);
        backbtn.setLayoutY(20.0);
        backbtn.setMnemonicParsing(false);
        backbtn.setOnAction(this::BackAction);
        backbtn.setPrefHeight(25.0);
        backbtn.setPrefWidth(65.0);
        backbtn.setText("HOME");

        enter.setLayoutX(403.0);
        enter.setLayoutY(97.0);
        enter.setMnemonicParsing(false);
        enter.setOnAction(this::getonline);
        enter.setPrefHeight(29.0);
        enter.setPrefWidth(105.0);
        enter.setText("VIEW ONLINE");

        getChildren().add(ListView);
        getChildren().add(label);
        getChildren().add(playername);
        getChildren().add(Score);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(button);
        getChildren().add(backbtn);
        getChildren().add(enter);

    }

    protected  void sendRequest(javafx.event.ActionEvent actionEvent) {
        
        System.out.println(ListView.getSelectionModel().getSelectedItem());
        ConnectToServer connect = new ConnectToServer();
        connect.sendInvitaionto(ListView.getSelectionModel().getSelectedItem().toString());
        
        Thread th = new Thread() {

           public void run() {
                    String result = connect.recieved();
                    System.out.println(result);
                    if (result.equals("play")) {
                        System.out.println("the player will recieve");
                       
                            Platform.runLater(()->{
                                try {
                                    this.stop();
                                    controller.goToVideo(actionEvent);

                                } catch (IOException ex) {
                                    Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                } 
                            });
                        } }};
        th.start();

        System.out.println("sending");
    };

    protected  void BackAction(javafx.event.ActionEvent actionEvent) {
    try {
            FXMLDocumentController controller = new FXMLDocumentController();
            controller.goToGameMode(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
       
    protected  void getonline(javafx.event.ActionEvent actionEvent) {
        ConnectToServer connect = new ConnectToServer();
        //send
        connect.loadonline();

        System.out.println("the list is here");

        Thread th = new Thread() {

            public void run() {
                try {
                    System.out.println("the thread is work");
                    String data = connect.recieveonline(); //data JSONObject of (operation and JSONObject ((playerdata , online)))
                    JSONObject onlinedata = new JSONObject(data);
                    
                    JSONArray onlinelist= onlinedata.getJSONArray("online");
                   
                    for (int i=0 ; i < onlinelist.length() ;i++ )
                    {
                      
                        ListView.getItems().add(onlinelist.get(i));

                    }

                        this.stop();
                        System.out.println("online deleveried");
                }
                 catch (JSONException ex) {
                    Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        th.start();
    
    };
}
