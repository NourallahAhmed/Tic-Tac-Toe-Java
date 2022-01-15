package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class FXMLVideoScreenBase extends AnchorPane {

    protected final MediaView mediaView;
    protected final Button btn_back;
    String username;
    FXMLDocumentController controller = new FXMLDocumentController();

    public FXMLVideoScreenBase(Stage stage, String username) {

        mediaView = new MediaView();
        btn_back = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(500.0);

        AnchorPane.setBottomAnchor(mediaView, 0.0);
        AnchorPane.setLeftAnchor(mediaView, 0.0);
        AnchorPane.setRightAnchor(mediaView, 0.0);
        AnchorPane.setTopAnchor(mediaView, 0.0);

        btn_back.setLayoutX(250.0);
        btn_back.setLayoutY(550.0);
        btn_back.setMnemonicParsing(false);
        btn_back.setOnAction(this::backToOnline);
        btn_back.setText("Back To Online");

        // getting video ready to play
        Media media = new Media(getClass().getResource("video.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        
        // fitting video with screen
        DoubleProperty widthProb = mediaView.fitWidthProperty();
        DoubleProperty heightProb = mediaView.fitHeightProperty();
        widthProb.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        heightProb.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        
        // auto play video
        mediaPlayer.setAutoPlay(true);
        
        getChildren().add(mediaView);
        getChildren().add(btn_back);
        
        this.username = username;

    }

    protected void backToOnline(javafx.event.ActionEvent actionEvent){
    
         try {
            controller.goToListView(actionEvent, username);
        
        } catch (IOException ex) {
            Logger.getLogger(GameModeBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
