package com.example.BenutzerverwaltungsprogrammSpringBoot.form;

public class KundeForm {
    private String vorname;
    private String name;
    public String email;
    public String stadt;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(final String stadt) {
        this.stadt = stadt;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(final String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
