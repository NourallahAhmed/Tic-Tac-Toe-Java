/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
   
    public void goToVideo(MouseEvent event, String username) throws IOException{
        root = new FXMLVideoScreenBase(stage, username); // add video screen
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
//    public void goToVideo() throws IOException{
//        root = FXMLLoader.load(
//           getClass().getResource("FXMLVideoScreen.fxml"));
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//    }
    
    public void goToListView(ActionEvent event, String username) throws IOException{
        root = new ListViewBase(stage, username); // add video screen
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void goToLogin(ActionEvent event) throws IOException {

        root = new LoginLayoutBase(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void goToRegister(ActionEvent event) throws IOException {

        root = new RegisterLayoutBase(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
     
     
    public void goToGameMode(ActionEvent event) throws IOException {

        root = new GameModeBase(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }  
    

    
    public void goToVsComputer(ActionEvent event) throws IOException {
        root = new PlayVsComputer(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void goToPlayWithFriend(ActionEvent event) throws IOException {
        root = new PlayWithFriend(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void goToPlayOnline(ActionEvent event, String sender, String reciever, String turn, boolean flag) throws IOException {
        root = new GameOnlineBase(stage, sender, reciever, turn, flag);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void gotoip(ActionEvent event) throws IOException {
        root = new IPADDBase(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
