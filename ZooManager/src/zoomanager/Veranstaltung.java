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
class Veranstaltung {
    
    private String name;
    private Tag tag;
    private int zeit;
    private Gehege gehege;
    private ObservableList<Mitarbeiter> mitarbeiter;
    
     public Veranstaltung(String name, int zeit, Tag tag, Gehege gehege, ObservableList<Mitarbeiter> mitarbeiter) {
        this.name = name;
        this.zeit = zeit;
        this.gehege = gehege;
        this.mitarbeiter = mitarbeiter;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZeit() {
        return zeit;
    }

    public void setZeit(int zeit) {
        this.zeit = zeit;
    }

    public Gehege getGehege() {
        return gehege;
    }

    public void setGehege(Gehege gehege) {
        this.gehege = gehege;
    }

    public ObservableList<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(ObservableList<Mitarbeiter> mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
            
    public String toString() {
        return getName()+ " um " + getZeit()+" Uhr";
    }
}
