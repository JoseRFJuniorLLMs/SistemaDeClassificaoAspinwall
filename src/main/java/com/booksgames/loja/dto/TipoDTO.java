package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Tipo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public class TipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _id;
    private String descricao;

    public TipoDTO() {
    }

    public TipoDTO(Tipo obj) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDTO)) return false;
        TipoDTO that = (TipoDTO) o;
        return Objects.equals(get_id(), that.get_id()) &&
                Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }
}
