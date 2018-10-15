package com.example.jpaSpielwiese.persistence.entities;


import javax.persistence.*;
import java.util.UUID;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private int alter;

    @ManyToOne
    @JoinColumn(name = "account")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse")
    private Adresse adresse;

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(final int alter) {
        this.alter = alter;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(final Adresse adresse) {
        this.adresse = adresse;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alter=" + alter +
                ", account=" + account +
                ", adresse=" + adresse +
                '}';
    }
}
