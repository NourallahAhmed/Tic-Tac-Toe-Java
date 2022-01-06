/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

/**
 *
 * @author NourAllah
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DUMMISERVER {

    ServerSocket MyServer;
    public DUMMISERVER()
    {
        try {
            MyServer=new ServerSocket(5005);
            while(true)
            {
                Socket waiter =MyServer.accept();
                new ChatHandler(waiter); 
                
            }
        } catch (IOException ex) {
            Logger.getLogger(DUMMISERVER.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    
    public static void main(String[] args) {
        new DUMMISERVER();
    }  
}

class ChatHandler extends Thread
    {
        DataInputStream dis;
        PrintStream ps;
        
        //static Vector<ChatHandler> clientVector = new Vector <ChatHandler> ();
        
        public ChatHandler(Socket waiter)
        {
            try {
                dis =new DataInputStream (waiter.getInputStream());
                ps = new PrintStream(waiter.getOutputStream());
               // ChatHandler.clientVector.add(this);
                start();
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        public void run()
        {
            while(true)
            {
                String str;
                try {
                    str = dis.readLine();
                    System.out.println(str);
                    //SendMessageToAll(str); 
                }catch(SocketException e){
                    try {
                        dis.close();
                     //   clientVector.remove(this);
                    } catch (IOException ex) {
                        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
                
                catch (IOException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        }
      
        /*void SendMessageToAll(String msg)
        {
            for (ChatHandler ch : clientVector)
            {   ch.ps.println(msg); }
                
        }*/
    
    
}
