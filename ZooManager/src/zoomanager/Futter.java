/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

/**
 *
 * @author Philipp Uesbeck
 */
public class Futter {
    private float futtermenge;
    private String futtersorte;
    private Lagerungsart lagerungsart;
    
    public Futter (float futtermenge, String futtersorte, Lagerungsart 
                   lagerungsart) {
        this.futtermenge = futtermenge;
        this.futtersorte = futtersorte;
        this.lagerungsart = lagerungsart;
    }
    
    public float getFuttermenge(){
        return futtermenge;
    }
    
    public void setFuttermenge(float futtermenge) {
        this.futtermenge = futtermenge;
    }
    
    public String getFuttersorte() {
        return futtersorte;
    }
    
    public void setFuttersorte(String futtersorte) {
        this.futtersorte = futtersorte; 
    }
    
    public Lagerungsart getLagerungsart(){
        return lagerungsart;
    }
    
    public void setLagerungsart(Lagerungsart lagerungsart){
        this.lagerungsart = lagerungsart;
    }
    
    
}

