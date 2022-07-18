package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Traitement;
import com.gestionticket.expertisedata.gestionticket.Repositories.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TraitementServicesImpl implements TraitementServices{
    @Autowired
    private TraitementRepository traitementRepo;

    @Override
    public List<Traitement> getAllTraitements() {
        return traitementRepo.findAll();
    }

    @Override
    public void createTraitement(long ticketId, long technicienid) {
        //ticket=  find ticket by ticketid
        //technicien = find technicien by technicienid
        //traitement=new traitement()
        //traitement.sujet=ticket.sujet ...
        //traitement.technicien=technicien
        //traitement repo.save(traitemnt)
    }


    @Override
    public void changeTraitementState(String state, Long TraitemetId) {
        //traitement=find traitement by traitement id
        //ticket=find ticket by traitement.ticketid
        //traitement.state(state) ticket.state(state) [ticketservice.changeTicketState]
        //traitmntrepo.save(traitement)
        //ticketrepo.save(ticket)

    }

    @Override
    public Traitement getTraitementById(Long id) {
        return traitementRepo.findById(id).orElse(null);
    }
}
