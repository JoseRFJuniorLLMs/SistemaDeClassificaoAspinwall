package com.booksgames.loja.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "tamanho")
public class Tamanho implements Serializable {
    private static final long serialVersionUID = 1L;
}
