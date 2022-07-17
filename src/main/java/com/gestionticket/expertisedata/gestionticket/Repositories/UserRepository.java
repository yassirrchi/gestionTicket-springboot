package com.gestionticket.expertisedata.gestionticket.Repositories;

import com.gestionticket.expertisedata.gestionticket.Entities.Administrateur;
import com.gestionticket.expertisedata.gestionticket.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Utilisateur,Long> {

   // @Query("SELECT admin FROM Utilisateur admin WHERE admin.tasks_assigned =NULL")
     // List<Utilisateur> findAllAdmins();
   // List<Administrateur> findAllBy


}
