package com.example.jpaSpielwiese.persistence.repositories;

import com.example.jpaSpielwiese.persistence.entities.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface AccountRepository extends CrudRepository<Account, UUID> {

}
