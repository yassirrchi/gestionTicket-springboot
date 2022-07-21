package com.gestionticket.expertisedata.gestionticket.Controllers;

import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import com.gestionticket.expertisedata.gestionticket.Services.TicketServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin("*")
public class TicketsController {
    @Autowired

    private TicketServices ticketServices;

    @GetMapping("/alltickets") //admin
    public List<Ticket> getAllTickets(){
        return ticketServices.getAllTickets();
    }

    @GetMapping("/ticket/{id}") // all
    public Ticket getTicketById(@PathVariable Long id){
        return ticketServices.GetTicketById(id);

    }
    @PostMapping //client
    public void createTicket(){
        //parameters to be updated
        ticketServices.CreateTicket();
    }
    @PutMapping //client
    public void updateTicket(@RequestBody  Ticket ticket){
        //only works if state is non traite
    }
    @GetMapping("/tickets/client/{id}")
    public  List<Ticket> clientTickets(@PathVariable Long id){
        return ticketServices.getClientTickets(id);

    }

}
