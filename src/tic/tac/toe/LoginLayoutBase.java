package tic.tac.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import tic.tac.toe.ConnectToServer;

public class LoginLayoutBase extends AnchorPane {

    protected final Label label;
    protected final Button loginid;
    protected final Button createaccount_id;
    protected final TextField usernamelog;
    protected final PasswordField passwordlog;
    protected final Text text;
    protected final Text text0;
    protected final TextField ipLogin;
    protected final Text text1;
    protected final Pane pane;
    protected final Label usernameNotFound;
    protected final Label wrongPass;
    protected final Button backbtn;
    protected final Label IP_not_exist;
    public static Socket Server;
    DataInputStream dis;
    PrintStream ps;


    FXMLDocumentController controller = new FXMLDocumentController();

    public LoginLayoutBase(Stage stage) {
        label = new Label();
        loginid = new Button();
        createaccount_id = new Button();
        usernamelog = new TextField();
        passwordlog = new PasswordField();
        text = new Text();
        text0 = new Text();
        ipLogin = new TextField();
        text1 = new Text();
        pane = new Pane();
        

        usernameNotFound = new Label();
        IP_not_exist = new Label();
        wrongPass = new Label();
        backbtn = new Button();
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(253.0);
        label.setLayoutY(40.0);
        label.setText("Login");
        label.setFont(new Font("System Bold", 27.0));

        loginid.setId("login");
        loginid.setLayoutX(367.0);
        loginid.setLayoutY(321.0);
        loginid.setMnemonicParsing(false);
        loginid.setOnAction(this::loginAction);
        loginid.setPrefHeight(25.0);
        loginid.setPrefWidth(134.0);
        loginid.setText(" Login ");
        loginid.setFont(new Font("System Bold", 16.0));

        createaccount_id.setId("createnewaccount");
        createaccount_id.setLayoutX(156.0);
        createaccount_id.setLayoutY(321.0);
        createaccount_id.setMnemonicParsing(false);
        createaccount_id.setOnAction(this::registerAction);
        createaccount_id.setPrefHeight(37.0);
        createaccount_id.setPrefWidth(191.0);
        createaccount_id.setText("Create new account");
        createaccount_id.setFont(new Font("System Bold", 16.0));

        usernamelog.setId("usernamefild");
        usernamelog.setLayoutX(142.0);
        usernamelog.setLayoutY(96.0);
        usernamelog.setPrefHeight(37.0);
        usernamelog.setPrefWidth(366.0);
        usernamelog.setPromptText("Enter your name");
        usernamelog.setFont(new Font(14.0));

        passwordlog.setId("passwordfield");
        passwordlog.setLayoutX(142.0);
        passwordlog.setLayoutY(164.0);
        passwordlog.setPrefHeight(39.0);
        passwordlog.setPrefWidth(366.0);
        passwordlog.setPromptText("Enter your password");
        passwordlog.setFont(new Font(15.0));

        text.setId("usernametext");
        text.setLayoutX(55.0);
        text.setLayoutY(120.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Username");
        text.setFont(new Font(16.0));

        text0.setId("Iplogin");
        text0.setLayoutX(55.0);
        text0.setLayoutY(189.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Password");
        text0.setWrappingWidth(66.6015625);
        text0.setFont(new Font(16.0));

        ipLogin.setId("Iplogin");
        ipLogin.setLayoutX(142.0);
        ipLogin.setLayoutY(221.0);
        ipLogin.setPrefHeight(39.0);
        ipLogin.setPrefWidth(366.0);
        ipLogin.setPromptText("Enter your IP ");
        ipLogin.setFont(new Font(15.0));

        text1.setId("Iplogin");
        text1.setLayoutX(46.0);
        text1.setLayoutY(246.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("IP Address");
        text1.setWrappingWidth(84.6015625);
        text1.setFont(new Font(16.0));

        GridPane.setRowIndex(pane, 3);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        usernameNotFound.setAlignment(javafx.geometry.Pos.CENTER);
        
        usernameNotFound.setLayoutX(150.0);
        usernameNotFound.setLayoutY(270.0);
        usernameNotFound.setPrefHeight(21.0);
        usernameNotFound.setPrefWidth(233.0);
        usernameNotFound.setText("User Name not found!");
        usernameNotFound.setTextFill(javafx.scene.paint.Color.RED);
        usernameNotFound.setVisible(false);
        usernameNotFound.setFont(new Font(18.0));

        wrongPass.setAlignment(javafx.geometry.Pos.CENTER);
        wrongPass.setLayoutX(150.0);
        wrongPass.setLayoutY(270.0);
        wrongPass.setPrefHeight(27.0);
        wrongPass.setPrefWidth(162.0);
        wrongPass.setText("Wrong Password");
        wrongPass.setTextFill(javafx.scene.paint.Color.RED);
        wrongPass.setVisible(false);
        wrongPass.setFont(new Font(18.0));
        
        IP_not_exist.setAlignment(javafx.geometry.Pos.CENTER);
        IP_not_exist.setLayoutX(216.0);
        IP_not_exist.setLayoutY(22.0);
        IP_not_exist.setPrefHeight(27.0);
        IP_not_exist.setPrefWidth(162.0);
        IP_not_exist.setText("Wrong Password");
        IP_not_exist.setTextFill(javafx.scene.paint.Color.RED);
        IP_not_exist.setVisible(false);
        IP_not_exist.setFont(new Font(18.0));
     

        getChildren().add(label);
        getChildren().add(loginid);
        getChildren().add(createaccount_id);
        getChildren().add(usernamelog);
        getChildren().add(passwordlog);
        getChildren().add(text);
        getChildren().add(text0);
        //getChildren().add(ipLogin);
        //getChildren().add(text1);
        getChildren().add(usernameNotFound);
        getChildren().add(wrongPass);
    }   

   
    

    protected void loginAction(javafx.event.ActionEvent actionEvent)  {  
        try {
            
            JSONObject obj = new JSONObject();
            obj.put("operation", "login");
            obj.put("username", usernamelog.getText());
            obj.put("password", passwordlog.getText());  
            //obj.put("ip", ipLogin.getText());  
            ConnectToServer connect= new ConnectToServer(); 
            connect.logindata(obj.toString());
            
            //System.out.println("login"+connect.recieved());
            
            Thread th = new Thread (){
                public void run() {
                    String result = connect.recieved();
                    System.out.println(result);
                    if (result.equals("gotolist")) {
                        System.out.println("iam exist");
                       
                            Platform.runLater(()->{
                                try {
                                    this.stop();
                                    controller.goToListView(actionEvent, usernamelog.getText());

                                } catch (IOException ex) {
                                    Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
                                } 
                            });
                        } 
                     else {
                        System.out.println("user doesn't exists");
                        wrongPass.setVisible(false);
                        usernameNotFound.setVisible(true);
                    }
                }
            };
           th.start();
                     
        } catch (JSONException ex) {
            Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);} 
      
    }
        
   
        
    /*
    
        else {
        System.out.println("user doesn't exists");
        wrongPass.setVisible(false);
        usernameNotFound.setVisible(true);
        }*/
        /*else {
        System.out.println("Wrong password");
        usernameNotFound.setVisible(false);
        wrongPass.setVisible(true);
        }
         */
       // catch (JSONException ex) {Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);}

    

protected  void registerAction(javafx.event.ActionEvent actionEvent){
        try {controller.goToRegister(actionEvent);} 
        catch (IOException ex) {Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);}};
    
protected  void BackAction(javafx.event.ActionEvent actionEvent){ 
        try {FXMLDocumentController controller=new FXMLDocumentController();
            controller.goToGameMode(actionEvent);} 
        catch (IOException ex) {Logger.getLogger(ListViewBase.class.getName()).log(Level.SEVERE, null, ex);}
            };
   


/*
  protected void loginAction(javafx.event.ActionEvent actionEvent)  {  
        try {
  
            
            
            Server= new Socket(ipLogin.getText(),5005); //ip]
   
            ps= new PrintStream( Server.getOutputStream());

            dis= new DataInputStream (Server.getInputStream());


            JSONObject obj = new JSONObject();
            obj.put("operation", "login");
            obj.put("username", usernamelog.getText());
            obj.put("password", passwordlog.getText());  
            
            ps.println(obj);
            
            if (dis.readLine().matches("User Exist")) {
                System.out.print("User Exist");

                ListViewBase.getonline(dis.readLine());
                controller.goToListView(actionEvent);


            } else {
                System.out.println("user doesn't exists");
                wrongPass.setVisible(false);
                usernameNotFound.setVisible(true);
            }
                
                ps.flush();
                ps.close();
            //System.out.println(connect.Server);
            //String connection = new String();
            //connect.connectwithserver(ipLogin.getText());
            
            
            //JSONObject obj = new JSONObject();
            //obj.put("operation", "login");
            //obj.put("username", usernamelog.getText());
            //obj.put("password", passwordlog.getText());  
            //connect.logindata(obj);
            
            //controller.goToListView(actionEvent);
        } catch (JSONException ex) {
            Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginLayoutBase.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

*/


  
            //System.out.println(obj.get("operation"));
           // connect.logindata(obj.toString());
            
            /*
            if (dis.readLine().matches("User Exist")) {
                System.out.print("User Exist");

                ListViewBase.getonline(dis.readLine());
                controller.goToListView(actionEvent);


            } else {
                System.out.println("user doesn't exists");
                wrongPass.setVisible(false);
                usernameNotFound.setVisible(true);
            }
                
                ps.flush();
                ps.close();
                */
            //System.out.println(connect.Server);
            //String connection = new String();
            //connect.connectwithserver(ipLogin.getText());
            
            
            //JSONObject obj = new JSONObject();
            //obj.put("operation", "login");
            //obj.put("username", usernamelog.getText());
            //obj.put("password", passwordlog.getText());  
            //connect.logindata(obj);
            
            //controller.goToListView(actionEvent);
}

