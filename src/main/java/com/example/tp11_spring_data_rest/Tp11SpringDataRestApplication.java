package com.example.tp11_spring_data_rest;

import com.example.tp11_spring_data_rest.Repositories.ClientRepository;
import com.example.tp11_spring_data_rest.Repositories.CompteRepository;
import com.example.tp11_spring_data_rest.entities.Client;
import com.example.tp11_spring_data_rest.entities.Compte;
import com.example.tp11_spring_data_rest.entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class Tp11SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp11SpringDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);

            Client c1 = clientRepository.save(new Client(null, "Amal", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", null));

            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
