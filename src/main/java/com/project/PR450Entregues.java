package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

class PR450Entregues {
    private ArrayList<PR450Producte> productes;
    private PropertyChangeSupport propertyChangeSupport;

    public PR450Entregues() {
        this.productes = new ArrayList<>();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        propertyChangeSupport.firePropertyChange("entreguesAdd", null, producte);
    }

    public void removeProducte(int id) {
        PR450Producte producte = null;
        for (PR450Producte p : productes) {
            if (p.getId() == id) {
                producte = p;
                break;
            }
        }

        if (producte != null) {
            productes.remove(producte);
            propertyChangeSupport.firePropertyChange("entreguesRemove", producte, null);
        } else {
            System.out.println("Producte no trobat a les entregues.");
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Productes a les entregues: " + productes.toString();
    }
}