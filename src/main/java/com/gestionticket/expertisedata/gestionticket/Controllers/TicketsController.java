package com.gestionticket.expertisedata.gestionticket.Controllers;

import com.gestionticket.expertisedata.gestionticket.Entities.Document;
import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import com.gestionticket.expertisedata.gestionticket.Services.FileServices;
import com.gestionticket.expertisedata.gestionticket.Services.TicketServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin("*")
public class TicketsController {
    @Autowired

    private TicketServices ticketServices;
    @Autowired

    private FileServices fileServices;

    @GetMapping("/alltickets") //admin
    public List<Ticket> getAllTickets(){
        return ticketServices.getAllTickets();
    }

    @GetMapping("/ticket/{id}") // all
    public Ticket getTicketById(@PathVariable Long id){
        return ticketServices.GetTicketById(id);

    }
    @PostMapping("/ticket/create") //client
    public void createTicket(@RequestBody Ticket ticket){
        System.out.println(ticket.getDescription()+" "+ticket.getSujet());
        System.out.println("id client: "+ ticket.getClient().getId());

        ticketServices.CreateTicket(ticket.getSujet(),ticket.getDescription(),ticket.getClient().getId());
        //parameters to be updated

       // ticketServices.CreateTicket();
    }
    @PutMapping //client
    public void updateTicket(@RequestBody  Ticket ticket){
        //only works if state is non traite
    }
    @GetMapping("/tickets/client/{id}")
    public  List<Ticket> clientTickets(@PathVariable Long id){
        return ticketServices.getClientTickets(id);

    }
    @PostMapping("/file")
    public void uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("sujet") String sujet,@RequestParam("description") String description,@RequestParam("clientid") Long clientid) throws IOException {
        System.out.println(sujet+" "+description+" "+clientid+" ");
        System.out.println(file);



         ticketServices.saveticketwithfile(sujet,description,clientid,file);


    }
    @GetMapping("/file/{ticketid}")
    public ResponseEntity<Resource> getDocument(@PathVariable Long ticketid){
        Document document=fileServices.getFile(ticketid);
        byte[] resourcebyte=document.getContenu();
        ByteArrayResource byteArrayResource=new ByteArrayResource(resourcebyte);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("File-name",document.getOriginalName());
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;File-name="+document.getOriginalName());



        //return ;
return ResponseEntity.ok().contentType(MediaType.parseMediaType(document.getType())).headers(httpHeaders).body(byteArrayResource);
    }

}
