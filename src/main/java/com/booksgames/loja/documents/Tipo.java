package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "tipo")
public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    // Constructors
    public Tipo() {}

    public Tipo(String _id, String descricao) {
        this._id = _id;
        this.descricao = descricao;

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
        if (!(o instanceof Tipo)) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(get_id(), tipo.get_id()) &&
                Objects.equals(getDescricao(), tipo.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao());
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "_id='" + _id + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

/*
    produtos ao consumidor (ou bens de consumo) - usados por usuários-finais
        produtos industriais - usados na produção de outros bens
        bens de conveniência - adquiridos frequentemente e com um esforço mínimo
        bens de impulso - compra por estímulo sensorial imediato
        bens de emergência - bens necessários imediatamente
        bens de compra comparada - alguma comparação com outros bens como carros e TVs. Ou seja, são produtos que exigem um alto esforço do consumidor para comparar os requisitos e fazer uma escolha que atenda às suas necessidades.
        bens de especialidade - comparação extensiva com outros bens e uma longa busca por informações
        bens não procurados - ex. vagas em cemitérios, seguros
        bens perecíveis - bens que se deteriorarão rapidamente mesmo sem uso
        bens duráveis - bens que sobrevivem à ocasiões de múltiplo uso
        bens não-duráveis - bens que serão consumidos em um única oportunidade
        bens de capital - instalações, equipamentos e construções
        partes e materiais - bens que são agregados a um produto final
abastecimento e serviços - bens que facilitam a produção
        commodities - bens indiferenciáveis (ex. trigo, ouro, açúcar, etc)
        produtos intermediários - resulta da fabricação de outro produto*/
