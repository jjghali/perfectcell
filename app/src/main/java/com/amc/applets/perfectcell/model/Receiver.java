package com.amc.applets.perfectcell.model;

import java.util.ArrayList;

/**
 * Created by komlan on 12/02/16.
 */
public class Receiver extends AbstractUser {
    private ArrayList<Needs> needs;
    private String program;


    public Receiver(String name, String description) {
        super(name,description);
    }

    public ArrayList<Needs> getNeeds() {
        return needs;
    }

    public void setNeeds(ArrayList<Needs> needs) {
        this.needs = needs;
    }
}
