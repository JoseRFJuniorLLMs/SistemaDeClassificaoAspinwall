package com.booksgames.loja.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "cor")
public class Cor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String nome;
    public String hex;

    // Constructors
    public Cor() {}

    public Cor(String _id, String nome, String hex) {
        this._id = _id;
        this.nome = nome;
        this.hex = hex;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

}