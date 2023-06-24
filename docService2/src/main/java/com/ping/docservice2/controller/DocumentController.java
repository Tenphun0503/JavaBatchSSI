package com.ping.docservice2.controller;

import com.ping.docservice2.exception.DocumentExistedException;
import com.ping.docservice2.exception.DocumentNotFoundException;
import com.ping.docservice2.pojo.Document;
import com.ping.docservice2.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Document document){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(documentService.create(document));
        } catch (DocumentExistedException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            documentService.delete(id);
            return ResponseEntity.ok().build();
        } catch (DocumentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Document document){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(documentService.update(document));
        } catch (DocumentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(documentService.getById(id));
        } catch (DocumentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(documentService.getAll());
    }
}
