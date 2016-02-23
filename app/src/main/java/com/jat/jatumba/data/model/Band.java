package com.jat.jatumba.data.model;

import java.util.List;

/**
 * Created by bulat on 23.02.16.
 */
public class Band {
    private String name;
    private List<User> members;

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
