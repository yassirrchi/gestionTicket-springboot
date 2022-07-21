package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Technicien;

import java.util.List;

public interface UserServices {
    public List<Administrateur> getAdministrators();
    public List<Technicien> getTechniciens();
    public List<Client> getClients();
    public Client findClientByUsername(String username);
    public Client CreateClient(Client client);
    public Technicien findTechnicienByUsername(String username);
    public Technicien createTechnicien(Technicien technicien);
    public Administrateur findAdminByUsername(String username);

}
