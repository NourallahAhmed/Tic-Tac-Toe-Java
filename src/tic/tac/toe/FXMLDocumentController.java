/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLDocumentController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
   
    public void goToVideo(ActionEvent event) throws IOException{
        root = new FXMLVideoScreenBase(stage); // add video screen
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void goToListView(ActionEvent event) throws IOException{
        root = new ListViewBase(stage); // add video screen
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
    /*
    public void goToUsersList(ActionEvent event) throws IOException {
        root = new ListViewBase(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    */
    public void goToPlayWithFriend(ActionEvent event) throws IOException {
        root = new PlayWithFriend(stage);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void goToPlayOnline(ActionEvent event) throws IOException {
        //root = new connectToServer(stage);
        //stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //scene = new Scene(root);
        //stage.setScene(scene);
        //stage.show();
    }
    
}
