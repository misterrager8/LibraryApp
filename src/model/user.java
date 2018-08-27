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
public class user {

    private String fName, lName, user, pass, dateCreated;
    private final String url = "jdbc:sqlite:test.db";

    public user(String fName, String lName, String user, String pass, String dateCreated) {
        this.fName = fName;
        this.lName = lName;
        this.user = user;
        this.pass = pass;
        this.dateCreated = dateCreated;
    }

    public user() {
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public void addUser() {

        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("insert into users(firstName, lastName, username, password, dateCreated) values(?,?,?,?,?)");
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, user);
            ps.setString(4, pass);
            ps.setString(5, dateCreated);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public void findUser() throws SQLException {
        
        Connection conn = DriverManager.getConnection(url);
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from users where username = ?");
            ps.setString(1, user);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.fName = rs.getString("firstName");
                this.lName = rs.getString("lastName");
                this.dateCreated = rs.getString("dateCreated");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            conn.close();
        }
        
    }

}
