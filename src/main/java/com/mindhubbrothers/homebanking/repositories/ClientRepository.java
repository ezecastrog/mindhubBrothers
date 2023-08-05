package com.mindhubbrothers.homebanking.repositories;

import com.mindhubbrothers.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository <Client,Long>{
}
