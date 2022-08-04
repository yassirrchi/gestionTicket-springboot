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


@GetMapping("test/{username}")
    public Technicien getTechno(@PathVariable String username){
        return  userServices.findTechnicienByUsername(username);
}
@DeleteMapping("user/delete/{id}/{role}")
    public  void deleteUser(@PathVariable Long id,@PathVariable String role){
        userServices.deleteUser(id,role);



}
    @PostMapping("user/login")
    public ResponseEntity<?> userLogin(@RequestBody Utilisateur user){

        if (user.getRole().equals("CLIENT")){
            Client client=userServices.findClientByUsername(user.getUsername());
            if(client==null)
                return (ResponseEntity<?>) ResponseEntity.notFound();
            if(client.getPassword().equals(user.getPassword()))
                return ResponseEntity.ok(client);

        }
        if(user.getRole().equals("TECHNICIEN")){
            Technicien technicien=userServices.findTechnicienByUsername(user.getUsername());
            if(technicien==null)
                return (ResponseEntity<?>) ResponseEntity.notFound();
            if(technicien.getPassword().equals(user.getPassword()))
                return ResponseEntity.ok(technicien);

        }
        if(user.getRole().equals("ADMIN")){
            Administrateur Admin=userServices.findAdminByUsername(user.getUsername());
            if(Admin==null)
                return (ResponseEntity<?>) ResponseEntity.notFound();
            if(Admin.getPassword().equals(user.getPassword()))
                return ResponseEntity.ok(Admin);
         }



        return (ResponseEntity<?>) ResponseEntity.status(401);
    }

    @PostMapping("user/create")
    public ResponseEntity<?> createUser(@RequestBody Utilisateur user){
        System.out.println(890);

        if (user.getRole().equals("CLIENT"))
            return ResponseEntity.ok(userServices.CreateClient(user));
        else if (user.getRole().equals("TECHNICIEN"))
            return  ResponseEntity.ok(userServices.createTechnicien(user));
        else
            return  ResponseEntity.ok(userServices.CreateAdmin(user));





    }






}
