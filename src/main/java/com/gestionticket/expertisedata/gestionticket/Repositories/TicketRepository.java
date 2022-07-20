package com.gestionticket.expertisedata.gestionticket.Repositories;

import com.gestionticket.expertisedata.gestionticket.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
public List<Ticket> findTicketByClientId(Long id);
}
