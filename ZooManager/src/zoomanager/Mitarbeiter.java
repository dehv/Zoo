package zoomanager;

import java.time.LocalDate;

public class Mitarbeiter extends Lebewesen {
    
    private int monatsgehalt;
    private int startminute;
    private int startstunde;
    private int endminute;
    private int endstunde;
    private String vorname;
    private String telefonnummer;
    private String adresse;
    private String beruf;
    private String personalnummer;


    public Mitarbeiter(String vorname, String name, String addresse, String telefonnummer, String beruf, LocalDate geburtsdatum, Geschlecht geschlecht, String personalnummer) {
        this.vorname = vorname;
        super.setName(name);
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.beruf = beruf;
        super.setGeburtstag(geburtsdatum);
        super.setGeschlecht(geschlecht);
        this.personalnummer = personalnummer;
        
    }

    public int getMonatsgehalt() {
        return monatsgehalt;
    }

    public void setMonatsgehalt(int monatsgehalt) {
        this.monatsgehalt = monatsgehalt;
    }

    public int getStartminute() {
        return startminute;
    }

    public void setStartminute(int startminute) {
        this.startminute = startminute;
    }

    public int getStartstunde() {
        return startstunde;
    }

    public void setStartstunde(int startstunde) {
        this.startstunde = startstunde;
    }

    public int getEndminute() {
        return endminute;
    }

    public void setEndminute(int endminute) {
        this.endminute = endminute;
    }

    public int getEndstunde() {
        return endstunde;
    }

    public void setEndstunde(int endstunde) {
        this.endstunde = endstunde;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }
    
    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }
    
    public String getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(String personalnummer) {
        this.personalnummer = personalnummer;
    }
    
    @Override
    public String toString() {
        return this.getVorname() + " " + this.getName();
    }
}
