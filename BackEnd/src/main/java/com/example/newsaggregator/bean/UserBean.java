package com.example.newsaggregator.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "users112")
public class UserBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;
    private String password; // Hashed password
    private String preferences; // Comma-separated categories

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", preferences=" + preferences + "]";
    }
}
