package com.ping.docservice.controller;

import com.ping.docservice.common.R;
import com.ping.docservice.entity.Document;
import com.ping.docservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping
    public R<Document> create(@RequestBody Document document){
        System.out.println("Create...");
        return documentService.create(document);
    }

    @DeleteMapping("/{id}")
    public R<Document> delete(@PathVariable Integer id){
        System.out.println("Delete...");
        return documentService.delete(id);
    }

    @PutMapping
    public R<Document> update(@RequestBody Document updatedDocument) {
        System.out.println("Update...");
        return documentService.update(updatedDocument);
    }

    @GetMapping
    public R<List<Document>> getAll(){
        System.out.println("Get All...");
        return documentService.getAll();
    }

    @GetMapping("/{id}")
    public R<Document> getById(@PathVariable Integer id){
        System.out.println("Get by Id...");
        return documentService.getById(id);
    }
}
