package com.gestionticket.expertisedata.gestionticket.Controllers;

import com.gestionticket.expertisedata.gestionticket.Entities.Traitement;
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
    @PostMapping //technicien
    public void createTraitement(){
        //create traiutement from ticket details using ticket id & technicien id
    }
    @PutMapping //technicien
    public void editTraitementState(){
        //work only if traitement.isEdited is false
    }

}
