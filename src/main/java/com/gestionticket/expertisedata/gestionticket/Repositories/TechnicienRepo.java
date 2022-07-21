package com.gestionticket.expertisedata.gestionticket.Repositories;

import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicienRepo extends JpaRepository<Technicien,Long> {
public Technicien findTechnicienByUsername(String username);
}
