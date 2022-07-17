package com.gestionticket.expertisedata.gestionticket.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)

public  abstract  class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long Id;
    private String username;

    private String email;
    private String password;



}
