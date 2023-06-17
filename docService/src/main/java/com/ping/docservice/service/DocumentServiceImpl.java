package com.ping.docservice.service;

import com.ping.docservice.common.R;
import com.ping.docservice.dao.DocumentDao;
import com.ping.docservice.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    DocumentDao documentDao;

    /**
     * Create API creates a new record
     * It handles the already existing error, and return general return object
     * @return '200' for successful creation; '409' for already existing error
     */
    @Override
    public R<Document> create(Document document) {
        System.out.println(documentDao.getById(document.getId()));
        if(documentDao.getById(document.getId()).getContent() != null){
            return R.error(409, "Document already exists");
        }
        documentDao.create(document);
        return R.success(document);
    }

    /**
     * Delete API deletes an existing record
     * It handles the not exist error
     * @return '200' for successful deletion; '409' for not exist error
     */
    @Override
    public R<Document> delete(Integer id) {
        if(documentDao.getById(id).getContent() == null){
            return R.error(409, "Document does not exist");
        }
        documentDao.delete(id);
        return R.success(null);
    }

    /**
     * Update API updates an existing record
     * It handles the not exist error
     * @return '200' for successful update; '409' for not exist error
     */
    @Override
    public R<Document> update(Document doc) {
        if(documentDao.getById(doc.getId()).getContent() == null){
            return R.error(409, "Document does not exist");
        }
        documentDao.update(doc);
        return R.success(doc);
    }

    /**
     * GetAll API gets all existing record
     * @return '200' for successful query;
     */
    @Override
    public R<List<Document>> getAll() {
        return R.success(documentDao.getAll());
    }

    /**
     * GetById API get an existing record by id
     * It handles the not exist error
     * @return '200' for successful query; '409' for not exist error
     */
    @Override
    public R<Document> getById(Integer id) {
        if(documentDao.getById(id).getContent() == null){
            return R.error(409, "Document does not exist");
        }
        return R.success(documentDao.getById(id));
    }
}
