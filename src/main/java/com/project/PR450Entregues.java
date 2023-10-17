package main.java.com.project;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes;


    public PR450Entregues(ArrayList<PR450Producte> productes) {
        this.productes = new ArrayList<>();
    }

    public ArrayList<PR450Producte> getProductes() {
        return this.productes;
    }

    public void setProductes(ArrayList<PR450Producte> productes) {
        this.productes = productes;
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        pcs.firePropertyChange("productes", null, producte);
    }

}
