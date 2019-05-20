/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import javafx.collections.ObservableList;

/**
 *
 * @author David Brunschier
 */
public class Gehege {
    private String name;
    private int anzahlTiere;
    private float groesse;
    private ObservableList<Tier> bewohner;

    public Gehege(String name, float groesse, ObservableList<Tier> bewohner) {
        this.name = name;
        this.anzahlTiere = bewohner.size();
        this.groesse = groesse;
        this.bewohner = bewohner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahlTiere() {
        return anzahlTiere;
    }

    public void setAnzahlTiere() {
        this.anzahlTiere = bewohner.size();
    }

    public float getGroesse() {
        return groesse;
    }

    public void setGroesse(float groesse) {
        this.groesse = groesse;
    }

    public ObservableList<Tier> getBewohner() {
        return bewohner;
    }

    public void setBewohner(ObservableList<Tier> bewohner) {
        this.bewohner = bewohner;
    }
    
    public String toString() {
        return getName();
    }
    
    
}
