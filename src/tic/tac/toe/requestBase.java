//package tic.tac.toe;
//
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public  class requestBase extends AnchorPane {
//
//    protected final Button accept;
//    protected final Button refuse;
//    protected final Text playername;
//    protected final Label label;
//    Stage mystage;
//    public requestBase(Stage stage) {
//        mystage=stage;
//        accept = new Button();
//        refuse = new Button();
//        playername = new Text();
//        label = new Label();
//
//        setId("AnchorPane");
//        setPrefHeight(400.0);
//        setPrefWidth(600.0);
//
//        accept.setLayoutX(114.0);
//        accept.setLayoutY(292.0);
//        accept.setMnemonicParsing(false);
//        accept.setOnAction(this::AcceptRequest);
//        accept.setPrefHeight(28.0);
//        accept.setPrefWidth(117.0);
//        accept.setText("Accept");
//
//        refuse.setLayoutX(385.0);
//        refuse.setLayoutY(292.0);
//        refuse.setMnemonicParsing(false);
//        refuse.setOnAction(this::RefuseRequest);
//        refuse.setPrefHeight(28.0);
//        refuse.setPrefWidth(117.0);
//        refuse.setText("Refuse");
//
//        playername.setLayoutX(249.0);
//        playername.setLayoutY(93.0);
//        playername.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
//        playername.setStrokeWidth(0.0);
//        playername.setText("USER NAME  ");
//        playername.setWrappingWidth(128.13671875);
//        playername.setFont(new Font(19.0));
//
//        label.setLayoutX(155.0);
//        label.setLayoutY(122.0);
//        label.setPrefHeight(109.0);
//        label.setPrefWidth(368.0);
//        label.setText("Requesting a game with you ..");
//        label.setFont(new Font(22.0));
//
//        getChildren().add(accept);
//        getChildren().add(refuse);
//        getChildren().add(playername);
//        getChildren().add(label);
//
//    }
//
//    protected  void AcceptRequest(javafx.event.ActionEvent actionEvent)
//    {};
//
//    protected  void RefuseRequest(javafx.event.ActionEvent actionEvent)
//    {};
//
//}
