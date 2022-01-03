package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final Button loginBtn;
    protected final Button createAccountBtn;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final Text text;
    protected final TextField usernameLogin;
    protected final PasswordField passwordLogin;
    protected final Text text0;
    protected final Text text1;
    protected final Pane pane;
    protected final Label usernameNotFound;
    protected final Label wrongPass;
    
    User user = new User();
    FXMLDocumentController controller = new FXMLDocumentController();

    public LoginBase(Stage stage) {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        loginBtn = new Button();
        createAccountBtn = new Button();
        gridPane0 = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        text = new Text();
        usernameLogin = new TextField();
        passwordLogin = new PasswordField();
        text0 = new Text();
        text1 = new Text();
        pane = new Pane();
        usernameNotFound = new Label();
        wrongPass = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(80.0);
        gridPane.setPrefWidth(598.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(414.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(404.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(293.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(196.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(loginBtn, 1);
        loginBtn.setId("login");
        loginBtn.setMnemonicParsing(false);
        loginBtn.setOnAction(this::loginAction);
        loginBtn.setPrefHeight(30.0);
        loginBtn.setPrefWidth(76.0);
        loginBtn.setText(" Login ");
        GridPane.setMargin(loginBtn, new Insets(-150.0, 0.0, 0.0, 260.0));
        loginBtn.setFont(new Font("System Bold", 16.0));

        GridPane.setColumnIndex(createAccountBtn, 1);
        GridPane.setRowIndex(createAccountBtn, 2);
        createAccountBtn.setId("createnewaccount");
        createAccountBtn.setMnemonicParsing(false);
        createAccountBtn.setOnAction(this::registerAction);
        createAccountBtn.setText("Create new account");
        GridPane.setMargin(createAccountBtn, new Insets(-50.0, 0.0, 0.0, -180.0));
        createAccountBtn.setFont(new Font("System Bold", 16.0));
        setBottom(gridPane);

        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);
        gridPane0.setPrefHeight(256.0);
        gridPane0.setPrefWidth(600.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(581.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(566.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(295.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(34.0);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(30.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        text.setId("logintext");
        text.setStroke(javafx.scene.paint.Color.valueOf("#171717"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Login");
        text.setWrappingWidth(56.443359375);
        GridPane.setMargin(text, new Insets(30.0, 0.0, 0.0, 60.0));
        text.setFont(new Font("System Bold", 20.0));

        GridPane.setRowIndex(usernameLogin, 1);
        usernameLogin.setId("usernamefild");
        usernameLogin.setPrefHeight(34.0);
        usernameLogin.setPrefWidth(387.0);
        usernameLogin.setPromptText("Enter your name");
        GridPane.setMargin(usernameLogin, new Insets(30.0, 60.0, 10.0, 140.0));
        usernameLogin.setFont(new Font(14.0));

        GridPane.setRowIndex(passwordLogin, 1);
        passwordLogin.setId("passwordfield");
        passwordLogin.setPrefHeight(39.0);
        passwordLogin.setPrefWidth(366.0);
        passwordLogin.setPromptText("Enter your password");
        GridPane.setMargin(passwordLogin, new Insets(230.0, 60.0, 90.0, 140.0));
        passwordLogin.setFont(new Font(15.0));

        GridPane.setRowIndex(text0, 1);
        text0.setId("usernametext");
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Username");
        GridPane.setMargin(text0, new Insets(-70.0, 0.0, -70.0, 60.0));
        text0.setFont(new Font(16.0));

        GridPane.setRowIndex(text1, 2);
        text1.setId("passwordtext");
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Password");
        GridPane.setMargin(text1, new Insets(-25.0, 0.0, 0.0, 60.0));
        text1.setFont(new Font(16.0));

        GridPane.setRowIndex(pane, 3);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        usernameNotFound.setAlignment(javafx.geometry.Pos.CENTER);
        usernameNotFound.setLayoutX(189.0);
        usernameNotFound.setLayoutY(19.0);
        usernameNotFound.setPrefHeight(21.0);
        usernameNotFound.setPrefWidth(233.0);
        usernameNotFound.setText("User Name not found!");
        usernameNotFound.setTextFill(javafx.scene.paint.Color.RED);
        usernameNotFound.setVisible(false);
        usernameNotFound.setFont(new Font(18.0));

        wrongPass.setAlignment(javafx.geometry.Pos.CENTER);
        wrongPass.setLayoutX(216.0);
        wrongPass.setLayoutY(22.0);
        wrongPass.setPrefHeight(27.0);
        wrongPass.setPrefWidth(162.0);
        wrongPass.setText("Wrong Password");
        wrongPass.setTextFill(javafx.scene.paint.Color.RED);
        wrongPass.setVisible(false);
        wrongPass.setFont(new Font(18.0));
        setTop(gridPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(loginBtn);
        gridPane.getChildren().add(createAccountBtn);
        gridPane0.getColumnConstraints().add(columnConstraints1);
        gridPane0.getColumnConstraints().add(columnConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getRowConstraints().add(rowConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints6);
        gridPane0.getChildren().add(text);
        gridPane0.getChildren().add(usernameLogin);
        gridPane0.getChildren().add(passwordLogin);
        gridPane0.getChildren().add(text0);
        gridPane0.getChildren().add(text1);
        pane.getChildren().add(usernameNotFound);
        pane.getChildren().add(wrongPass);
        gridPane0.getChildren().add(pane);

    }

    protected  void loginAction(javafx.event.ActionEvent actionEvent) {
        
        try {
            
              user = DAL.checkUserExits(usernameLogin.getText());

              if(user != null){

                  if(passwordLogin.getText().equals(user.getPassword())){
                      
                      System.out.println("logging in");
                      controller.goToGameMode(actionEvent);
                      GameModeBase.name(user);
                      UsersListBase.nameList(user);
//                      DAL.selectPalyer(user);
                      
                  } else {
                      
                      System.out.println("Wrong password");
                      usernameNotFound.setVisible(false);
                      wrongPass.setVisible(true);

                  }

              } else {
                  
                  System.out.println("user doesn't exists");
                  wrongPass.setVisible(false);
                  usernameNotFound.setVisible(true);
              }

          } 

      catch (IOException ex) {
          Logger.getLogger(LoginBase.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    };

    protected  void registerAction(javafx.event.ActionEvent actionEvent)
    {
        try {
            controller.goToRegister(actionEvent);
        } catch (IOException ex) {
            Logger.getLogger(LoginBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };

}
