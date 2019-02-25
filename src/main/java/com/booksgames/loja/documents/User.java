package com.booksgames.loja.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
@Document(collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    private Integer id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
