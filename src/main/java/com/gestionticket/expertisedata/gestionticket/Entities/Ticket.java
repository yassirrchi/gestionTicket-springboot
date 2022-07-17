package com.gestionticket.expertisedata.gestionticket.Entities;



import javax.persistence.*;
import java.util.Date;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String Sujet;
    private String Description;
    private Date CreatedAt;
    private String CreatedBy;
    private String Status;
    private byte Priorite;
    @ManyToOne(cascade=CascadeType.REMOVE)
    private Utilisateur client;

}
