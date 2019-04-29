public class Mitarbeiter extends Lebewesen {
    
    private int monatsgehalt;
    private int startminute;
    private int startstunde;
    private int endminute;
    private int endstunde;
    private String vorname;
    private int telefonnummer;
    private String adresse;
    private String beruf;

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

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
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
    
}
