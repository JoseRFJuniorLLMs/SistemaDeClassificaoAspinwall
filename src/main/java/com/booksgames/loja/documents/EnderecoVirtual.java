package com.booksgames.loja.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class EnderecoVirtual implements Serializable {

    @Id
    private Long id;

    private String tipo;

    private String descricao;

    private boolean padrao = false;

    private Pessoa pessoa;

    public EnderecoVirtual() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPadrao() {
        return padrao;
    }

    public void setPadrao(boolean padrao) {
        this.padrao = padrao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoVirtual that = (EnderecoVirtual) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EnderecoVirtual{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", padrao=" + padrao +
                ", pessoa=" + pessoa +
                '}';
    }

    public static final class EnderecoVirtualBuilder {
        private Long id;
        private String tipo;
        private String descricao;
        private boolean padrao = false;

        private EnderecoVirtualBuilder() {
        }

        public static EnderecoVirtualBuilder oEnderecoVirtual() {
            return new EnderecoVirtualBuilder();
        }

        public EnderecoVirtualBuilder comId(Long id) {
            this.id = id;
            return this;
        }

        public EnderecoVirtualBuilder comTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public EnderecoVirtualBuilder comDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public EnderecoVirtualBuilder comPadrao(boolean padrao) {
            this.padrao = padrao;
            return this;
        }

        public EnderecoVirtual build() {
            EnderecoVirtual enderecoVirtual = new EnderecoVirtual();
            enderecoVirtual.setId(id);
            enderecoVirtual.setTipo(tipo);
            enderecoVirtual.setDescricao(descricao);
            enderecoVirtual.setPadrao(padrao);
            return enderecoVirtual;
        }
    }
}