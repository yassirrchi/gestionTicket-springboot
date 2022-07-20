package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import com.gestionticket.expertisedata.gestionticket.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TicketServicesImpl implements  TicketServices{
    @Autowired
    private TicketRepository ticketRepo;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public void CreateTicket() {


    }

    @Override
    public void ChangeTicketState(String state,Long ticketId) {
        //find ticket
        //change the state


    }

    @Override
    public Ticket GetTicketById(Long ticketId) {
        return ticketRepo.findById(ticketId).orElse(null);
    }

    @Override
    public List<Ticket> getClientTickets(Long id) {
        return ticketRepo.findTicketByClientId(id);
    }


}
