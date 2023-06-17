package com.ping.docservice.controller;

import com.ping.docservice.entity.Document;
import com.ping.docservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @GetMapping("/{id}")
    public Document getById(@PathVariable Integer id){
        Document doc = new Document();
        return doc;
    }
}
