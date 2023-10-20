package com.project;

public class Main {
    public static void main(String[] args) {
        PR450Producte producte1 = new PR450Producte(1, "llibre");
        PR450Producte producte2 = new PR450Producte(2, "quadern");
        PR450Producte producte3 = new PR450Producte(3, "bolígraf");
        PR450Producte producte4 = new PR450Producte(4, "goma");
        PR450Producte producte5 = new PR450Producte(5, "retolador");

        PR450Magatzem magatzem = new PR450Magatzem();
        magatzem.addPropertyChangeListener(evt -> {
            if ("magatzemAdd".equals(evt.getPropertyName())) {
                PR450Producte producte = (PR450Producte) evt.getNewValue();
                System.out.println("S'ha afegit el producte amb id " + producte.getId() + " al magatzem, capacitat: "
                        + magatzem.getCapacitat());
            } else if ("magatzemRemove".equals(evt.getPropertyName())) {
                PR450Producte producte = (PR450Producte) evt.getOldValue();
                System.out.println("S'ha esborrat el producte amb id " + producte.getId() + " del magatzem, capacitat: "
                        + magatzem.getCapacitat());
            } else if ("magatzemEntrega".equals(evt.getPropertyName())) {
                PR450Producte producte = (PR450Producte) evt.getOldValue();
                System.out.println(
                        "S'ha mogut el producte amb id " + producte.getId() + " del magatzem cap a les entregues");
            }
        });

        PR450Entregues entregues = new PR450Entregues();
        entregues.addPropertyChangeListener(evt -> {
            if ("entreguesAdd".equals(evt.getPropertyName())) {
                PR450Producte producte = (PR450Producte) evt.getNewValue();
                System.out.println("S'ha afegit el producte amb id " + producte.getId() + " a la llista d'entregues");
            } else if ("entreguesRemove".equals(evt.getPropertyName())) {
                PR450Producte producte = (PR450Producte) evt.getOldValue();
                System.out.println("S'ha entregat el producte amb id " + producte.getId());
            }
        });

        producte1.setId(10);
        producte2.setNom("llibreta");
        producte3.setNom("bloc de notes");

        magatzem.addProducte(producte1);
        magatzem.addProducte(producte2);
        magatzem.addProducte(producte3);
        magatzem.addProducte(producte4);
        magatzem.addProducte(producte5);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(5);

        entregues.addProducte(producte2);
        entregues.addProducte(producte3);
        entregues.addProducte(producte5);

        entregues.removeProducte(2);
        entregues.removeProducte(5);

        System.out.println(magatzem.toString());
        System.out.println(entregues.toString());
    }
}