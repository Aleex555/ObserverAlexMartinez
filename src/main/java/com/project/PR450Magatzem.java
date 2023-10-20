package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

class PR450Magatzem {
    private ArrayList<PR450Producte> productes;
    private int capacitat;
    private PropertyChangeSupport propertyChangeSupport;

    public PR450Magatzem() {
        this.productes = new ArrayList<>();
        this.capacitat = 10;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void addProducte(PR450Producte producte) {
        if (productes.size() < capacitat) {
            productes.add(producte);
            propertyChangeSupport.firePropertyChange("magatzemAdd", null, producte);
        } else {
            System.out.println("Magatzem ple, no es pot afegir més productes.");
        }
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
            propertyChangeSupport.firePropertyChange("magatzemRemove", producte, null);
            propertyChangeSupport.firePropertyChange("magatzemEntrega", producte, null);
        } else {
            System.out.println("Producte no trobat al magatzem.");
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
        return "Productes al magatzem: " + productes.toString();
    }
}