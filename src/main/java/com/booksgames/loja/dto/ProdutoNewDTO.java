package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Cor;
import com.booksgames.loja.documents.Grupo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class ProdutoNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public String _id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    public String descricao;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    public Double preco;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    private Grupo grupo;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    private Cor cor;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    public Date datacadastro;

    public ProdutoNewDTO() {
    }

    public ProdutoNewDTO(String _id, String descricao, Double preco, Grupo grupo, Cor cor, Date datacadastro) {
        this._id = _id;
        this.descricao = descricao;
        this.preco = preco;
        this.grupo = grupo;
        this.cor = cor;
        this.datacadastro = datacadastro;
    }

    public Grupo getGrupo( ) {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cor getCor( ) {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
}