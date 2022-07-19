package com.gestionticket.expertisedata.gestionticket.Parser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketToTraitement {
    private Long ticketId;
    private  Long technicienId;
}
