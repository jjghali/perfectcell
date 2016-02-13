package com.amc.applets.perfectcell.model;


/**
 * Created by komlan on 12/02/16.
 */
public abstract class AbstractUser {
    private String name;
    private String description;
    private String typeUsager;
    private ArrayList needs;

    private String typeUsager;

    public AbstractUser(String name, String description, String typeUsager) {
        this.name = name;
        this.description = description;
        this.typeUsager = typeUsager;
    }

    public String getTypeUsager() {
        
        return typeUsager;
    }

    public void setTypeUsager(String typeUsager) {
        this.typeUsager = typeUsager;
    }

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

    public String getTypeUsager() {
        return typeUsager;
    }

    public void setTypeUsager(String typeUsager) {
        this.typeUsager = typeUsager;
    }


}
