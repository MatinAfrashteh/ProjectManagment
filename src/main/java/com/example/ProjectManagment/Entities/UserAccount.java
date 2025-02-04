package com.example.ProjectManagment.Entities;

import jakarta.persistence.*;

@Entity
@Table(name ="user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_accounts_seq")
    @SequenceGenerator(name = "user_accounts_seq", sequenceName = "user_accounts_seq", allocationSize = 1)
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "username")
    private String username;
    private String email;
    private String password;
    private boolean enabled =true;

    public UserAccount(){}

    public UserAccount(int user_id, String username, String email, String password, boolean enabled) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
