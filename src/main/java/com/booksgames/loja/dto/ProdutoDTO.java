package com.booksgames.loja.dto;

import com.booksgames.loja.documents.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.gridfs.GridFS;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public String _id;
    private UUID uuid;
    public String descricao;
    public Double preco;
    public Embalagem embalagem;
    public String durabilidade;
    public Double peso;
    public String rotulagem;
    public String status;
    public Grupo grupo;
    public Cor cor;
    public Marca marca;
    public GridFS imagem;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    public Date datacadastro;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto obj) {
        _id = obj.get_id();
        uuid = UUID.randomUUID();
        descricao = obj.getDescricao();
        preco = obj.getPreco();
        embalagem = obj.getEmbalagem();
        durabilidade = obj.getDurabilidade();
        peso = obj.getPeso();
        rotulagem = obj.getRotulagem();
        status = obj.getStatus();
        grupo = obj.getGrupo();
        cor = obj.getCor();
        marca = obj.getMarca();
        imagem = obj.getImagem();
        datacadastro = obj.getDatacadastro();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoDTO)) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Objects.equals(get_id(), that.get_id()) &&
                Objects.equals(getUuid(), that.getUuid()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getPreco(), that.getPreco()) &&
                Objects.equals(getEmbalagem(), that.getEmbalagem()) &&
                Objects.equals(getDurabilidade(), that.getDurabilidade()) &&
                Objects.equals(getPeso(), that.getPeso()) &&
                Objects.equals(getRotulagem(), that.getRotulagem()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getGrupo(), that.getGrupo()) &&
                Objects.equals(getCor(), that.getCor()) &&
                Objects.equals(getMarca(), that.getMarca()) &&
                Objects.equals(getImagem(), that.getImagem()) &&
                Objects.equals(getDatacadastro(), that.getDatacadastro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getUuid(), getDescricao(), getPreco(), getEmbalagem(), getDurabilidade(), getPeso(), getRotulagem(), getStatus(), getGrupo(), getCor(), getMarca(), getImagem(), getDatacadastro());
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    public String getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(String durabilidade) {
        this.durabilidade = durabilidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRotulagem() {
        return rotulagem;
    }

    public void setRotulagem(String rotulagem) {
        this.rotulagem = rotulagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public GridFS getImagem() {
        return imagem;
    }

    public void setImagem(GridFS imagem) {
        this.imagem = imagem;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
}