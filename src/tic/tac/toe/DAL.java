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
import java.util.ArrayList;
import java.util.List;
import org.apache.derby.jdbc.ClientDriver;

public class DAL {

    static Connection con;
    
    public static void initDatabase(){
    
        try {
            
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/AppDatabase", "root", "root");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static User selectPalyer(User user) {
        
        User currentUser = new User();
        
            try {     
                
                initDatabase();
                
                Statement stmt = con.createStatement();
                String queryString = new String("Select * from Client where username ?");
                
                PreparedStatement pst = con.prepareStatement(queryString);
                pst.setString(1, user.getUsername());
                ResultSet rs = stmt.executeQuery(queryString);
                
                currentUser.setUsername(rs.getString(1));
                currentUser.setScore(rs.getInt(3));
                
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            return currentUser;
    }
    
    // retrieve all users
    public static List<User> retrieveAll() {
        
        List<User> users = new ArrayList<>();
       
        try {     

            initDatabase();

            Statement stmt = con.createStatement() ; 
            String queryString = new String("Select * from Client");

            ResultSet rs = stmt.executeQuery(queryString);

            while(rs.next()){

                User user = new User();
                user.setUsername(rs.getString(1));
                user.setScore(rs.getInt(3));
                users.add(user);
            }

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }
    
    public static User checkUserExits(String username){
        
        User user = new User();
        
        try {
            
            initDatabase();
            
            Statement stmt = con.createStatement() ;
            String queryString = new String("Select * From Client Where username = ?"); 
            
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
    
    //adding new user from regersiter
    public static User insertPlayer(User user) {
        
        User insertedClient = user;
        
        try {
            
            initDatabase();

            Statement stmt = con.createStatement();

            System.out.println(user.getPassword());
            System.out.println(user.getUsername());
            System.out.println(user.getScore());

            String queryString = new String("INSERT INTO Client (USERNAME, PASSWORD, SCORES) VALUES ('"+ user.getUsername()+"','"+user.getPassword()+ "', 0)");
            stmt.executeUpdate(queryString);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return insertedClient;
    }
    
    public static void increasePlayerScore (User user) {
        
        try {
            
            initDatabase();
            
            int updateScore = user.getScore();
            PreparedStatement ps = con.prepareStatement("Update into Client Values(?,?,?)");
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, updateScore++);
            
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

