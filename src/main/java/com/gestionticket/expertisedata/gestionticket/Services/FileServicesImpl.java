package com.gestionticket.expertisedata.gestionticket.Services;

import com.gestionticket.expertisedata.gestionticket.Entities.Document;
import com.gestionticket.expertisedata.gestionticket.Repositories.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
@Service
@Transactional
public class FileServicesImpl implements  FileServices {
    @Autowired
    private DocumentRepo documentRepo;

    @Override
    public Document save(MultipartFile file,Long ticketId) throws IOException {

        Document document=new Document();
        document.setFilename(UUID.randomUUID().toString());
        document.setOriginalName(file.getOriginalFilename());
        document.setType(file.getContentType());
        document.setTicketId(ticketId);
        document.setContenu(file.getBytes());
        return documentRepo.save(document);



    }

    @Override
    public Document getFile(Long id) {
        Optional<Document> document= Optional.ofNullable(documentRepo.findDocumentByTicketId(id));
        if(document.isPresent())
            return document.get();
        return null;


    }
}
