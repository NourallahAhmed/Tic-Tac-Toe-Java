/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import org.json.JSONException;
import org.json.JSONObject;
import tic.tac.toe.FXMLDocumentController; 


/**
 *
 * @author NourAllah
 */
public class ConnectToServer {
    
    JSONObject  client = new JSONObject();
    FXMLDocumentController controller = new FXMLDocumentController();

    
    DataInputStream dis;
    PrintStream ps;
    String toserver;
    ConnectToServer()
    {
        try {
            //Server= new Socket(cs,5005);
            ps= new PrintStream( IPADDBase.Server.getOutputStream());
           
            dis= new DataInputStream (IPADDBase.Server.getInputStream());
            

        } catch (IOException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
          

    }
    
    public  void logindata(String str) {
        ps.println(str); 
        System.out.println("sended" +str);
        
    }
    
    
    public void loadonline() {
        try {
            System.out.println("loadonline is work");
            JSONObject obj = new JSONObject();
            obj.put("operation", "loadonline");
            ps.println(obj);
            System.out.println("loadonline is work send your ");

        } catch (JSONException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieved()
    {
        String takeaction = null;
       
        try {
            
            String reader =dis.readLine();
            JSONObject rec= new JSONObject(reader); //all data     
            System.out.println("Server says" + reader);
            switch(rec.getString("operation")){
                case "User Exist":
                    takeaction="gotolist";
                    break;
                case "User Not Exist":
                    takeaction="User Not Exist";
                    break;
                case "regdone":
                    takeaction="gotolist";
                    break;
                case "you have invitaion":
                    takeaction="invite";
                    System.out.println("will invite");
                    break;
                    
                case "you have invitaion reply":
                    takeaction="play";
                    System.out.println("will play");
                    break;
                }
        } catch (IOException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(takeaction);
        return takeaction;
    }
    
    
    public String recieveonline()
    {
        String confirm;
        String reader = null;
        try {
            reader = dis.readLine(); // received 
            JSONObject rec= new JSONObject(reader); //convert to JSON 
            
            System.out.println("Server says" +reader); //check
            
            if (rec.getString("operation").equals("onlineready")){
                
                confirm=reader;
            }

                } catch (IOException ex) {
                    Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
                }

        return reader;
        
    }

    void sendInvitaionto(String sender ,String reciever) {
        
        try {
            JSONObject object = new JSONObject();
            object.put("operation", "invitation");
            object.put("sender", sender);
            object.put("reciever",reciever);
            
            ps.println(object);
            
            System.out.println("Invitaion sended ");
        } catch (JSONException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    void replyInvitation(String sender, String reciever, String turn) {
        
        try {
            
            JSONObject object = new JSONObject();
            object.put("operation", "reply_invitation");
            object.put("sender", sender);
            object.put("reciever", reciever);
            object.put("turn", turn);
            
            ps.println(object);
            
            System.out.println("Invitaion Replied");
            
        } catch (JSONException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    
    JSONObject createInvetaion(String player)
     {
        JSONObject send = null;
            try {
                String massege= dis.readLine();
                JSONObject invite = new JSONObject(massege);


                if (invite.getString("operation").equals( "you have invitaion"))
                { 
                    send.put("operation", "you have invitaion");
                    send.put("sender", invite.getString("sender"));
                    send.put("reciever", invite.getString("reciever"));
//                    send=invite;
                };

            } catch (IOException ex) {
                Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(send);
       return(send);
        
    }
    
}
    
/*
            //System.out.print(toserver);
            ps.println(sr);
            
           // System.out.println(toserver);
            
            
            String result;
            result=dis.readLine();
            
            JSONObject resultt = new JSONObject();
            
            String operation = resultt.get("login").toString();
            
            switch(operation){
                case "User Exist":
                    System.out.println("a5ern");
                    break;
                case "User Not Exist":
                    System.out.println("ma3lsh"); 
            }
        
            
        } catch (IOException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
   
            
        
    }*/

