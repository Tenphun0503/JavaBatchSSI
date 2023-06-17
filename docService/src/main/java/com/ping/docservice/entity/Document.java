package com.ping.docservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Document implements Serializable {
    public static final long serialVersionUID = 1L;
    Integer id;
    String content;

    public Document() {
    }

    public Document(Integer id, String content) {
        this.id = id;
        this.content = content;
    }
}
