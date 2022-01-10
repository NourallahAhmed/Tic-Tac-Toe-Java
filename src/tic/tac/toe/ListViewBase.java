package tic.tac.toe;

import java.io.IOException;
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

public  class ListViewBase extends AnchorPane {

    protected final ListView ListView;
    protected final Label label;
    protected static Text playername;
    protected static Text Score;
    protected final Label label0;
    protected final TextField IpAddress;
    protected final Label label1;
    protected final Button Enter;
    protected final Label label2;
    protected final Button button;
    protected final Button backbtn;
    
    protected final Pane pane;
    
    boolean retrieved = false;

    public ListViewBase(Stage stage) {

 
        pane = new Pane();
        
        ListView = new ListView();
        label = new Label();
        playername = new Text();
        Score = new Text();
        label0 = new Label();
        IpAddress = new TextField();
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
        
       
     //  setTop(stage);

        pane.
        getChildren().add(pane);

        getChildren().add(ListView);
        getChildren().add(label);
        getChildren().add(playername);
        getChildren().add(Score);
        getChildren().add(label0);
        getChildren().add(IpAddress);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(button);
        getChildren().add(backbtn);

    }
      public static void nameList(User user){
        playername.setText(user.getUsername());
        Score.setText(String.valueOf(user.getScore()));
       
       };
      
    /*
    protected void enterIP(javafx.event.ActionEvent actionEvent)
    {
        
        String ip = new String(IpAddress.getText());
        
        ClientNetwork.setIP(IpAddress.getText());
        System.out.println("the IP "+IpAddress.getText());
        
        if(IpAddress.getText().isEmpty()){
            
            System.out.println("ENTER THE IP ADDRESS");
            //IP_not_exist.setVisible(false);
        }
            else {
            
            if(!retrieved){

                List<User> users = new ArrayList<>();

                users.addAll(DAL.retrieveAll());
                int usersNum = users.size();

                System.out.println("clients retrieved: " + users.toString());

                for(int i = 0; i < usersNum; i++){
                    ListView.getItems().add(users.get(i).getUsername());
                    System.out.println("username: " + users.get(i).getUsername());}
                
                retrieved = true; }
            
            else {
                ListView.getItems().clear();
                retrieved = false;}
        }

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
        
        
       /* User name = new User();
        Object n = ListView.getSelectionModel().getSelectedItem();

        //name.setUsername(n.toString());

        System.out.println(ListView.getSelectionModel().getSelectedItem());*/

    };

    
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
