package com.ping.docservice2.dao;

import com.ping.docservice2.pojo.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDao extends JpaRepository<Document, Integer> {
}
