package com.ping.docservice.dao;

import com.ping.docservice.entity.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class DocumentDaoImpl implements DocumentDao{
    private final HashMap<Integer, String> documents;

    public DocumentDaoImpl(){
        documents = new HashMap<>();
    }
    @Override
    public void create(Document doc) {
        documents.put(doc.getId(), doc.getContent());
    }

    @Override
    public void delete(Integer id) {
        documents.remove(id);
    }

    @Override
    public void update(Document doc) {
        documents.put(doc.getId(), doc.getContent());
    }

    @Override
    public List<Document> getAll() {
        List<Document> docs = new ArrayList<>();
        documents.forEach((key, value) -> {
            Document doc = new Document(key, value);
            docs.add(doc);
        });
        return docs;
    }

    @Override
    public Document getById(Integer id) {
        return new Document(id, documents.get(id));
    }
}
