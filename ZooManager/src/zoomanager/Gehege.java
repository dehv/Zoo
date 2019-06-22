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
    private String groesse;
    private ObservableList<Tier> bewohner;

    public Gehege(String name, String groesse, ObservableList<Tier> bewohner) {
        this.name = name;
        this.anzahlTiere = bewohner.size();
        this.groesse = groesse;
        this.bewohner = bewohner;
    }

    Gehege(String name, String groesse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
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
