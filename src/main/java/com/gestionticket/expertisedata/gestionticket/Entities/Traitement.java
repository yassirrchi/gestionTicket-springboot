package com.gestionticket.expertisedata.gestionticket.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
