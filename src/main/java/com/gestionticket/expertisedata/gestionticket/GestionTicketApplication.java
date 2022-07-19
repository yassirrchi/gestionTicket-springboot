package com.gestionticket.expertisedata.gestionticket;

import com.gestionticket.expertisedata.gestionticket.Entities.*;
import com.gestionticket.expertisedata.gestionticket.Repositories.*;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GestionTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionTicketApplication.class, args);
    }
@Bean
    CommandLineRunner start(UserRepository UserRepo, ClientRepo clientRepo, AdminRepo adminRepo,TraitementRepository traitementRepository, TechnicienRepo technicienRepo, TicketRepository ticketRepository) {
        return args -> {





            Stream.of("Hassan", "Aicha").forEach(
                    name -> {
                        Administrateur utilisateur = new Administrateur();
                        utilisateur.setUsername(name);

                        utilisateur.setEmail(name + "@mail.xt");
                        adminRepo.save(utilisateur);

                    }

            );
            Stream.of("Ayoub", "Yassir", "hasbulla").forEach(
                    name -> {
                        Technicien  utilisateur = new Technicien();
                        utilisateur.setUsername(name);

                        utilisateur.setEmail(name + "@mail.xt");
                        technicienRepo.save(utilisateur);

                    } );
            Stream.of("Wassim", "Yassir3", "hasbulla", "Ayoub2").forEach(
                    name -> {
                        Client utilisateur = new Client();
                        utilisateur.setUsername(name);

                        utilisateur.setEmail(name + "@mail.xt");
                        clientRepo.save(utilisateur);

                    } );
            technicienRepo.findAll().forEach(technicien -> {
                for(int i=0;i<5;i++){
                    Traitement traitement=new Traitement();
                    traitement.setCreatedAt(new Date());
                    traitement.setClientDetails("blabla");
                    traitement.setStatus(Math.random() > 0.5 ?"en cours":"cloture");
                    traitement.setTechnicien(technicien);
                    traitement.setEdited(false);
                    traitement.setTicketId(3L);
                    traitementRepository.save(traitement);



                }



            });
            System.out.println("heeeeeeey");
            clientRepo.findAll().forEach(client -> {
               System.out.println(client.getUsername());
                for (int i = 0; i < 5; i++) {
                    Ticket ticket=new Ticket();
                    ticket.setDescription("bla bla");
                    ticket.setSujet("sujet"+i);
                    ticket.setCreatedAt(new Date());
                    ticket.setClient(client);
                    ticketRepository.save(ticket);




                }
            });


        };

    }};