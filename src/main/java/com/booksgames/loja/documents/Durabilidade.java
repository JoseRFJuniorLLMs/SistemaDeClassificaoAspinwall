package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "durabilidade")
public class Durabilidade implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    public String _id;
    public String descricao;

    public Durabilidade(String _id, String descricao) {
        this._id = _id;
        this.descricao = descricao;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
