package com.booksgames.loja.documents;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public abstract class Pessoa implements Serializable {

    @Id
    private Long id;

    private String nomeRazao;

    @Column(nullable = false, updatable = false)
    private LocalDate inclusao;

    @Column(nullable = false)
    private LocalDate alteracao;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(columnDefinition = "TEXT")
    private String obs;

    @Column(name = "emailauto", nullable = false)
    private boolean emailAuto = false;

    @Column(nullable = false)
    private boolean isentoicms = false;

    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Cliente cliente;

    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Funcionario funcionario;

    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Transportadora transportadora;

    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoVirtual> enderecosVirtuais;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public LocalDate getInclusao() {
        return inclusao;
    }

    public void setInclusao(LocalDate inclusao) {
        this.inclusao = inclusao;
    }

    public LocalDate getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(LocalDate alteracao) {
        this.alteracao = alteracao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isEmailAuto() {
        return emailAuto;
    }

    public void setEmailAuto(boolean emailAuto) {
        this.emailAuto = emailAuto;
    }

    public boolean isIsentoicms() {
        return isentoicms;
    }

    public void setIsentoicms(boolean isentoicms) {
        this.isentoicms = isentoicms;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<EnderecoVirtual> getEnderecosVirtuais() {
        return enderecosVirtuais;
    }

    public void setEnderecosVirtuais(List<EnderecoVirtual> enderecosVirtuais) {
        this.enderecosVirtuais = enderecosVirtuais;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nomeRazao='" + nomeRazao + '\'' +
                ", inclusao=" + inclusao +
                ", alteracao=" + alteracao +
                ", ativo=" + ativo +
                ", obs='" + obs + '\'' +
                ", emailAuto=" + emailAuto +
                ", isentoicms=" + isentoicms +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                ", transportadora=" + transportadora +
                ", fornecedor=" + fornecedor +
                ", enderecos=" + enderecos +
                ", enderecosVirtuais=" + enderecosVirtuais +
                ", telefones=" + telefones +
                '}';
    }
}