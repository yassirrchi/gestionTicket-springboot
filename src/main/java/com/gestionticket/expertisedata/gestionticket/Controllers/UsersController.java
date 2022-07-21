package com.gestionticket.expertisedata.gestionticket.Controllers;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Entities.Utilisateur;
import com.gestionticket.expertisedata.gestionticket.Repositories.TechnicienRepo;
import com.gestionticket.expertisedata.gestionticket.Services.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@CrossOrigin("*")
public class UsersController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/admins")
    public List<Administrateur> getAdmins(){
        return userServices.getAdministrators();
    }
    @GetMapping("/techniciens")//admin
    public List<Technicien> getTechniciens(){
        return userServices.getTechniciens();
    }
    @GetMapping("/clients")
    public List<Client> getClients(){
        return userServices.getClients();
    }

    //client Login/Signup
    @PostMapping("client/login")
    public ResponseEntity<?> clientLogin(@RequestBody Utilisateur user){
        Client client=userServices.findClientByUsername(user.getUsername());
        if(client==null)
            return (ResponseEntity<?>) ResponseEntity.notFound();
        if(client.getPassword().equals(user.getPassword()))
            return ResponseEntity.ok(client);
        return (ResponseEntity<?>) ResponseEntity.status(401);
    }
    @PostMapping("client/signup")
    public ResponseEntity<?> clientSignup(@RequestBody Client user){

        return ResponseEntity.ok(userServices.CreateClient(user));

    }
    //Technicien Login/create                  //signin for technicien //create for admin
    @PostMapping("technicien/login")
    public ResponseEntity<?> TechnicienLogin(@RequestBody Utilisateur user){
        Technicien technicien=userServices.findTechnicienByUsername(user.getUsername());
        if(technicien==null)
            return (ResponseEntity<?>) ResponseEntity.notFound();
        if(technicien.getPassword().equals(user.getPassword()))
            return ResponseEntity.ok(technicien);
        return (ResponseEntity<?>) ResponseEntity.status(401);
    }
    @PostMapping("technicien/create")
    public ResponseEntity<?> createTechnicien(@RequestBody  Technicien technicien){


        return  ResponseEntity.ok(userServices.createTechnicien(technicien));
    }
    //admin login
    @PostMapping("/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody Administrateur administrateur){
        Administrateur Admin=userServices.findAdminByUsername(administrateur.getUsername());
        if(Admin==null)
            return (ResponseEntity<?>) ResponseEntity.notFound();
        if(Admin.getPassword().equals(administrateur.getPassword()))
            return ResponseEntity.ok(Admin);
        return (ResponseEntity<?>) ResponseEntity.status(401);


    }

@GetMapping("test/{username}")
    public Technicien getTechno(@PathVariable String username){
        return  userServices.findTechnicienByUsername(username);
}
}
