package com.ping.docservice.service;

import com.ping.docservice.common.R;
import com.ping.docservice.entity.Document;

import java.util.List;

public interface DocumentService {
    R<Document> create(Document document);
    R<Document> delete(Integer id);
    R<Document> update(Document doc);
    R<List<Document>> getAll();
    R<Document> getById(Integer id);
}
