package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;
import com.gestionticket.expertisedata.gestionticket.Entities.Utilisateur;

import java.util.List;

public interface UserServices {
    public List<Administrateur> getAdministrators();
    public List<Technicien> getTechniciens();
    public List<Client> getClients();
    public Client findClientByUsername(String username);
    public Client findClientById(Long id);
    public Client CreateClient(Utilisateur client);
    public Technicien findTechnicienByUsername(String username);
    public Technicien createTechnicien(Utilisateur technicien);
    public Administrateur CreateAdmin(Utilisateur administrateur);
    public Administrateur findAdminByUsername(String username);
    public void deleteUser(Long id,String role);
    public Utilisateur createUser(Utilisateur utilisateur);

}
