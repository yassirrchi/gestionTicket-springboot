package com.gestionticket.expertisedata.gestionticket.Repositories;

import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
    public Client findClientByUsername(String username);
}
