package org.vaadin.artur.firebase.db.data;

import org.vaadin.artur.firebase.HasKey;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User implements HasKey {

    private String key;
    private String fach;
    private String lehrer;
    private String start;
    private String ende;
    private String beschreibung;


    public User() {

    }

    public User(String fach, String lehrer, String start, String ende, String beschreibung) {
        super();
        this.fach = fach;
        this.lehrer = lehrer;
        this.start = start;
        this.ende = ende;
        this.beschreibung = beschreibung;
        
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getbeschreibung() {
        return beschreibung;
    }

    public void setbeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getLehrer() {
        return lehrer;
    }

    public void setLehrer(String lehrer) {
        this.lehrer = lehrer;
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnde() {
        return ende;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }
}
