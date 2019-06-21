package zoomanager;

import java.time.LocalDate;


public class Tier extends Lebewesen {
    private String groesse;
    private String gewicht;
    private String art;
    private int futterstunde;
    private int futterminute;
    private String idnummer;

    public Tier(String name, String art, String idnummer, String groesse, String gewicht, LocalDate geburtsdatum, Geschlecht geschlecht) {
        super.setName(name);
        this.art = art;
        this.idnummer = idnummer;
        this.groesse = groesse;
        this.gewicht = gewicht;
        super.setGeburtstag(geburtsdatum);
        super.setGeschlecht(geschlecht);
        
    }
    

    public String getIdnummer() {
        return idnummer;
    }

    public void setIdnummer(String idnummer) {
        this.idnummer = idnummer;
    }

    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }

    public String getGewicht() {
        return gewicht;
    }

    public void setGewicht(String gewicht) {
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
