package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Repositories.AdminRepo;
import com.gestionticket.expertisedata.gestionticket.Repositories.ClientRepo;
import com.gestionticket.expertisedata.gestionticket.Repositories.TechnicienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Client CreateClient(Client client) {
        Client newClient=new Client();
        newClient.setEmail(client.getEmail());
        newClient.setUsername(client.getUsername());
        newClient.setPassword(client.getPassword());
        return clientRepo.save(newClient);
    }

    @Override
    public Technicien findTechnicienByUsername(String username) {
        return technicienRepo.findTechnicienByUsername(username);
    }

    @Override
    public Technicien createTechnicien(Technicien technicien) {
        Technicien newTechnicien=new Technicien();
        newTechnicien.setEmail(technicien.getEmail());
        newTechnicien.setUsername(technicien.getUsername());
        newTechnicien.setPassword(technicien.getPassword());
        return technicienRepo.save(newTechnicien);
    }

    @Override
    public Administrateur findAdminByUsername(String username) {
        return adminRepo.findAdministrateurByUsername(username);
    }


}
