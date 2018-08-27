/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chemlleijoseph
 */
public class userController {
    
    public void addUser(String fname, String lname,String uname,String pass){
        String url = "jdbc:sqlite:test.db";
        
        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("insert into users(firstName, lastName, username, password) values(?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, uname);
            ps.setString(4, pass);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
