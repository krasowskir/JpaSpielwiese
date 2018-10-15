package com.example.jpaSpielwiese.persistence.repositories;


import com.example.jpaSpielwiese.persistence.entities.Adresse;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AdressRepository extends CrudRepository<Adresse, UUID>{
}
