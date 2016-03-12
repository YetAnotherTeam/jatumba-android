package com.jat.jatumba.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andreybondar on 12.03.16.
 */
public class Instrument {
    private int id;
    @SerializedName("name")
    private String name;

    public Instrument() {
    }

    public Instrument(int id, String name) {

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
