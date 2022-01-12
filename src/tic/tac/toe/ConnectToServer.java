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
            System.out.println("Server says" +reader);
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
                case "onlineready":
                    takeaction="onlineready";
                    System.out.println("server send your online data");
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

