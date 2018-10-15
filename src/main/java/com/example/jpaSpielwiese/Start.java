package com.example.jpaSpielwiese;

import com.example.jpaSpielwiese.persistence.entities.Account;
import com.example.jpaSpielwiese.persistence.entities.Adresse;
import com.example.jpaSpielwiese.persistence.entities.Player;
import com.example.jpaSpielwiese.service.AccountService;
import com.example.jpaSpielwiese.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class Start {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PlayerService playerService;

    @PostConstruct
    public void createAccounts() {
        Player richard = new Player();
        richard.setName("richard");
        richard.setAlter(26);

        Player toni = new Player();
        toni.setName("toni");
        toni.setAlter(25);

        Adresse bonnAdr = new Adresse();
        bonnAdr.setPlz("53227");
        bonnAdr.setHausNr(318);
        bonnAdr.setStadt("Bonn");
        bonnAdr.setStraße("Teststraße");

        Adresse baerenstein = new Adresse();
        baerenstein.setPlz("01127");
        baerenstein.setHausNr(13);
        baerenstein.setStadt("Bärenstein");
        baerenstein.setStraße("Am Markt");

        richard.setAdresse(bonnAdr);
        toni.setAdresse(baerenstein);

        Account zockerAccount = new Account();
        zockerAccount.setFsk18(true);
        zockerAccount.setId(UUID.randomUUID());

        Set<Player> spielers = new HashSet<>();
        spielers.add(richard);
        spielers.add(toni);
        zockerAccount.setSpieler(spielers);
        richard.setAccount(zockerAccount);
        toni.setAccount(zockerAccount);

        /*System.out.println(playerService.savePlayer(richard));
        System.out.println(playerService.savePlayer(toni));*/

        System.out.println("====== persist account =======");
        System.out.println(accountService.saveAccount(zockerAccount));

        System.out.println("====== find Player ======");
        Player foundPlayer = playerService.getPlayer(UUID.fromString("d37c96d1-3395-420f-a87c-70c6ae4bbdaa"));
        System.out.println(foundPlayer);
        System.out.println("Adresse: " + foundPlayer.getAdresse());
    }


    public void zeigeAccountsAn() {
        Account account = accountService.getAccount(UUID.fromString("486addf5-af1c-47f9-a7b1-4a22db50dae0"));
        System.out.println(account);

    }

    public void entferneAccountsSamtSpieler() {
        Account account = accountService.getAccount(UUID.fromString("486addf5-af1c-47f9-a7b1-4a22db50dae0"));
        System.out.println(account);
        Set<Player> spieler = account.getSpieler();
        Iterator<Player> iterator = spieler.iterator();
        while (iterator.hasNext()) {
            System.out.println("Spieler: " + iterator.next());
        }

        accountService.removeAccount(UUID.fromString("486addf5-af1c-47f9-a7b1-4a22db50dae0"));

        System.out.println(playerService.getPlayer(UUID.fromString("08354915-610f-4e41-bbfe-8d105354e3d3")));
        System.out.println(accountService.getAccount(UUID.fromString("486addf5-af1c-47f9-a7b1-4a22db50dae0")));
    }
}
