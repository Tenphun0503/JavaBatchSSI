package com.ping.docservice2;

import com.ping.docservice2.dao.DocumentDao;
import com.ping.docservice2.pojo.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DocumentDaoTests {
    @Autowired
    DocumentDao documentDao;

    @Test
    public void testGetById() {
        Optional<Document> id = documentDao.findById(1);
        if(id.isPresent()){
            System.out.println("Is present");
        }
    }

    @Test
    public void testGetAll(){
        System.out.println(documentDao.findAll());
    }
}