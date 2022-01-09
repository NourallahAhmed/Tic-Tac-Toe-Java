/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVER;

/**
 *
 * @author AL-alamia
 */
   


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.json.*;
import java.io.*;

public class TicTacToeServer {

    ServerSocket serverSocket;
    
    public TicTacToeServer(){
    
        try {
            serverSocket = new ServerSocket(5005);
            
            while(true){
            
                Socket s = serverSocket.accept();
                
                if(s.isConnected()){
                    new GameHandler(s);
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void main(String[] args) {
     
        new TicTacToeServer();
        
    }

}

class GameHandler extends Thread{
    
    DataInputStream dis;
    PrintStream ps;
    static Vector<GameHandler> clientsVector = new Vector<GameHandler>();

    public GameHandler(Socket cs){

        try {
            dis =  new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            GameHandler.clientsVector.add(this);
            start();

        } catch (IOException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run(){

        while(true){
                
            try {
                
                if(dis.readLine() != null){
                    
                    String str = dis.readLine();
                    sendMessageToAll(str);
                
                }

            } catch (IOException ex) {
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    void sendMessageToAll(String str){

        for(GameHandler ch: clientsVector){
            ch.ps.println(str);
        }
        
//        System.out.println("message recieved");
        System.out.println(str);

    }

}


