package com.gestionticket.expertisedata.gestionticket.Controllers;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Services.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
