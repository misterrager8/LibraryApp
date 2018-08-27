/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chemlleijoseph
 */
public class admin {
    private String fName, lName, user, pass;
    private final String url = "jdbc:sqlite:test.db";

    public admin(String fName, String lName, String user, String pass) {
        this.fName = fName;
        this.lName = lName;
        this.user = user;
        this.pass = pass;
    }

    public admin() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void addAdmin() {

        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("insert into admins(firstName, lastName, username, password, dateCreated) values(?,?,?,?,?)");
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, user);
            ps.setString(4, pass);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public void findAdmin() {
        
        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("select * from admins where username = ?");
            ps.setString(1, user);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.fName = rs.getString("firstName");
                this.lName = rs.getString("lastName");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
}
