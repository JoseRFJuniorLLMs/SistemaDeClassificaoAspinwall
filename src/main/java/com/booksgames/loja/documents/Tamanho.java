package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "tamanho")
public class Tamanho implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    public Tamanho(String _id, String descricao) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tamanho)) return false;
        Tamanho tamanho = (Tamanho) o;
        return Objects.equals(get_id(), tamanho.get_id()) &&
                Objects.equals(getDescricao(), tamanho.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }
}
