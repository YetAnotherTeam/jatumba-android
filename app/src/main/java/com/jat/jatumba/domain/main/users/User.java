package com.jat.jatumba.domain.main.users;

import java.io.Serializable;

public class User implements Serializable {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String profession;

    public User(int id, String firstName, String lastName, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
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

    public String getProfession() {
        return profession;
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
}