package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileServices {
    public Document save(MultipartFile file,Long ticketId) throws IOException;
    public Document getFile(Long id);
}
