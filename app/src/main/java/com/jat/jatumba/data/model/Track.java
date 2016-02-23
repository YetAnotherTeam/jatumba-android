package com.jat.jatumba.data.model;

import java.util.Date;

/**
 * Created by bulat on 23.02.16.
 */
public class Track {
    private int id;
    private String name;
    private Date modifyDate;

    public Track(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
