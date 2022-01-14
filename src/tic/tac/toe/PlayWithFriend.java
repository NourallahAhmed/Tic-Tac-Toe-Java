package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayWithFriend extends AnchorPane {

    protected Pane pane;
    protected final Label playerName;
    protected final Button backbtn;
    protected final Button reset;

    boolean turnX = true;
    // flag lma el l3ba tnthy
    boolean playable = true;
    private List<Combo> combos = new ArrayList<>();
    private Tile[][] board = new Tile[3][3];

    // el class da lkol square fe elboard w hwa el by7ot el X w O lma el user udos 3la el square 
    public class Tile extends StackPane {

        Text text = new Text();

        public Tile() {

            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            setAlignment(Pos.CENTER);
            text.setFont(Font.font(72));
            getChildren().add(border);
            getChildren().add(text);

            setOnMouseClicked(event -> {
                if (!playable) {
                    return;
                }
                if (turnX == true) {
                    drawX();
                    checkState();
                    turnX = false;
                } else {
                    if (turnX == false) {
                        drawO();
                        checkState();
                        turnX = true;
                    }
                }
            });
        }

        public double getCenterX() {
            return getTranslateX() + 100;
        }

        public double getCenterY() {
            return getTranslateY() + 100;
        }

        public String getValue() {
            return text.getText();
        }

        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }
    }
    // el class da hwa ely by4el el 3 squares swaa2 vertical , horizontal or diagonal whwa el by7dd lw el 3 squares fehom nfs el 7rf wla l2

    public class Combo {

        private Tile[] tiles;

        public Combo(Tile... tiles) {
            this.tiles = tiles;
        }

        public boolean isComplete() {
            if (tiles[0].getValue().isEmpty()) {
                return false;
            }
            return tiles[0].getValue().equals(tiles[1].getValue())
                    && tiles[0].getValue().equals(tiles[2].getValue());

        }
    }

    private void palyWinAnimation(Combo combo) {
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());
        pane.getChildren().add(line);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                 new KeyValue(line.endXProperty(), combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.tiles[2].getCenterY())));
        timeline.play();
    }

    public PlayWithFriend(Stage stage) {

        backbtn = new Button();
        playerName = new Label();
        reset = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(700.0);

        AnchorPane.setRightAnchor(backbtn, 14.0);
        backbtn.setLayoutX(571.0);
        backbtn.setLayoutY(20.0);
        backbtn.setMnemonicParsing(false);
        backbtn.setOnAction(this::BackAction);
        backbtn.setPrefHeight(25.0);
        backbtn.setPrefWidth(65.0);
        backbtn.setText("HOME");

        AnchorPane.setBottomAnchor(reset, 50.0);
        reset.setLayoutX(300.0);
        reset.setLayoutY(700.0);
        reset.setMnemonicParsing(false);
        reset.setOnAction(this::ResetAction);
        reset.setPrefHeight(50.0);
        reset.setPrefWidth(100.0);
        reset.setText("RESET");

        playerName.setLayoutX(200.0);
        playerName.setLayoutY(20.0);
        playerName.setPrefHeight(35.0);
        playerName.setPrefWidth(300.0);
        playerName.setText(" ");
        playerName.setFont(new Font("Bell MT", 30.0));
        drawboard();

        getChildren().add(backbtn);
        getChildren().add(reset);

    }

    private void checkState() {
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                playable = false;
                palyWinAnimation(combo);
                playerName.setText("The Winner is " + combo.tiles[0].getValue() + " player.");
                getChildren().add(playerName);

                break;
            }
        }
    }

    public void drawboard() {
        pane = new Pane();

        pane.setLayoutX(43.0);
        pane.setLayoutY(82.0);
        pane.setPrefHeight(400.0);
        pane.setPrefWidth(600.0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                pane.getChildren().add(tile);
                board[j][i] = tile;
            }
        }

        getChildren().add(pane);

        for (int y = 0; y < 3; y++) {
            combos.add(new Combo(board[0][y], board[1][y], board[2][y]));
        }
        // vertical

        for (int x = 0; x < 3; x++) {
            combos.add(new Combo(board[x][0], board[x][1], board[x][2]));
        }
        // diagonal
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));

    }

    protected void BackAction(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLDocumentController controller = new FXMLDocumentController();
            controller.goToGameMode(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ;
            
            

            protected void ResetAction(javafx.event.ActionEvent actionEvent) {
        getChildren().removeAll(pane, playerName);
        playable = true;
        turnX = true;
        board = new Tile[3][3];
        combos = new ArrayList<>();
        drawboard();

    }
;

}
