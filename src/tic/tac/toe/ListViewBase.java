package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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
    protected final Button ONSERVER;
    

    Stage mystage;
    FXMLDocumentController controller = new FXMLDocumentController();
    ConnectToServer connect = new ConnectToServer();

    public ListViewBase( Stage stage, String username) {
        
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
        ONSERVER = new Button();

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
        playername.setText(username);
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
        
        
        ONSERVER.setLayoutX(260.0);
        ONSERVER.setLayoutY(97.0);
        ONSERVER.setMnemonicParsing(false);
        ONSERVER.setOnAction(this::receving);
        ONSERVER.setPrefHeight(29.0);
        ONSERVER.setPrefWidth(105.0);
        ONSERVER.setText("OPEN SERVER");
        
        
        getChildren().add(ListView);
        getChildren().add(label);
        getChildren().add(playername);
        getChildren().add(Score);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(button);
        getChildren().add(backbtn);
        getChildren().add(enter);
//        getChildren().add(ONSERVER);

        Thread th = new Thread() {
            public void run() {
                Score.setText( connect.getplayerscore(playername.getText()));
                System.out.println(connect.getplayerscore(playername.getText()));
                 Platform.runLater(() -> {
                    this.stop();
                 });
            }};
          th.start();
    }

    protected  void receving (javafx.event.ActionEvent actionEvent){
        
        Thread th = new Thread() {

               public void run() {
                       
                       
                   try {
                       
                       
                       //recieveing
                       
                       String result = connect.recieveonline();
                       JSONObject obj = new JSONObject(result);
                       System.out.println(result);
                       
                       try {
                           JSONObject reqObj = new JSONObject();
                           
                           System.out.println(obj.getString("operation"));
                           String operation = obj.getString("operation");
                           switch(operation){
                               case "you have invitaion":
                                      System.out.println("the player will recieve");
        //                           System.out.println(obj.getString("player"));
                                    System.out.println("sender: " + obj.getString("sender") + " reciever " +  obj.getString("reciever"));

                                    String sender = obj.getString("sender");
                                    String reciever = obj.getString("reciever");
                                    String turn = "";

                                    Platform.runLater(()->{

                                        this.stop();
                                    //                                   controller.gotorequest(actionEvent);
                                    Alert alert = new Alert(Alert.AlertType.NONE);
                                    alert.setTitle("You have got a game request");
                                    alert.setContentText("Do you want to accept the challenge from " + sender);
                                    ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                                    ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                                    alert.getButtonTypes().setAll(okButton, noButton);
                                    alert.showAndWait().ifPresent(type -> {

                                        if (type == okButton) {

                                            try {


                                                reqObj.put("operation", "challenge_accepted");

                                                Alert alertxo = new Alert(Alert.AlertType.NONE);
                                                alertxo.setTitle("Choose X or O");
                                                alertxo.setContentText("Choose whether to play with X or O!");
                                                ButtonType xBtn = new ButtonType("Play with X", ButtonBar.ButtonData.YES);
                                                ButtonType oBtn = new ButtonType("Play With O", ButtonBar.ButtonData.YES);
                                                alertxo.getButtonTypes().setAll(xBtn, oBtn);
                                                alertxo.showAndWait().ifPresent(typexo -> {
                                                    if (typexo == xBtn) {

                                                        try {
                                                            reqObj.put("turn", "O");
                                                            Platform.runLater(()->{
                                                            try {
                                                                this.stop();
                                                                controller.goToPlayOnline(actionEvent, sender, reciever, "X", true);

                                                            } catch (IOException ex) {
                                                                Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                                            }  
                                                        });
                                                        } catch (JSONException ex) {
                                                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                                        }

                                                    } else if (typexo == oBtn) {
                                                        try {
                                                            reqObj.put("turn", "X");
                                                            Platform.runLater(()->{
                                                            try {
                                                                this.stop();
                                                                controller.goToPlayOnline(actionEvent, sender, reciever, "O", true);

                                                            } catch (IOException ex) {
                                                                Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                                            }   
                                                        });

                                                        } catch (JSONException ex) {
                                                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                    }
                                                });

                                            } catch (JSONException ex) {
                                                Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else if (type == noButton) {

                                            try {
                                                reqObj.put("operation", "challenge_declined");
                                            } catch (JSONException ex) {
                                                Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        
                                        try {
                                            connect.replyInvitation(sender, reciever, reqObj.getString("turn"));
                                            System.out.println("turn in fun replyInvitation: " + reqObj.getString("turn"));
                                        } catch (JSONException ex) {
                                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    });

                                    });
                                   
                                   break;
                                   
                               case "you have invitaion reply":
                                   
                                   Platform.runLater(()->{
                                        try {
                                            this.stop();
                                            System.out.println();
                                            controller.goToPlayOnline(actionEvent, obj.getString("sender"),
                                                    obj.getString("reciever"), obj.getString("turn"), false);

                                        } catch (IOException ex) {
                                            Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JSONException ex) { 
                                   Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                               } 
                                    });
                                   
                                   break;
                           }

                       } catch (JSONException ex) {
                           Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   } catch (JSONException ex) {
                       Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }};
        
            th.start();

    
    };
    protected  void sendRequest(javafx.event.ActionEvent actionEvent) {
        
        System.out.println(ListView.getSelectionModel().getSelectedItem());
        
        //send
        connect.sendInvitaionto(playername.getText(), ListView.getSelectionModel().getSelectedItem().toString());
        
        

//        System.out.println("sending");
    };

    protected  void BackAction(javafx.event.ActionEvent actionEvent) {
    try {
            controller.goToGameMode(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
       
    protected  void getonline(javafx.event.ActionEvent actionEvent) {
        
        //send
        connect.loadonline();

        Thread th = new Thread() {

            public void run() {
                try {
                    
                    String data = connect.recieveonline(); //data JSONObject of (operation and JSONObject ((playerdata , online)))
                    
                    
                    JSONObject onlinedata = new JSONObject(data);
                    
                    JSONArray onlinelist= onlinedata.getJSONArray("online");    
                    
                    Platform.runLater(()->{
//                            this.stop();
                            ListView.getItems().clear();
                            for (int i=0 ; i < onlinelist.length() ;i++ )
                            {

                                try {
                                    ListView.getItems().add(onlinelist.get(i));
                                } catch (JSONException ex) {
                                    Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        try {
                            ListView.getItems().remove(onlinedata.getString("player data").toString());
                        } catch (JSONException ex) {
                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
  
                    });
//                    ListView.getItems().clear();
//                    for (int i=0 ; i < onlinelist.length() ;i++ )
//                    {
//                      
//                        ListView.getItems().add(onlinelist.get(i));
//
//                    }
                    
                    
                    
                    try {
                       
                       
                       //recieveing
                       
                       String result = connect.recieveonline();
                       JSONObject obj = new JSONObject(result);
                       System.out.println(result);
                       
                       try {
                           JSONObject reqObj = new JSONObject();
                           
                           System.out.println(obj.getString("operation"));
                           String operation = obj.getString("operation");
                           switch(operation){
                               case "you have invitaion":
                                      System.out.println("the player will recieve");
        //                           System.out.println(obj.getString("player"));
                                    System.out.println("sender: " + obj.getString("sender") + " reciever " +  obj.getString("reciever"));

                                    String sender = obj.getString("sender");
                                    String reciever = obj.getString("reciever");
                                    String turn = "";

                                    Platform.runLater(()->{

                                        this.stop();
                                    //                                   controller.gotorequest(actionEvent);
                                    Alert alert = new Alert(Alert.AlertType.NONE);
                                    alert.setTitle("You have got a game request");
                                    alert.setContentText("Do you want to accept the challenge from " + sender);
                                    ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                                    ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                                    alert.getButtonTypes().setAll(okButton, noButton);
                                    alert.showAndWait().ifPresent(type -> {

                                        if (type == okButton) {

                                            try {


                                                reqObj.put("operation", "challenge_accepted");

                                                Alert alertxo = new Alert(Alert.AlertType.NONE);
                                                alertxo.setTitle("Choose X or O");
                                                alertxo.setContentText("Choose whether to play with X or O!");
                                                ButtonType xBtn = new ButtonType("Play with X", ButtonBar.ButtonData.YES);
                                                ButtonType oBtn = new ButtonType("Play With O", ButtonBar.ButtonData.YES);
                                                alertxo.getButtonTypes().setAll(xBtn, oBtn);
                                                alertxo.showAndWait().ifPresent(typexo -> {
                                                    if (typexo == xBtn) {

                                                        try {
                                                            reqObj.put("turn", "O");
                                                            Platform.runLater(()->{
                                                            try {
                                                                this.stop();
                                                                controller.goToPlayOnline(actionEvent, sender, reciever, "X", true);

                                                            } catch (IOException ex) {
                                                                Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                                            }  
                                                        });
                                                        } catch (JSONException ex) {
                                                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                                        }

                                                    } else if (typexo == oBtn) {
                                                        try {
                                                            reqObj.put("turn", "X");
                                                            Platform.runLater(()->{
                                                            try {
                                                                this.stop();
                                                                controller.goToPlayOnline(actionEvent, sender, reciever, "O", true);

                                                            } catch (IOException ex) {
                                                                Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                                            }   
                                                        });

                                                        } catch (JSONException ex) {
                                                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                    }
                                                });

                                            } catch (JSONException ex) {
                                                Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else if (type == noButton) {

                                            try {
                                                reqObj.put("operation", "challenge_declined");
                                            } catch (JSONException ex) {
                                                Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        
                                        try {
                                            connect.replyInvitation(sender, reciever, reqObj.getString("turn"));
                                            System.out.println("turn in fun replyInvitation: " + reqObj.getString("turn"));
                                        } catch (JSONException ex) {
                                            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    });

                                    });
                                   
                                   break;
                                   
                               case "you have invitaion reply":
                                   
                                   Platform.runLater(()->{
                                        try {
                                            this.stop();
                                            System.out.println();
                                            controller.goToPlayOnline(actionEvent, obj.getString("sender"),
                                                    obj.getString("reciever"), obj.getString("turn"), false);

                                        } catch (IOException ex) {
                                            Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JSONException ex) { 
                                   Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                               } 
                                    });
                                   
                                   break;
                           }

                       } catch (JSONException ex) {
                           Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   } catch (JSONException ex) {
                       Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    
                    
                    

                        this.stop();
//                        System.out.println("online deleveried");
                }
                 catch (JSONException ex) {
                    Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        th.start();
    
    };
}
