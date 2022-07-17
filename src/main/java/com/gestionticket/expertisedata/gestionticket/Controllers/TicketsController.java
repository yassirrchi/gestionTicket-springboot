package com.gestionticket.expertisedata.gestionticket.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketsController {
    @GetMapping("/ok")
    public String text(){
        return "okey";
    }
}
