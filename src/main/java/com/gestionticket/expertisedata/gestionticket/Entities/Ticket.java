package com.gestionticket.expertisedata.gestionticket.Entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Date;
import java.util.List;

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
    private int Priorite;
    private  boolean hasFile;
    @ManyToOne(cascade=CascadeType.REMOVE)
    private Utilisateur client;



}
