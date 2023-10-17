package main.java.com.project;

import java.beans.PropertyChangeSupport;

public class PR450Producte {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private int id;
    private String nom;


    public PR450Producte(int id, String nom) {
        this.nom = nom;
        this.id = id;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
