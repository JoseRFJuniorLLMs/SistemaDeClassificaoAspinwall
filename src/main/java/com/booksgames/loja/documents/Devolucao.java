package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "devolucao")
public class Devolucao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    // Constructors
    public Devolucao() {}

    public Devolucao(String _id, String descricao) {
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
        if (!(o instanceof Devolucao)) return false;
        Devolucao devolucao = (Devolucao) o;
        return Objects.equals(get_id(), devolucao.get_id()) &&
                Objects.equals(getDescricao(), devolucao.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }
}
