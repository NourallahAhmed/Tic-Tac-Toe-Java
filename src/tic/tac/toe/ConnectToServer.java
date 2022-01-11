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
import org.json.JSONException;
import org.json.JSONObject;

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
            ps= new PrintStream( LoginLayoutBase.Server.getOutputStream());
            dis= new DataInputStream (LoginLayoutBase.Server.getInputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
          

    }
    
    public  void logindata(String str) {
        ps.println(str); 
        System.out.println("sended" +str);
        
    }
    public String recieved()
    {
        String takeaction = null;
        try {
            
            String reader =dis.readLine();
            JSONObject rec= new JSONObject(reader);
            System.out.println("Server says" +reader);
            switch(rec.getString("login")){
                case "User Exist":
                    takeaction="gotolist";
                    break;
                }
        } catch (IOException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(takeaction);
        return takeaction;

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
    
}
