package tic.tac.toe;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class IPADDBase extends AnchorPane {

    protected final TextField IPfield;
    protected final Text text;
    protected final Button Sendip;
    public static Socket Server;
    Stage mystage;
    
    FXMLDocumentController controller = new FXMLDocumentController();

    public IPADDBase(Stage stage) {
        mystage=stage;

        IPfield = new TextField();
        text = new Text();
        Sendip = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        IPfield.setLayoutX(140.0);
        IPfield.setLayoutY(155.0);
        IPfield.setPrefHeight(37.0);
        IPfield.setPrefWidth(336.0);
        IPfield.setPromptText("IP ADDRESS");

        text.setLayoutX(104.0);
        text.setLayoutY(96.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Please enter the IP Address");
        text.setFont(new Font(34.0));

        Sendip.setLayoutX(246.0);
        Sendip.setLayoutY(226.0);
        Sendip.setMnemonicParsing(false);
        Sendip.setOnAction(this::send);
        Sendip.setPrefHeight(37.0);
        Sendip.setPrefWidth(109.0);
        Sendip.setText("Send ");

        getChildren().add(IPfield);
        getChildren().add(text);
        getChildren().add(Sendip);

    }

    protected  void send(javafx.event.ActionEvent actionEvent)
            
    {
        try {
            Server = new Socket(IPfield.getText(),5005);
            ConnectToServer connect= new ConnectToServer(); 
            controller.goToLogin(actionEvent);
            System.out.println("passed");
        } catch (IOException ex) {
            Logger.getLogger(IPADDBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    };

}
