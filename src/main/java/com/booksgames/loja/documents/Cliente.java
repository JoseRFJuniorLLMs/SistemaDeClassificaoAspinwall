package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.validator.constraints.br.CPF;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "cliente")
public class Cliente {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    private String nome;
    private String email;
    private String cpf;

    // Constructors
    public Cliente() {}

    public Cliente(String _id, String nome, String email, String cpf) {
        this._id = _id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String get_id( ) {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @CPF(message = "CPF inválido")
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

