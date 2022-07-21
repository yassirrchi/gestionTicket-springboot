package com.gestionticket.expertisedata.gestionticket.Repositories;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Administrateur,Long> {
    public Administrateur findAdministrateurByUsername(String username);
}
