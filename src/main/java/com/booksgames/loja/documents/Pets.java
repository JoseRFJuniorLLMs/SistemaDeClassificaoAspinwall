package com.booksgames.loja.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "pets")
public class Pets {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;

    public String nome;
    public String especie;
    public String raca;

    // Constructors
    public Pets() {}

    public Pets(String _id, String nome, String especie, String raca) {
        this._id = _id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
    }

    public String get_id( ) {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
}