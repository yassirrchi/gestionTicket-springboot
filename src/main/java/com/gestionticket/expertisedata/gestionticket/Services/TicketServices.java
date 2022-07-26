package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;

import java.util.List;

public interface TicketServices {
    public List<Ticket> getAllTickets();
    public void CreateTicket(String raison,String message,Long clientId);
    public void ChangeTicketState(String state,Long ticketId);
    public Ticket GetTicketById(Long ticketId);
    public List<Ticket> getClientTickets(Long id);
}
