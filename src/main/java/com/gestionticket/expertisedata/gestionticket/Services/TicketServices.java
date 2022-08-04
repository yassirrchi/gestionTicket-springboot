package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TicketServices {
    public List<Ticket> getAllTickets();
    public void CreateTicket(String raison,String message,Long clientId);
    public void ChangeTicketState(String state,Long ticketId);
    public Ticket GetTicketById(Long ticketId);
    public List<Ticket> getClientTickets(Long id);
    public void saveticketwithfile(String raison, String message, Long clientId, MultipartFile file) throws IOException;
}
