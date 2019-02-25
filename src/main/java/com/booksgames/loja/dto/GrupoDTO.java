package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Grupo;
import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class GrupoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _id;
    private String nome;

    public GrupoDTO() {
    }

    public GrupoDTO(Grupo obj) {
        _id = obj.get_id();
        nome = obj.getDescricao();
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
}
