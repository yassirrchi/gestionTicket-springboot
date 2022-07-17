package com.gestionticket.expertisedata.gestionticket;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Entities.Utilisateur;
import com.gestionticket.expertisedata.gestionticket.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GestionTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionTicketApplication.class, args);
    }
@Bean
    CommandLineRunner start(UserRepository UserRepo) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(
                    name -> {
                        Utilisateur utilisateur = new Administrateur();
                        utilisateur.setUsername(name);

                        utilisateur.setEmail(name + "@mail.xt");
                        UserRepo.save(utilisateur);

                    }

            );
            Stream.of("Ayoub", "Yassir", "hasbulla").forEach(
                    name -> {
                        Utilisateur utilisateur = new Technicien();
                        utilisateur.setUsername(name);

                        utilisateur.setEmail(name + "@mail.xt");
                        UserRepo.save(utilisateur);

                    } );
            Stream.of("Wassim", "Yassir3", "hasbulla", "Ayoub2").forEach(
                    name -> {
                        Utilisateur utilisateur = new Client();
                        utilisateur.setUsername(name);

                        utilisateur.setEmail(name + "@mail.xt");
                        UserRepo.save(utilisateur);

                    } );


        };

    }};