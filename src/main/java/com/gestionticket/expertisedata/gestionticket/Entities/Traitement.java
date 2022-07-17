package com.gestionticket.expertisedata.gestionticket.Entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Date CreatedAt;
    private String ClientDetails;
    private String TechnicienDetails;
    private String Status; //resolved/ en cours/ rejetee / if changed the status of Ticket changes too
    @ManyToOne(cascade=CascadeType.REMOVE)
    private Utilisateur technicien;
}
