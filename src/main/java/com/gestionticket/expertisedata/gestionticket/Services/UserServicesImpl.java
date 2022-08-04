package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Entities.Utilisateur;
import com.gestionticket.expertisedata.gestionticket.Repositories.AdminRepo;
import com.gestionticket.expertisedata.gestionticket.Repositories.ClientRepo;
import com.gestionticket.expertisedata.gestionticket.Repositories.TechnicienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class UserServicesImpl implements  UserServices{
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private TechnicienRepo technicienRepo;
    @Autowired
    private ClientRepo clientRepo;

    @Override
    public List<Administrateur> getAdministrators() {
        return adminRepo.findAll();
    }

    @Override
    public List<Technicien> getTechniciens() {
        return technicienRepo.findAll();
    }

    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client findClientByUsername(String username) {
        return clientRepo.findClientByUsername(username);
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public Client CreateClient(Utilisateur client) {
        Client newClient=new Client();
        newClient.setEmail(client.getEmail());
        newClient.setUsername(client.getUsername());
        newClient.setRole("CLIENT");
        newClient.setCreatedAt(new Date());
        newClient.setPassword(client.getPassword());
        return clientRepo.save(newClient);
    }

    @Override
    public Technicien findTechnicienByUsername(String username) {
        return technicienRepo.findTechnicienByUsername(username);
    }

    @Override
    public Technicien createTechnicien(Utilisateur technicien) {
        Technicien newTechnicien=new Technicien();
        newTechnicien.setEmail(technicien.getEmail());
        newTechnicien.setUsername(technicien.getUsername());
        newTechnicien.setPassword(technicien.getPassword());
        newTechnicien.setRole("TECHNICIEN");
        newTechnicien.setCreatedAt(new Date());
        return technicienRepo.save(newTechnicien);
    }

    @Override
    public Administrateur CreateAdmin(Utilisateur administrateur) {
        Administrateur newAdmin=new Administrateur();
        newAdmin.setEmail(administrateur.getEmail());
        newAdmin.setUsername(administrateur.getUsername());
        newAdmin.setPassword(administrateur.getPassword());
        newAdmin.setRole("ADMIN");
        newAdmin.setCreatedAt(new Date());

        return adminRepo.save(newAdmin);
    }

    @Override
    public Administrateur findAdminByUsername(String username) {
        return adminRepo.findAdministrateurByUsername(username);
    }

    @Override
    public void deleteUser(Long id,String role) {
        System.out.println(id+" "+role);
        if(role.equals("ADMIN"))
        adminRepo.deleteById(id);
        if (role.equals("CLIENT"))
            clientRepo.deleteById(id);
        if(role.equals("TECHNICIEN"))
            technicienRepo.deleteById(id);


    }

    @Override
    public Utilisateur createUser(Utilisateur utilisateur) {
        System.out.println(utilisateur.getRole()+" "+utilisateur.getUsername()+" "+utilisateur.getPassword());
        Utilisateur newUser=new Utilisateur();
        newUser.setEmail(utilisateur.getEmail());
        newUser.setUsername(utilisateur.getUsername());
        newUser.setCreatedAt(new Date());
        newUser.setPassword(utilisateur.getPassword());
        System.out.println("  hhhhh "+(Client)newUser);

        if (utilisateur.getRole().equals("CLIENT")){
            newUser.setRole("CLIENT");
            return clientRepo.save((Client) newUser);

        }
        else if (utilisateur.getRole().equals("TECHNICIEN")){
            newUser.setRole("TECHNICIEN");
            return technicienRepo.save((Technicien) newUser);

        }
        else {
            newUser.setRole("ADMIN");
            return adminRepo.save((Administrateur) newUser);

        }

    }


}
