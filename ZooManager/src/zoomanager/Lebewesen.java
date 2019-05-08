package zoomanager;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


public class Lebewesen {

private String name;
private final ObjectProperty<LocalDate> geburtstag = new SimpleObjectProperty<>();
private Geschlecht geschlecht;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final LocalDate getGeburtstag() {
        return this.geburtstag.get();
    }

    public final void setGeburtstag(LocalDate value) {
        this.geburtstag.set(value);
    }
    
    public final ObjectProperty<LocalDate> geburtstagProperty() {
    return this.geburtstag;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }
    
    


}
