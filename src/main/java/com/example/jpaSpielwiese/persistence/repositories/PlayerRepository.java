package com.example.jpaSpielwiese.persistence.repositories;


import com.example.jpaSpielwiese.persistence.entities.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlayerRepository extends CrudRepository<Player, UUID>{

}
