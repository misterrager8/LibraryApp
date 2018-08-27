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
public class book {
    String title, author, genre, status;
    private final String url = "jdbc:sqlite:test.db";

    public book(String title, String author, String genre, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }
    
    public book() {
        
    } 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void addBook() {

        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("insert into books(title, author, genre, status) values(?,?,?,?)");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, genre);
            ps.setString(4, status);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public void findBook() {
        
        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("select * from books where title = ?");
            ps.setString(1, title);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.author = rs.getString("author");
                this.genre = rs.getString("genre");
                this.status = rs.getString("status");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
}
