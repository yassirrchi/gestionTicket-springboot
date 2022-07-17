package com.gestionticket.expertisedata.gestionticket.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",length=4)
public  class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;
    private String username;

    private String email;
    private String password;



}
