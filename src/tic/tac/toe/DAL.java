/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
//import tic.tac.toe.User;
import java.util.ArrayList;
import java.util.List;
import org.apache.derby.jdbc.ClientDriver;


public class DAL {

//    User checker = new User();s
    static Connection con;

    public static void initDatabase() {

        try {

            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Tic Tac Toe DB", "root", "root");

        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void selectPalyer(User client) //Client.getUsername()
    {
        try {

            initDatabase();

            Statement stmt = con.createStatement();
            String queryString = new String("Select * from PALYERSDATA where USERNAME = '" + client.getUsername() + "'");
            ResultSet rs = stmt.executeQuery(queryString);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertPlayer(User client) {
        try {

            initDatabase();
            Statement stmt = con.createStatement();

            System.out.println(client.getPassword());
            System.out.println(client.getUsername());
            System.out.println(client.getScore());

            String queryString = new String("INSERT INTO PALYERSDATA (USERNAME, PASSWORD, SCORE) VALUES ('" + client.getUsername() + "','" + client.getPassword() + "', 0)");
            stmt.executeUpdate(queryString);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updatePlayer(User client) //mainly for updating the scores after each game
    {
        try {

            initDatabase();
            PreparedStatement ps = con.prepareStatement("Update into PALYERSDATA Values(?,?,?)");
            ps.setString(1, client.getUsername());
            ps.setString(2, client.getPassword());
            ps.setInt(3, client.getScore());
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
public static List<User> retrieveAll ()
    {
       List<User> clients = new ArrayList<>();
       
            try {     
                
                initDatabase();
                
                Statement stmt = con.createStatement() ; 
                String queryString = new String("Select * from PALYERSDATA");
                
                ResultSet rs = stmt.executeQuery(queryString);
                
                int counter = 0;
                
                while(rs.next()){
                    System.out.println("retrieveAll " + rs.getString(1));
                    User client = new User();
                    client.setUsername(rs.getString(1));
                    client.setScore(rs.getInt(3));
                    //clients.add(counter, client);
                    clients.add(client);
                    counter++;
                }
                
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
     
        return clients;
    }

   
    public static User checkUserExits(String username){
        
        User user = new User();
        
        try {
            
            initDatabase();
            
            Statement stmt = con.createStatement();
            String queryString = new String("Select * From PALYERSDATA Where username = ?"); 
            
            PreparedStatement pst = con.prepareStatement(queryString);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setScore(rs.getInt(3));
                
            } else {
                user = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }

}
