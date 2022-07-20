package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Traitement;

import java.util.List;

public interface TraitementServices {
    public List<Traitement> getAllTraitements();
    public void createTraitement(long ticketId,long technicienid);
    public void changeTraitementState(String state,Long TraitemetId);
    public  Traitement getTraitementById(Long id);
    public List<Traitement> getTraitementsByTechnicien(Long technicienId);
}
