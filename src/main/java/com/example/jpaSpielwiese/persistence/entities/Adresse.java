package com.example.jpaSpielwiese.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String plz;
    private String straße;
    private String stadt;
    private int hausNr;

    public String getPlz() {
        return plz;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setPlz(final String plz) {
        this.plz = plz;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(final String straße) {
        this.straße = straße;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(final String stadt) {
        this.stadt = stadt;
    }

    public int getHausNr() {
        return hausNr;
    }

    public void setHausNr(final int hausNr) {
        this.hausNr = hausNr;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", plz='" + plz + '\'' +
                ", straße='" + straße + '\'' +
                ", stadt='" + stadt + '\'' +
                ", hausNr=" + hausNr +
                '}';
    }
}
