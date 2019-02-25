package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.util.Objects;

@Document(collection = "estadocivil")
public class EstadoCivil implements Serializable {

    @Id
    public String _id;
    private String descricao;
    public EstadoCivil() {
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
        if (!(o instanceof EstadoCivil)) return false;
        EstadoCivil that = (EstadoCivil) o;
        return get_id().equals(that.get_id()) &&
                getDescricao().equals(that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }

    public static final class EstadoCivilBuilder {
        private String id;
        private String descricao;

        private EstadoCivilBuilder() {
        }

        public static EstadoCivilBuilder oEstadoCivil() {
            return new EstadoCivilBuilder();
        }

        public EstadoCivilBuilder comId(String id) {
            this.id = id;
            return this;
        }

        public EstadoCivilBuilder comDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public EstadoCivil build() {
            EstadoCivil estadoCivil = new EstadoCivil();
            estadoCivil.setDescricao(descricao);
            return estadoCivil;
        }
    }
}