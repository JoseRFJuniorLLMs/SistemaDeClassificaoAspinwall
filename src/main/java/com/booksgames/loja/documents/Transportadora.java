package com.booksgames.loja.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "transportadora")
public class Transportadora implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Pessoa pessoa;

    @Column(nullable = false)
    private boolean ativo;

    @Column(length = 20)
    private String antt;

    @Column(length = 8)
    private String placa;

    @Column(length = 2)
    private String ufveiculo;

    public Transportadora() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getAntt() {
        return antt;
    }

    public void setAntt(String antt) {
        this.antt = antt;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getUfveiculo() {
        return ufveiculo;
    }

    public void setUfveiculo(String ufveiculo) {
        this.ufveiculo = ufveiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora that = (Transportadora) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transportadora{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", antt='" + antt + '\'' +
                ", placa='" + placa + '\'' +
                ", ufveiculo='" + ufveiculo + '\'' +
                '}';
    }


    public static final class TransportadoraBuilder {
        private boolean ativo;
        private String antt;
        private String placa;
        private String ufveiculo;

        private TransportadoraBuilder() {
        }

        public static TransportadoraBuilder aTransportadora() {
            return new TransportadoraBuilder();
        }

        public TransportadoraBuilder comAtivo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public TransportadoraBuilder ativo() {
            this.ativo = true;
            return this;
        }

        public TransportadoraBuilder inativo() {
            this.ativo = false;
            return this;
        }

        public TransportadoraBuilder comAntt(String antt) {
            this.antt = antt;
            return this;
        }

        public TransportadoraBuilder comPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public TransportadoraBuilder comUfveiculo(String ufveiculo) {
            this.ufveiculo = ufveiculo;
            return this;
        }

        public Transportadora build() {
            Transportadora transportadora = new Transportadora();
            transportadora.setAtivo(ativo);
            transportadora.setAntt(antt);
            transportadora.setPlaca(placa);
            transportadora.setUfveiculo(ufveiculo);
            return transportadora;
        }
    }
}