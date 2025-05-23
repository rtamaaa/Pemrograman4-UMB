package com.rtamaaa.aplikasiku.models;

public class User {
    private String name;
    private String username;
    private String password;

    // Constructor untuk register
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Constructor untuk login
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter & Setter (opsional, tapi direkomendasikan)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
