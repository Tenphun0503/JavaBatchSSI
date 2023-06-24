package com.ping.docservice2.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Document implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String content;
}
