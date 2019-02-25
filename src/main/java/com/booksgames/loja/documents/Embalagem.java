package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "embalagem")
public class Embalagem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    // Constructors
    public Embalagem() {}

    public Embalagem(String _id, String descricao) {
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