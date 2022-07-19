package com.gestionticket.expertisedata.gestionticket.Controllers;

import com.gestionticket.expertisedata.gestionticket.Entities.Traitement;
import com.gestionticket.expertisedata.gestionticket.Parser.TicketToTraitement;
import com.gestionticket.expertisedata.gestionticket.Parser.changeTraitementState;
import com.gestionticket.expertisedata.gestionticket.Services.TraitementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TraitementsController {
    @Autowired
    private TraitementServices traitementServices;
    @GetMapping("/alltraitements")//admin
    public List<Traitement> getAllTraitements(){
        return traitementServices.getAllTraitements();

    }
    @GetMapping("/traitement/{id}")//all
    public Traitement getTraitementById(@PathVariable Long id){
        return traitementServices.getTraitementById(id);
    }
    @PostMapping("/traitement/create") //technicien
    public void createTraitement(@RequestBody TicketToTraitement ticketToTraitement){
       // System.out.println(ticketToTraitement.getTicketId()+" "+ ticketToTraitement.getTechnicienId());
        traitementServices.createTraitement(ticketToTraitement.getTicketId(), ticketToTraitement.getTechnicienId());
    }
    @PutMapping("/traitement/edit") //technicien
    public void editTraitementState(@RequestBody changeTraitementState changeTraitementState){
         //System.out.println(changeTraitementState.getTicketId()+" "+ changeTraitementState.getTraitementId()+" "+changeTraitementState.getState());

        traitementServices.changeTraitementState(changeTraitementState.getState(),changeTraitementState.getTraitementId());
    }

}
