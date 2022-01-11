package tic.tac.toe;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public  class ListViewBase extends AnchorPane {
    
    DataInputStream dis;
    PrintStream ps;

    protected static ListView ListView;
    protected final Label label;
    protected static Text playername;
    protected static Text Score;
    protected final Label label0;
    protected final Label label1;
    protected final Button Enter;
    protected final Label label2;
    protected final Button button;
    protected final Button backbtn;
    protected final Stage mystage;
    protected final Pane pane;
    
    boolean retrieved = false;

    public ListViewBase(Stage stage) {

        mystage= stage;
        pane = new Pane();
        ListView = new ListView();
        label = new Label();
        playername = new Text();
        Score = new Text();
        label0 = new Label();
       // IpAddress = new TextField();
        label1 = new Label();
        Enter = new Button();
        label2 = new Label();
        button = new Button();
        backbtn = new Button();

        setId("AnchorPane");
        setPrefHeight(555.0);
        setPrefWidth(597.0);

        ListView.setLayoutX(15.0);
        ListView.setLayoutY(203.0);
        ListView.setPrefHeight(314.0);
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
  
        label2.setLayoutX(15.0);
        label2.setLayoutY(158.0);
        label2.setPrefHeight(30.0);
        label2.setPrefWidth(174.0);
        label2.setText("Select A player ");
        label2.setFont(new Font("System Bold", 20.0));

        button.setLayoutX(517.0);
        button.setLayoutY(159.0);
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
        
        GridPane.setRowIndex(pane, 3);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);
   
        getChildren().add(pane);
        getChildren().add(ListView);
        getChildren().add(label);
        getChildren().add(playername);
        getChildren().add(Score);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(button);
        getChildren().add(backbtn);
        
        
        
     /*
        
        JSONObject onlineusers= new JSONObject();
        try {
            
            
            
            onlineusers.put("operation","onlineuser");
               ps.println(onlineusers);
            getonline(dis.readLine());

            
            
        } catch (JSONException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    */
        
    };

    public static void getonline(String str) {
        
        try {
            JSONObject online = new JSONObject(str);
            JSONArray listOnline=online.getJSONArray("online");
            //System.out.println(listOnline);
            JSONObject playerdata= online.getJSONObject("player data");
            System.out.println(playerdata);

            System.out.println(playerdata.get("playerName"));

            playername.setText(playerdata.get("playerName").toString());
            Score.setText(playerdata.get("playerScore").toString());
            
            for (int i =0 ; i<listOnline.length(); i++)
            {
                System.out.println("loop"+i);
                ListView.getItems().add(listOnline.get(i).toString());
            }
            
            
            
            
            
        } catch (JSONException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    };
        
     
        /*

        /////////<<<<<<TEST>>>>>>>////////////
        try {
            FXMLDocumentController controller=new FXMLDocumentController();
            controller.goToPlayOnline(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    };*/
    

    
    protected  void sendRequest(javafx.event.ActionEvent actionEvent)
    {
        System.out.println(ListView.getSelectionModel().getSelectedItem());};
        
        
       /* User name = new User();
        Object n = ListView.getSelectionModel().getSelectedItem();

        //name.setUsername(n.toString());

        System.out.println(ListView.getSelectionModel().getSelectedItem());*/

    

    
    protected  void BackAction(javafx.event.ActionEvent actionEvent) 
            
    { 
        try {
            FXMLDocumentController controller=new FXMLDocumentController();
            controller.goToGameMode(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }
            };

}
