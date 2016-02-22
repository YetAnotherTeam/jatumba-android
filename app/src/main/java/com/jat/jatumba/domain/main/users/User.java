package com.jat.jatumba.domain.main.users;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String profession;

    public User(int id, String firstName, String lastName, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    public User(){}

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
