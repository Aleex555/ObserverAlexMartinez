package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class PR450Producte {
    private int id;
    private String nom;
    private PropertyChangeSupport propertyChangeSupport;

    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PR450Producte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        System.out.println("Producte ha canviat el id de '" + oldId + "' a '" + id + "'");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        System.out.println("Producte ha canviat el nom de '" + oldNom + "' a '" + nom + "'");
    }

    @Override
    public String toString() {
        return " id='" + getId() + "'" +
                ", nom='" + getNom();
    }

}