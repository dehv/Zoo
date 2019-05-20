/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

/**
 *
 * @author David Brunschier
 */
public class TimeTable {
    private int uhrzeit;
    public Veranstaltung[] veranstaltung = new Veranstaltung[6];
    

    public TimeTable(int uhrzeit) {
        this.uhrzeit = uhrzeit;
    }
    
    public void setUhrzeit(int zeit) {
        this.uhrzeit = zeit;
    } 
    
    public Integer getUhrzeit() {
        return uhrzeit;
    }
}
