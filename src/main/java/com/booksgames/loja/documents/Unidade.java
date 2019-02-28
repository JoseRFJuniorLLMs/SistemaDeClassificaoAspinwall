package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "unidade")
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    public Unidade(String _id, String descricao) {
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
        if (!(o instanceof Unidade)) return false;
        Unidade unidade = (Unidade) o;
        return get_id().equals(unidade.get_id()) &&
                getDescricao().equals(unidade.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "_id='" + _id + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
