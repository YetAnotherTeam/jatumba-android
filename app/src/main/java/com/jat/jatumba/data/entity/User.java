package com.jat.jatumba.data.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String firstName;
    private String password;
    private String lastName;
    private String profession;

    public User(int id, String firstName, String lastName, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    // Конструктор для signup
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Конструктор для login
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getProfession() {
        return profession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object userObject) {
        if (this == userObject) {
            return true;
        }
        if (userObject == null || getClass() != userObject.getClass()) {
            return false;
        }
        User user = (User) userObject;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
