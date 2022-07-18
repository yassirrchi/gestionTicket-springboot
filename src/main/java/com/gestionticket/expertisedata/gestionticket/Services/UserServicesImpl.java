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



}
