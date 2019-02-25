package com.booksgames.loja.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

public class Telefone implements Serializable {

    @Id
    private Long id;

    @Column(length = 120)
    private String descricao;

    @Column(length = 17)
    private String telefone;

    private Integer ramal;

    @Column(nullable = false)
    private boolean padrao = false;

    private Pessoa pessoa;

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getRamal() {
        return ramal;
    }

    public void setRamal(Integer ramal) {
        this.ramal = ramal;
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
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", ramal=" + ramal +
                ", padrao=" + padrao +
                ", pessoa=" + pessoa +
                '}';
    }

    public static final class TelefoneBuilder {
        private Long id;
        private String descricao;
        private String telefone;
        private Integer ramal;
        private boolean padrao = false;

        private TelefoneBuilder() {
        }

        public static TelefoneBuilder oTelefone() {
            return new TelefoneBuilder();
        }

        public TelefoneBuilder comId(Long id) {
            this.id = id;
            return this;
        }

        public TelefoneBuilder comDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public TelefoneBuilder comTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public TelefoneBuilder comRamal(Integer ramal) {
            this.ramal = ramal;
            return this;
        }

        public TelefoneBuilder comPadrao(boolean padrao) {
            this.padrao = padrao;
            return this;
        }

        public Telefone build() {
            Telefone oTelefone = new Telefone();
            oTelefone.setId(id);
            oTelefone.setDescricao(descricao);
            oTelefone.setTelefone(telefone);
            oTelefone.setRamal(ramal);
            oTelefone.setPadrao(padrao);
            return oTelefone;
        }
    }
}