package com.ping.docservice.dao;

import com.ping.docservice.entity.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDao {
    void create(Document doc);
    void delete(Integer id);
    void update(Document doc);
    List<Document> getAll();
    Document getById(Integer id);
}
