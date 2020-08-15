package com.example.jpaSpielwiese.persistence.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "spielberechtigt")
    private boolean fsk18;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Player> spieler;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public boolean isFsk18() {
        return fsk18;
    }

    public void setFsk18(final boolean fsk18) {
        this.fsk18 = fsk18;
    }

    public Set<Player> getSpieler() {
        return spieler;
    }

    public void setSpieler(final Set<Player> spieler) {
        this.spieler = spieler;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", fsk18=" + fsk18 +
                ", spieler=" + spieler +
                '}';
    }
}
