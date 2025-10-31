package com.example.tp11_spring_data_rest.Repositories;

import com.example.tp11_spring_data_rest.entities.Compte;
import com.example.tp11_spring_data_rest.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "comptes", collectionResourceRel = "comptes", itemResourceRel = "compte")
public interface CompteRepository extends JpaRepository<Compte, Long> {
    @RestResource(path = "/byType")
    public List<Compte> findByType(@Param("t") TypeCompte type);
}
