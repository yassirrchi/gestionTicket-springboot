package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import com.gestionticket.expertisedata.gestionticket.Entities.Traitement;
import com.gestionticket.expertisedata.gestionticket.Repositories.TechnicienRepo;
import com.gestionticket.expertisedata.gestionticket.Repositories.TicketRepository;
import com.gestionticket.expertisedata.gestionticket.Repositories.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TraitementServicesImpl implements TraitementServices{
    @Autowired
    private TraitementRepository traitementRepo;
    @Autowired
    private TicketRepository ticketRepo;
    @Autowired
    private TechnicienRepo technicienRepo;

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
        Ticket ticket=ticketRepo.findById(ticketId).orElse(null);
        if(ticket==null)
            System.out.println("ticket not found");
        Technicien technicien=technicienRepo.findById(technicienid).orElse(null);
        if(technicien==null)
            System.out.println("technicien not found");
        Traitement traitement=new Traitement();
        traitement.setEdited(false);
        traitement.setStatus("en cours asidi"+technicien.getUsername());
        traitement.setCreatedAt(new Date());
        traitement.setTechnicien(technicien);
        traitementRepo.save(traitement);


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
