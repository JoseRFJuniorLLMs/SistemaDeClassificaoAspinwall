package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Unidade;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public class UnidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _id;
    private String descricao;

    public UnidadeDTO() {
    }

    public UnidadeDTO(Unidade obj) {
        _id = obj.get_id();
        descricao = obj.getDescricao();

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
