package com.example.jpaSpielwiese.service;

import com.example.jpaSpielwiese.persistence.entities.Player;
import com.example.jpaSpielwiese.persistence.repositories.AdressRepository;
import com.example.jpaSpielwiese.persistence.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private AdressRepository adressRepository;

    public Player savePlayer(Player sourcePlayer){
        //adressRepository.save(sourcePlayer.getAdresse());
        return playerRepository.save(sourcePlayer);
    }

    public Player getPlayer(UUID findId){
        return playerRepository.findOne(findId);
    }
}
