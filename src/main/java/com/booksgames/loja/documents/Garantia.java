package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "garantia")
public class Garantia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

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
        if (!(o instanceof Garantia)) return false;
        Garantia garantia = (Garantia) o;
        return Objects.equals(get_id(), garantia.get_id()) &&
                Objects.equals(getDescricao(), garantia.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }

    @Override
    public String toString() {
        return "Garantia{" +
                "_id='" + _id + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
