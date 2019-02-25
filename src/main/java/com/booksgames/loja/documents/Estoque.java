package com.booksgames.loja.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "produto")
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;

    private String descricao;

    private String referencia;

    private boolean ativo = true;

    private String observacao;

    private boolean materiaPrima = false;

    private String uncom;

    @Column(nullable = false)
    private boolean vendamovel = true;

    @Column(nullable = false)
    private boolean pesado = false;

    private LocalDateTime inclusao;

    private LocalDateTime alteracao;

    private boolean regraPromo = false;

    private String prodesp;

    private String codAnvisa;

    private String codAnp;

    private String descAnp;

    private String indescala;

    private String cnpjfabescala;

    private boolean vendaProducao = false;

    private Marca marca;

    private Grupo grupo;

    private Subgrupo subgrupo;

    private Unidade unidade;

    private Grade grade;

    private Fornecedor fornecedor;

    private List<EstoqueFilial> estoqueFilials;

    private List<EstoqueFilialUf> estoqueFilialUfs;

    private List<EstoqueCodbar> codbars;

    public Estoque() {
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(boolean materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String getUncom() {
        return uncom;
    }

    public void setUncom(String uncom) {
        this.uncom = uncom;
    }

    public boolean isVendamovel() {
        return vendamovel;
    }

    public void setVendamovel(boolean vendamovel) {
        this.vendamovel = vendamovel;
    }

    public boolean isPesado() {
        return pesado;
    }

    public void setPesado(boolean pesado) {
        this.pesado = pesado;
    }

    public LocalDateTime getInclusao() {
        return inclusao;
    }

    public void setInclusao(LocalDateTime inclusao) {
        this.inclusao = inclusao;
    }

    public LocalDateTime getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(LocalDateTime alteracao) {
        this.alteracao = alteracao;
    }

    public boolean isRegraPromo() {
        return regraPromo;
    }

    public void setRegraPromo(boolean regraPromo) {
        this.regraPromo = regraPromo;
    }

    public String getProdesp() {
        return prodesp;
    }

    public void setProdesp(String prodesp) {
        this.prodesp = prodesp;
    }

    public String getCodAnvisa() {
        return codAnvisa;
    }

    public void setCodAnvisa(String codAnvisa) {
        this.codAnvisa = codAnvisa;
    }

    public String getCodAnp() {
        return codAnp;
    }

    public void setCodAnp(String codAnp) {
        this.codAnp = codAnp;
    }

    public String getDescAnp() {
        return descAnp;
    }

    public void setDescAnp(String descAnp) {
        this.descAnp = descAnp;
    }

    public String getIndescala() {
        return indescala;
    }

    public void setIndescala(String indescala) {
        this.indescala = indescala;
    }

    public String getCnpjfabescala() {
        return cnpjfabescala;
    }

    public void setCnpjfabescala(String cnpjfabescala) {
        this.cnpjfabescala = cnpjfabescala;
    }

    public boolean isVendaProducao() {
        return vendaProducao;
    }

    public void setVendaProducao(boolean vendaProducao) {
        this.vendaProducao = vendaProducao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Subgrupo getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(Subgrupo subgrupo) {
        this.subgrupo = subgrupo;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<EstoqueFilial> getEstoqueFilials() {
        return estoqueFilials;
    }

    public void setEstoqueFilials(List<EstoqueFilial> estoqueFilials) {
        this.estoqueFilials = estoqueFilials;
    }

    public List<EstoqueFilialUf> getEstoqueFilialUfs() {
        return estoqueFilialUfs;
    }

    public void setEstoqueFilialUfs(List<EstoqueFilialUf> estoqueFilialUfs) {
        this.estoqueFilialUfs = estoqueFilialUfs;
    }

    public List<EstoqueCodbar> getCodbars() {
        return codbars;
    }

    public void setCodbars(List<EstoqueCodbar> codbars) {
        this.codbars = codbars;
    }


    @Override
    public String toString() {
        return "Estoque{" +
                ", descricao='" + descricao + '\'' +
                ", referencia='" + referencia + '\'' +
                ", ativo=" + ativo +
                ", observacao='" + observacao + '\'' +
                ", materiaPrima=" + materiaPrima +
                ", uncom='" + uncom + '\'' +
                ", vendamovel=" + vendamovel +
                ", pesado=" + pesado +
                ", inclusao=" + inclusao +
                ", alteracao=" + alteracao +
                ", regraPromo=" + regraPromo +
                ", prodesp='" + prodesp + '\'' +
                ", codAnvisa='" + codAnvisa + '\'' +
                ", codAnp='" + codAnp + '\'' +
                ", descAnp='" + descAnp + '\'' +
                ", indescala='" + indescala + '\'' +
                ", cnpjfabescala='" + cnpjfabescala + '\'' +
                ", vendaProducao=" + vendaProducao +
                ", marca=" + marca +
                ", grupo=" + grupo +
                ", subgrupo=" + subgrupo +
                ", unidade=" + unidade +
                ", grade=" + grade +
                ", fornecedor=" + fornecedor +
                ", estoqueFilials=" + estoqueFilials +
                ", estoqueFilialUfs=" + estoqueFilialUfs +
                ", codbars=" + codbars +
                '}';
    }

    public static class EstoqueBuilder {

        private Long id;
        private String descricao;
        private String referencia;
        private boolean ativo;
        private String observacao;
        private boolean materiaPrima;
        private String uncom;
        private boolean vendamovel;
        private boolean pesado;
        private String prodesp;
        private String codAnvisa;
        private String codAnp;
        private String descAnp;
        private String indescala;
        private String cnpjfabescala;
        private Marca marca;
        private Grupo grupo;
        private Subgrupo subgrupo;
        private Unidade unidade;
        private Grade grade;
        private Fornecedor fornecedor;
        private List<EstoqueFilial> estoqueFilials;
        private List<EstoqueFilialUf> estoqueFilialUfs;
        private List<EstoqueCodbar> codbars;

        private EstoqueBuilder() {
        }

        public static EstoqueBuilder oEstoque() {
            return new EstoqueBuilder();
        }

        public EstoqueBuilder comId(Long id) {
            this.id = id;
            return this;
        }

        public EstoqueBuilder comDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public EstoqueBuilder comReferencia(String referencia) {
            this.referencia = referencia;
            return this;
        }

        public EstoqueBuilder eAtivo() {
            this.ativo = true;
            return this;
        }

        public EstoqueBuilder eInativo() {
            this.ativo = false;
            return this;
        }

        public EstoqueBuilder comObservacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        public EstoqueBuilder eMateriaPrima() {
            this.materiaPrima = true;
            return this;
        }

        public EstoqueBuilder eNaoMateriaPrima() {
            this.materiaPrima = false;
            return this;
        }

        public EstoqueBuilder comUncom(String uncom) {
            this.uncom = uncom;
            return this;
        }

        public EstoqueBuilder eVendamovel() {
            this.vendamovel = true;
            return this;
        }

        public EstoqueBuilder eNaoVendamovel() {
            this.vendamovel = false;
            return this;
        }

        public EstoqueBuilder ePesado() {
            this.pesado = true;
            return this;
        }

        public EstoqueBuilder eNaoPesado() {
            this.pesado = false;
            return this;
        }

        public EstoqueBuilder comProdesp(String prodesp) {
            this.prodesp = prodesp;
            return this;
        }

        public EstoqueBuilder comCodAnvisa(String codAnvisa) {
            this.codAnvisa = codAnvisa;
            return this;
        }

        public EstoqueBuilder comCodAnp(String codAnp) {
            this.codAnp = codAnp;
            return this;
        }

        public EstoqueBuilder comDescAnp(String descAnp) {
            this.descAnp = descAnp;
            return this;
        }

        public EstoqueBuilder comIndescala(String indescala) {
            this.indescala = indescala;
            return this;
        }

        public EstoqueBuilder comCnpjfabescala(String cnpjfabescala) {
            this.cnpjfabescala = cnpjfabescala;
            return this;
        }

        public EstoqueBuilder comMarca(Marca marca) {
            this.marca = marca;
            return this;
        }

        public EstoqueBuilder comGrupo(Grupo grupo) {
            this.grupo = grupo;
            return this;
        }

        public EstoqueBuilder comSubgrupo(Subgrupo subgrupo) {
            this.subgrupo = subgrupo;
            return this;
        }

        public EstoqueBuilder comUnidade(Unidade unidade) {
            this.unidade = unidade;
            return this;
        }

        public EstoqueBuilder comGrade(Grade grade) {
            this.grade = grade;
            return this;
        }

        public EstoqueBuilder comFornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
            return this;
        }

        public EstoqueBuilder comEstoqueFilials(List<EstoqueFilial> estoqueFilials) {
            this.estoqueFilials = estoqueFilials;
            return this;
        }

        public EstoqueBuilder comEstoqueFilialUfs(List<EstoqueFilialUf> estoqueFilialUfs) {
            this.estoqueFilialUfs = estoqueFilialUfs;
            return this;
        }

        public EstoqueBuilder comCodbars(List<EstoqueCodbar> codbars) {
            this.codbars = codbars;
            return this;
        }

        public Estoque build() {
            Estoque estoque = new Estoque();
            estoque.setDescricao(descricao);
            estoque.setReferencia(referencia);
            estoque.setAtivo(ativo);
            estoque.setObservacao(observacao);
            estoque.setMateriaPrima(materiaPrima);
            estoque.setUncom(uncom);
            estoque.setVendamovel(vendamovel);
            estoque.setPesado(pesado);
            estoque.setProdesp(prodesp);
            estoque.setCodAnvisa(codAnvisa);
            estoque.setCodAnp(codAnp);
            estoque.setDescAnp(descAnp);
            estoque.setIndescala(indescala);
            estoque.setCnpjfabescala(cnpjfabescala);
            estoque.setMarca(marca);
            estoque.setGrupo(grupo);
            estoque.setSubgrupo(subgrupo);
            estoque.setUnidade(unidade);
            estoque.setGrade(grade);
            estoque.setFornecedor(fornecedor);
            estoque.setEstoqueFilials(estoqueFilials);
            estoque.setEstoqueFilialUfs(estoqueFilialUfs);
            estoque.setCodbars(codbars);

            return estoque;
        }
    }
}