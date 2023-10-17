package main.java.com.project;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class PR450Magatzem {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes;
    private int capacitat = 10;


    public PR450Magatzem(ArrayList<PR450Producte> productes, int capacitat) {
        this.productes = new ArrayList<>();
        this.capacitat = capacitat;
    }


    public ArrayList<PR450Producte> getProductes() {
        return this.productes;
    }


    public void setProductes(ArrayList<PR450Producte> productes) {
        this.productes = productes;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void addProducte(PR450Producte producte) {
        if (productes.size() < capacitat) {
            productes.add(producte);
            llistaObservers.firePropertyChange("productes", null, producte);
        }
    }

    public void removeProducte(int id) {
        Iterator<PR450Producte> iterator = productes.iterator();
        while (iterator.hasNext()) {
            PR450Producte producte = iterator.next();
            if (producte.getId() == id) {
                iterator.remove();
                llistaObservers.firePropertyChange("productes", producte, null);
                break;
            }
        }
    }

}
