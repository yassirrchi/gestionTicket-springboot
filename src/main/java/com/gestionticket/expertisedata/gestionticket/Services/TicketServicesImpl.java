package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Client;
import com.gestionticket.expertisedata.gestionticket.Entities.Document;
import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import com.gestionticket.expertisedata.gestionticket.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TicketServicesImpl implements  TicketServices{
    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private  UserServices userServices;
    @Autowired
    private FileServices fileServices;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public void CreateTicket(String raison, String message,Long id) {
        Ticket ticket=new Ticket();
        ticket.setStatus("non traite");
        ticket.setCreatedAt(new Date());
        ticket.setSujet(raison);
        ticket.setDescription(message);
        ticket.setClient(userServices.findClientById(id));
        ticket.setPriorite(1);
        ticketRepo.save(ticket);


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

    @Override
    public void saveticketwithfile(String raison, String message, Long clientId, MultipartFile file) throws IOException {
        Ticket ticket=new Ticket();
        Document document=new Document();




        document.setFilename(UUID.randomUUID().toString());
        document.setOriginalName(file.getOriginalFilename());
        document.setType(file.getContentType());
        document.setContenu(file.getBytes());




        ticket.setStatus("non traite");
        ticket.setCreatedAt(new Date());
        ticket.setSujet(raison);
        ticket.setDescription(message);
        ticket.setClient(userServices.findClientById(clientId));

        ticket.setPriorite(1);
        if(file!=null){
            ticket.setHasFile(true);

        }else {
            ticket.setHasFile(false);
        }
       Ticket savedTicket= ticketRepo.save(ticket);
        fileServices.save(file,savedTicket.getId());


    }


}
