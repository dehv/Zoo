package zoomanager;


public class Tier extends Lebewesen {
    private int groesse;
    private int gewicht;
    private String art;
    private int futterstunde;
    private int futterminute;
    private int idnummer;
    

    public int getIdnummer() {
        return idnummer;
    }

    public void setIdnummer(int idnummer) {
        this.idnummer = idnummer;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getFutterstunde() {
        return futterstunde;
    }

    public void setFutterstunde(int futterstunde) {
        this.futterstunde = futterstunde;
    }

    public int getFutterminute() {
        return futterminute;
    }

    public void setFutterminute(int futterminute) {
        this.futterminute = futterminute;
    }
    
    
}
