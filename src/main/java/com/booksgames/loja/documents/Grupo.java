package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "grupo")
public class Grupo {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    // Constructors
    public Grupo() {}

    public Grupo(String _id, String descricao) {
        this._id = _id;
        this.descricao = descricao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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