/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 



///DONOT USE IT 

package tic.tac.toe;

//import serverxogame.DAL;
//import serverxogame.User;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UsersListBase extends AnchorPane {

    protected static ListView listView;
    protected final Label label;
    protected static Text playerName;
    protected static Text score;
    protected final Label label0;
    protected static Text player;
    protected final Text text;
    protected final Button requestBtn;
    protected final CheckBox serverCheck;
    
    boolean retrieved = false;

    public UsersListBase(Stage stage) {

        listView = new ListView();
        label = new Label();
        playerName = new Text();
        score = new Text();
        label0 = new Label();
        player = new Text();
        text = new Text();
        requestBtn =new Button();
        serverCheck = new CheckBox();
        
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        listView.setLayoutX(6.0);
        listView.setLayoutY(110.0);
        listView.setPrefHeight(328.0);
        listView.setPrefWidth(589.0);

        label.setLayoutX(24.0);
        label.setLayoutY(22.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(78.0);
        label.setText("Player Name");
        label.setFont(new Font("System Bold", 13.0));

        playerName.setLayoutX(115.0);
        playerName.setLayoutY(37.0);
        playerName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerName.setStrokeWidth(0.0);
        playerName.setText("name");
        playerName.setWrappingWidth(96.03125);
        playerName.setFont(new Font("System Bold", 15.0));
        FlowPane.setMargin(playerName, new Insets(30.0, 10.0, 10.0, 30.0));
        
        requestBtn.setLayoutX(24.0);
        requestBtn.setLayoutY(73.0);
        requestBtn.setMnemonicParsing(false);
        requestBtn.setText("Request");
        requestBtn.setOnAction(this::selectPlayer);
        
        serverCheck.setLayoutX(100.0);
        serverCheck.setLayoutY(73.0);
        serverCheck.setMnemonicParsing(false);
        serverCheck.setText("Server");
        serverCheck.setOnAction(this::serverOnOff);
        
        score.setLayoutX(531.0);
        score.setLayoutY(38.0);
        score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score.setStrokeWidth(0.0);
        score.setText("0");

        label0.setLayoutX(482.0);
        label0.setLayoutY(22.0);
        label0.setText("Score");
        label0.setFont(new Font("System Bold", 14.0));

        player.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player.setStrokeWidth(0.0);
        player.setText("name ");

       
        text.setLayoutX(224.0);
        text.setLayoutY(67.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Select A Player");
        text.setWrappingWidth(152.375);
        text.setFont(new Font(22.0));

        getChildren().add(listView);
        getChildren().add(label);
        getChildren().add(playerName);
        getChildren().add(score);
        getChildren().add(label0);
        getChildren().add(text);
        getChildren().add(requestBtn);
        getChildren().add(serverCheck);
 
    }
       
       
    public void selectPlayer(javafx.event.ActionEvent actionEvent){
        
     //   User name = new User();
        Object n = listView.getSelectionModel().getSelectedItem();

        //name.setUsername(n.toString());

        System.out.println(listView.getSelectionModel().getSelectedItem());

     };
    
    public void serverOnOff(javafx.event.ActionEvent actionEvent) 
    {/*
        if(!retrieved){
        List<User> users = new ArrayList<>();

        users.addAll(DAL.retrieveAll());
        int usersNum = users.size();
        
        System.out.println("clients retrieved: " + users.toString());
        
        for(int i = 0; i < usersNum; i++){
            listView.getItems().add(users.get(i).getUsername() +  "\t \t" + "SCORE =" +users.get(i).getScore());
            System.out.println("username: " + users.get(i).getUsername());
        }
        
        retrieved = true; 
        
        } else {
            listView.getItems().clear();
            retrieved = false;
        }*/
        
    };
    
}
