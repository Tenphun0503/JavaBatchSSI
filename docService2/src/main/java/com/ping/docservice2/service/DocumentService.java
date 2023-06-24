package com.ping.docservice2.service;

import com.ping.docservice2.dao.DocumentDao;
import com.ping.docservice2.exception.DocumentExistedException;
import com.ping.docservice2.exception.DocumentNotFoundException;
import com.ping.docservice2.pojo.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentDao documentDao;

    @Autowired
    public DocumentService(DocumentDao documentDao){
        this.documentDao = documentDao;
    }

    public Document create(Document document) {
        if(documentDao.findById(document.getId()).isPresent()){
            throw new DocumentExistedException("Document already exists");
        }
        return documentDao.save(document);
    }

    public void delete(Integer id){
        if(documentDao.findById(id).isEmpty()){
            throw new DocumentNotFoundException("Document not found");
        }
        documentDao.deleteById(id);
    }

    public Document update(Document document){
        if(documentDao.findById(document.getId()).isEmpty()){
            throw new DocumentNotFoundException("Document not found");
        }
        return documentDao.save(document);
    }

    public Document getById(Integer id){
        if(documentDao.findById(id).isEmpty()){
            throw new DocumentNotFoundException("Document not found");
        }
        return documentDao.findById(id).get();
    }

    public List<Document> getAll(){
        return documentDao.findAll();
    }
}
