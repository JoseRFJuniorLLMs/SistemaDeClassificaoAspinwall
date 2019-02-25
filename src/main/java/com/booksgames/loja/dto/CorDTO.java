package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Cor;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class CorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _id;
    private String nome;
    private String hex;

    public CorDTO() {
    }

    public CorDTO(Cor obj) {
        _id = obj.get_id();
        nome = obj.getNome();
        hex = obj.getHex();
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
