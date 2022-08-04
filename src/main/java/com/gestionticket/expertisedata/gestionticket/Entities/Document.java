package com.gestionticket.expertisedata.gestionticket.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String filename;
    private  String originalName;
    private  String type;
    private Long size;
    private  byte[] contenu;
    private Date uploadDate;
    private Long ticketId;



}
