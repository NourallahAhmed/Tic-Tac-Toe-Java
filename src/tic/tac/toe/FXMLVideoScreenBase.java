package tic.tac.toe;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class FXMLVideoScreenBase extends AnchorPane {

    public FXMLVideoScreenBase(Stage stage) {

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

    }
}
