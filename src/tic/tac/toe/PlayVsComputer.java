/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class PlayVsComputer extends AnchorPane {

    Stage stage;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Line line3;
    protected final Line line4;
    protected final Line line5;
    protected final Line line6;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;

    Random rand = new Random();
    char lastWin = 'X';

    public PlayVsComputer(Stage mystage) {
        stage = mystage;
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        line3 = new Line();
        line4 = new Line();
        line5 = new Line();
        line6 = new Line();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();

        setId("AnchorPane");
        setPrefHeight(624.0);
        setPrefWidth(652.0);

        line.setEndX(256.0);
        line.setEndY(1.5);
        line.setLayoutX(384.0);
        line.setLayoutY(507.0);
        line.setStartX(-248.5);
        line.setStartY(1.5);

        line0.setEndX(324.0);
        line0.setEndY(-3.5);
        line0.setLayoutX(316.0);
        line0.setLayoutY(94.0);
        line0.setStartX(-180.0);
        line0.setStartY(-4.4999847412109375);

        line1.setEndX(-2.0);
        line1.setEndY(298.0);
        line1.setLayoutX(302.0);
        line1.setLayoutY(210.0);
        line1.setStartX(-2.0);
        line1.setStartY(-119.99998474121094);

        line2.setEndX(8.0);
        line2.setEndY(229.0);
        line2.setLayoutX(462.0);
        line2.setLayoutY(276.0);
        line2.setStartX(8.0);
        line2.setStartY(-185.99998474121094);

        line3.setEndX(269.29290771484375);
        line3.setEndY(-80.0);
        line3.setLayoutX(369.0);
        line3.setLayoutY(291.0);
        line3.setStartX(-232.0);
        line3.setStartY(-80.0);

        line4.setEndX(256.29290771484375);
        line4.setEndY(-15.0);
        line4.setLayoutX(382.0);
        line4.setLayoutY(384.0);
        line4.setStartX(-245.5);
        line4.setStartY(-15.0);

        line5.setEndX(-18.0);
        line5.setEndY(272.0);
        line5.setLayoutX(154.0);
        line5.setLayoutY(236.0);
        line5.setStartX(-18.0);
        line5.setStartY(-145.99998474121094);

        line6.setEndX(-4.5);
        line6.setEndY(269.0);
        line6.setLayoutX(645.0);
        line6.setLayoutY(239.0);
        line6.setStartX(-6.0);
        line6.setStartY(-147.0);

        label.setId("label1");
        label.setLayoutX(129.0);
        label.setLayoutY(98.0);
        label.setPrefHeight(113.0);
        label.setPrefWidth(141.0);

        label0.setId("label6");
        label0.setLayoutX(455.0);
        label0.setLayoutY(213.0);
        label0.setPrefHeight(152.0);
        label0.setPrefWidth(157.0);

        label1.setId("label5");
        label1.setLayoutX(288.0);
        label1.setLayoutY(212.0);
        label1.setPrefHeight(144.0);
        label1.setPrefWidth(157.0);

        label2.setId("label4");
        label2.setLayoutX(137.0);
        label2.setLayoutY(213.0);
        label2.setPrefHeight(144.0);
        label2.setPrefWidth(157.0);

        label3.setId("label9");
        label3.setLayoutX(460.0);
        label3.setLayoutY(369.0);
        label3.setPrefHeight(136.0);
        label3.setPrefWidth(157.0);

        label4.setId("label8");
        label4.setLayoutX(291.0);
        label4.setLayoutY(364.0);
        label4.setPrefHeight(144.0);
        label4.setPrefWidth(157.0);

        label5.setId("label7");
        label5.setLayoutX(142.0);
        label5.setLayoutY(372.0);
        label5.setPrefHeight(136.0);
        label5.setPrefWidth(128.0);

        label6.setId("label3");
        label6.setLayoutX(465.0);
        label6.setLayoutY(91.0);
        label6.setPrefHeight(120.0);
        label6.setPrefWidth(150.0);

        label7.setId("label2");
        label7.setLayoutX(273.0);
        label7.setLayoutY(91.0);
        label7.setPrefHeight(120.0);
        label7.setPrefWidth(175.0);

        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(line3);
        getChildren().add(line4);
        getChildren().add(line5);
        getChildren().add(line6);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(label6);
        getChildren().add(label7);

        VBox root = new VBox();
        root.setId("root");
        HBox top = new HBox();
        top.setId("top");
        Button newGame = new Button("Reset");
        newGame.setId("PlayAgain");
        Button Home = new Button("Home");

        Home.setId("quit");

        // Image img = new Image(new File("file:1200px-Square_1.svg.png").toURI().toString());
        // ImageView view = new ImageView(img);
        GridPane grid = new GridPane();

        grid.setId("grid");

        //  Label btn[][] = new Label[3][3];
        Label btn[][] = {{label, label0, label1}, {label2, label3, label4}, {label5, label6, label7}};
        //btn[0][0].setPrefWidth(200);
        // btn[0][0].setPrefHeight(130);
        Label winner = new Label();
        Label result = new Label();
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                int x = i, y = j;

                //     btn[i][j].setImage(new Image("file:./icons/non.png"));
                // btn[i][j].setBorder(Color.black);
                //btn[i][j] = new Label("");
                //btn[i][j].setId("label");
                grid.add(btn[i][j], j, i);
//                btn[i][j].setGraphic(view);
                btn[i][j].setStyle("-fx-font-size:25px;-fx-font-weight: bold");
                //btn[i][j].setPrefWidth(200);
                //btn[i][j].setPrefHeight(130);
                //  btn[i][j].setPadding(new Insets(-2,50,10,0));
                btn[i][j].setOnMouseClicked(e
                        -> {
                    int xCount = 0, oCount = 0;
                    String win = "";

                    if (result.getText().equals("")) {
                        if (lastWin == 'X') {
                            xCount = 0;
                            for (int a = 0; a < 3; a++) {
                                for (int b = 0; b < 3; b++) {
                                    if (btn[a][b].getText().equals("X")) {
                                        xCount++;
                                        btn[a][b].setId("label");
                                    }
                                }
                            }
                            if (btn[x][y].getText().equals("")) {
                                btn[x][y].setText("X");
                                btn[x][y].setId("X");
                                xCount++;
                                win = check(btn);
                                if (!win.equals("")) {
                                    winner.setId("winner");
                                    winner.setText("Winner");
                                    winner.setStyle("-fx-font-size:25px;-fx-font-weight: bold");
                                    result.setId(win);
                                    result.setStyle("-fx-font-size:25px;-fx-font-weight: bold");
                                    result.setText(win);
                                    switch (win) {
                                        case "X":
                                            lastWin = 'X';
                                            break;
                                        case "O":
                                            lastWin = 'O';
                                    }
                                } else if (xCount == 5) {
                                    winner.setId("winner");
                                    winner.setText("Equality");
                                    winner.setStyle("-fx-font-size:25px;-fx-font-weight: bold");
                                }
                                if (winner.getText().equals("")) {
                                    fillO(btn);
                                }
                                win = check(btn);
                                if (!win.equals("")) {
                                    winner.setId("winner");
                                    winner.setText("Winner");
                                    winner.setStyle("-fx-font-size:25px;-fx-font-weight: bold");
                                    result.setId(win);
                                    result.setText(win);
                                    result.setStyle("-fx-font-size:25px;-fx-font-weight: bold");
                                    switch (win) {
                                        case "X":
                                            lastWin = 'X';
                                            break;
                                        case "O":
                                            lastWin = 'O';
                                    }

                                }
                            }
                        } else {
                            oCount = 0;
                            for (int a = 0; a < 3; a++) {
                                for (int b = 0; b < 3; b++) {
                                    if (btn[a][b].getText().equals("O")) {
                                        oCount++;
                                        btn[a][b].setId("label");

                                    }
                                }
                            }
                            if (btn[x][y].getText().equals("")) {
                                btn[x][y].setText("X");
                                btn[x][y].setId("X");
                            }
                            win = check(btn);
                            if (!win.equals("")) {
                                winner.setId("winner");
                                winner.setText("Winner");
                                result.setId(win);
                                result.setText(win);

                                switch (win) {
                                    case "X":
                                        lastWin = 'X';
                                        break;
                                    case "O":
                                        lastWin = 'O';
                                }
                            }
                            if (winner.getText().equals("")) {
                                fillO(btn);
                                oCount++;
                            }
                            win = check(btn);
                            if (!win.equals("")) {
                                winner.setId("winner");
                                winner.setText("Winner");
                                result.setId(win);
                                result.setText(win);
                                switch (win) {
                                    case "X":
                                        lastWin = 'X';
                                        break;
                                    case "O":
                                        lastWin = 'O';
                                }
                            } else if (oCount == 5) {
                                winner.setId("winner");
                                winner.setText("Equality");
                            }
                        }
                    }
                });
            }
        }

        newGame.setOnAction(e
                -> {
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    btn[a][b].setText("");
                    btn[a][b].setId("empty");
                    btn[a][b].setId("label");
                }
            }
            if (lastWin == 'O') {
                fillO(btn);
            }
            winner.setId("");
            winner.setText("");
            result.setId("");
            result.setText("");
        });
        
        Home.setOnAction(e
                -> {
            FXMLDocumentController controller = new FXMLDocumentController();
            try {
                controller.goToGameMode(e);
            } catch (IOException ex) {
                Logger.getLogger(PlayVsComputer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });

        //  quit.setOnAction(e -> System.exit(0)    );
        newGame.setPrefWidth(100);
        HBox.setMargin(newGame, new Insets(40, 0, 10, 140));
        Home.setPrefWidth(100);
        HBox.setMargin(Home, new Insets(40, 0, 10, 300));

        VBox.setMargin(grid, new Insets(10, 130, 30, 170));
        top.getChildren().addAll(newGame, Home);
        winner.setAlignment(Pos.CENTER);
        winner.setPrefWidth(500);
        VBox.setMargin(winner, new Insets(20, 0, 0, 90));
        result.setPrefWidth(500);
        result.setPrefHeight(70);

        result.setAlignment(Pos.CENTER);
        VBox.setMargin(result, new Insets(0, 20, 30, 90));
        root.setBackground(Background.EMPTY);
        root.getChildren().addAll(top, grid, winner, result);
        getChildren().add(root);

    }

    String check(Label[][] a) {
        int i;
        for (i = 0; i < 3; i++) {
            if (a[i][0].getText().equals(a[i][1].getText()) && a[i][1].getText().equals(a[i][2].getText()) && !a[i][2].getText().equals("")) {
                return (a[i][0].getText());
            } else if (a[0][i].getText().equals(a[1][i].getText()) && a[1][i].getText().equals(a[2][i].getText()) && !a[2][i].getText().equals("")) {
                return (a[0][i].getText());
            }
        }
        if ((a[0][0].getText().equals(a[1][1].getText()) && a[1][1].getText().equals(a[2][2].getText())) || (a[0][2].getText().equals(a[1][1].getText()) && a[1][1].getText().equals(a[2][0].getText())) && !a[1][1].getText().equals("")) {
            return (a[1][1].getText());
        }
        return ("");
    }

    void fillO(Label btn[][]) {
        int a, b, xc = 0, oc = 0, oCount = 0;
        for (a = 0; a < 3; a++) {
            for (b = 0; b < 3; b++) {
                if (btn[a][b].getText().equals("O")) {
                    oCount++;
                }
            }
        }
        if ((oCount < 4 && lastWin == 'X') || (oCount < 5 && lastWin == 'O')) {
            for (a = 0; a < 3; a++) {
                xc = oc = 0;
                for (b = 0; b < 3; b++) {
                    if (btn[a][b].getText().equals("O")) {
                        oc++;
                    } else if (btn[a][b].getText().equals("X")) {
                        xc++;
                    }
                }
                if (oc == 2) {
                    break;
                }
            }
            if (oc == 2 && xc == 0) {
                for (b = 0; b < 3; b++) {
                    if (btn[a][b].getText().equals("")) {
                        btn[a][b].setText("O");
                        btn[a][b].setId("O");
                    }
                }
            } else {
                for (a = 0; a < 3; a++) {
                    xc = oc = 0;
                    for (b = 0; b < 3; b++) {
                        if (btn[b][a].getText().equals("O")) {
                            oc++;
                        } else if (btn[b][a].getText().equals("X")) {
                            xc++;
                        }
                    }
                    if (oc == 2) {
                        break;
                    }
                }
                if (oc == 2 && xc == 0) {
                    for (b = 0; b < 3; b++) {
                        if (btn[b][a].getText().equals("")) {
                            btn[b][a].setText("O");
                            btn[b][a].setId("O");
                        }
                    }
                } else {
                    xc = oc = 0;
                    for (a = 0; a < 3; a++) {
                        if (btn[a][a].getText().equals("O")) {
                            oc++;
                        } else if (btn[a][a].getText().equals("X")) {
                            xc++;
                        }
                    }
                    if (oc == 2 && xc == 0) {
                        for (a = 0; a < 3; a++) {
                            if (btn[a][a].getText().equals("")) {
                                btn[a][a].setText("O");
                                btn[a][a].setId("O");
                            }
                        }
                    } else {
                        xc = oc = 0;
                        for (a = 0; a < 3; a++) {
                            if (btn[a][2 - a].getText().equals("O")) {
                                oc++;
                            } else if (btn[a][2 - a].getText().equals("X")) {
                                xc++;
                            }
                        }
                        if (oc == 2 && xc == 0) {
                            for (a = 0; a < 3; a++) {
                                if (btn[a][2 - a].getText().equals("")) {
                                    btn[a][2 - a].setText("O");
                                    btn[a][2 - a].setId("O");
                                }
                            }
                        } else {
                            for (a = 0; a < 3; a++) {
                                xc = oc = 0;
                                for (b = 0; b < 3; b++) {
                                    if (btn[a][b].getText().equals("O")) {
                                        oc++;
                                    } else if (btn[a][b].getText().equals("X")) {
                                        xc++;
                                    }
                                }

                                if (xc == 2) {
                                    break;
                                }

                            }
                            if (xc == 2 && oc == 0) {
                                for (b = 0; b < 3; b++) {
                                    if (btn[a][b].getText().equals("")) {
                                        btn[a][b].setText("O");
                                        btn[a][b].setId("O");
                                    }
                                }
                            } else {
                                for (a = 0; a < 3; a++) {
                                    xc = oc = 0;
                                    for (b = 0; b < 3; b++) {
                                        if (btn[b][a].getText().equals("O")) {
                                            oc++;
                                        } else if (btn[b][a].getText().equals("X")) {
                                            xc++;
                                        }
                                    }
                                    if (xc == 2) {
                                        break;
                                    }
                                }
                                if (xc == 2 && oc == 0) {
                                    for (b = 0; b < 3; b++) {
                                        if (btn[b][a].getText().equals("")) {
                                            btn[b][a].setText("O");
                                            btn[b][a].setId("O");
                                        }
                                    }
                                } else {
                                    xc = oc = 0;
                                    for (a = 0; a < 3; a++) {
                                        if (btn[a][a].getText().equals("O")) {
                                            oc++;
                                        } else if (btn[a][a].getText().equals("X")) {
                                            xc++;
                                        }
                                    }
                                    if (xc == 2 && oc == 0) {
                                        for (a = 0; a < 3; a++) {
                                            if (btn[a][a].getText().equals("")) {
                                                btn[a][a].setText("O");
                                                btn[a][a].setId("O");
                                            }
                                        }
                                    } else {
                                        xc = oc = 0;
                                        for (a = 0; a < 3; a++) {
                                            if (btn[a][2 - a].getText().equals("O")) {
                                                oc++;
                                            } else if (btn[a][2 - a].getText().equals("X")) {
                                                xc++;
                                            }
                                        }
                                        if (xc == 2 && oc == 0) {
                                            for (a = 0; a < 3; a++) {
                                                if (btn[a][2 - a].getText().equals("")) {
                                                    btn[a][2 - a].setText("O");
                                                    btn[a][2 - a].setId("O");
                                                }
                                            }
                                        } else {
                                            do {
                                                a = rand.nextInt(3);
                                                b = rand.nextInt(3);
                                            } while (btn[a][b].getText().equals("X") || btn[a][b].getText().equals("O"));
                                            btn[a][b].setText("O");
                                            btn[a][b].setId("O");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

