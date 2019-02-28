package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Garantia;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public class GarantiaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _id;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    public Date inicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    public Date fim;

    public GarantiaDTO() {
    }

    public GarantiaDTO(Garantia obj) {
        _id = obj.get_id();
        descricao = obj.getDescricao();
        inicio = obj.getInicio();
        fim = obj.getFim();

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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GarantiaDTO)) return false;
        GarantiaDTO that = (GarantiaDTO) o;
        return Objects.equals(get_id(), that.get_id()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getInicio(), that.getInicio()) &&
                Objects.equals(getFim(), that.getFim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao(), getInicio(), getFim());
    }

    @Override
    public String toString() {
        return "GarantiaDTO{" +
                "_id='" + _id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
