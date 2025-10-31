package com.example.tp11_spring_data_rest.Repositories;

import com.example.tp11_spring_data_rest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "clients", collectionResourceRel = "clients", itemResourceRel = "client")
public interface ClientRepository extends JpaRepository<Client, Long> {
}
