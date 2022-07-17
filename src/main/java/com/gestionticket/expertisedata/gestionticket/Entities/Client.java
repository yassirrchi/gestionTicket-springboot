package com.gestionticket.expertisedata.gestionticket.Entities;

import javax.persistence.*;
import javax.rmi.CORBA.Util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.rmi.CORBA.Util;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends Utilisateur {
    @OneToMany(mappedBy = "client",cascade= CascadeType.REMOVE)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Ticket> ticketList;
}
