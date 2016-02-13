package com.amc.applets.perfectcell.model;

import java.util.ArrayList;

/**
 * Created by komlan on 12/02/16.
 */
public abstract class AbstractUser {
    private String name;
    private String description;
    private ArrayList needs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList getNeeds() {
        return needs;
    }

    public void setNeeds(ArrayList needs) {
        this.needs = needs;
    }
}
