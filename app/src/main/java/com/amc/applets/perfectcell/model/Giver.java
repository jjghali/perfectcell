package com.amc.applets.perfectcell.model;

import java.util.ArrayList;

/**
 * Created by komlan on 12/02/16.
 */
public class Giver extends AbstractUser {
    public Giver(String name, String description, String typeUsager) {
        super(name, description, typeUsager);
    }

    private ArrayList<Donation> donations;

    public ArrayList<Donation> getDonations() {
        return donations;
    }

    public void setDonations(ArrayList<Donation> donations) {
        this.donations = donations;
    }
}
