package com.gestionticket.expertisedata.gestionticket.Repositories;

import com.gestionticket.expertisedata.gestionticket.Entities.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraitementRepository extends JpaRepository<Traitement,Long> {

    public List<Traitement> findTraitementByTechnicienId(Long id);


}
