package com.gestionticket.expertisedata.gestionticket.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.rmi.CORBA.Util;
import java.util.List;
@Data

@Entity
@DiscriminatorValue("ADMN")
public class Administrateur extends Utilisateur {
private int tasksAssigned;
}
