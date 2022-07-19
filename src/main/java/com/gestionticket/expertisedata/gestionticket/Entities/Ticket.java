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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String Sujet;
    private String Description;
    private boolean isEdited;
    private Date CreatedAt;
    private String CreatedBy;
    private String Status;
    private byte Priorite;
    @ManyToOne(cascade=CascadeType.REMOVE)
    private Utilisateur client;

}
