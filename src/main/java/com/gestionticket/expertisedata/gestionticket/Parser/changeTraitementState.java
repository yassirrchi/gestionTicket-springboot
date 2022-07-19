package com.gestionticket.expertisedata.gestionticket.Parser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class changeTraitementState {
    private Long ticketId;
    private Long traitementId;
    private String state;
}
