package com.booksgames.loja.documents;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mongodb.gridfs.GridFS;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.xml.crypto.Data;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 *
 * Sistema de Classificação Aspinwall
 *
 */

@Document(collection = "produto")
public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  public String _id;

  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "uuid", columnDefinition = "VARCHAR(255)")
  private UUID uuid;
  public String descricao;
  public Double preco;
  public String durabilidade;
  public Double peso;
  public String rotulagem;
  public String status;
  public Double altura;
  public Double largura;
  public String formato;
  public String estilo;
  public String qualidade;
  public Tamanho tamanho;
  public Devolucao devolucao;
  public Tipo tipo;
  public Garantia garantia;
  public Embalagem embalagem;
  public Grupo grupo;
  public Cor cor;
  public Marca marca;
  public GridFS imagem;
  public Unidade unidade;
  @JsonFormat(pattern="dd/MM/yyyy HH:mm")
  public Date datacadastro;
  @JsonFormat(pattern="dd/MM/yyyy HH:mm")
  public Date fabricacao;
  @JsonFormat(pattern="dd/MM/yyyy HH:mm")
  public Date vencimento;

  @DBRef(lazy = true)
  private List<Grupo> grupos = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Cor> cors = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Marca> marcas = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Embalagem> embalagems = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Tamanho> tamanhos = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Devolucao> devolucaos = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Tipo> tipos = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Garantia> garantias = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Unidade> unidades = new ArrayList<>();

  public Produto() {
  }
  // Constructors
  public Produto(
                 String _id,
                 UUID uuid,
                 String descricao,
                 Double preco,
                 String durabilidade,
                 Double peso,
                 String rotulagem,
                 String status,
                 Double altura,
                 Double largura,
                 String formato,
                 String estilo,
                 String qualidade,
                 GridFS imagem,
                 Date datacadastro,
                 Date fabricacao,
                 Date vencimento,

                 Tamanho tamanho,
                 Devolucao devolucao,
                 Tipo tipo,
                 Garantia garantia,
                 Embalagem embalagem,
                 Grupo grupo,
                 Cor cor,
                 Marca marca,
                 Unidade unidade,

                 List<Tamanho> tamanhos,
                 List<Devolucao> devolucaos,
                 List<Tipo> tipos,
                 List<Garantia> garantias,
                 List<Embalagem> embalagems,
                 List<Grupo> grupos,
                 List<Cor> cors,
                 List<Marca> marcas,
                 List<Unidade> unidades
  ) {
    this._id = _id;
    this.uuid = uuid;
    this.descricao = descricao;
    this.preco = preco;
    this.durabilidade = durabilidade;
    this.peso = peso;
    this.rotulagem = rotulagem;
    this.status = status;
    this.altura = altura;
    this.largura = largura;
    this.formato = formato;
    this.estilo = estilo;
    this.qualidade = qualidade;
    this.tamanho = tamanho;
    this.devolucao = devolucao;
    this.tipo = tipo;
    this.garantia = garantia;
    this.embalagem = embalagem;
    this.grupo = grupo;
    this.cor = cor;
    this.marca = marca;
    this.imagem = imagem;
    this.datacadastro = datacadastro;
    this.fabricacao = fabricacao;
    this.vencimento = vencimento;
    this.unidade = unidade;

    this.grupos = grupos;
    this.cors = cors;
    this.marcas = marcas;
    this.embalagems = embalagems;
    this.tamanhos = tamanhos;
    this.devolucaos = devolucaos;
    this.tipos = tipos;
    this.garantias = garantias;
    this.unidades = unidades;
  }

  public Produto(
          String _id,
          UUID uuid,
          String descricao,
          Double preco,
          String durabilidade,
          Double peso,
          String rotulagem,
          String status,
          Double altura,
          Double largura,
          String formato,
          String estilo,
          String qualidade,
          Tamanho tamanho,
          Devolucao devolucao,
          Tipo tipo,
          Garantia garantia,
          Embalagem embalagem,
          Grupo grupo,
          Cor cor,
          Marca marca,
          GridFS imagem,
          Date datacadastro,
          Date fabricacao,
          Date vencimento,
          Unidade unidade
  ) {
    this._id = _id;
    this.uuid = uuid;
    this.descricao = descricao;
    this.preco = preco;
    this.durabilidade = durabilidade;
    this.peso = peso;
    this.rotulagem = rotulagem;
    this.status = status;
    this.altura = altura;
    this.largura = largura;
    this.formato = formato;
    this.estilo = estilo;
    this.qualidade = qualidade;
    this.tamanho = tamanho;
    this.devolucao = devolucao;
    this.tipo = tipo;
    this.garantia = garantia;
    this.embalagem = embalagem;
    this.grupo = grupo;
    this.cor = cor;
    this.marca = marca;
    this.imagem = imagem;
    this.datacadastro = datacadastro;
    this.fabricacao = fabricacao;
    this.vencimento = vencimento;
    this.unidade = unidade;
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

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getLargura() {
    return largura;
  }

  public void setLargura(Double largura) {
    this.largura = largura;
  }

  public String getFormato() {
    return formato;
  }

  public void setFormato(String formato) {
    this.formato = formato;
  }

  public String getEstilo() {
    return estilo;
  }

  public void setEstilo(String estilo) {
    this.estilo = estilo;
  }

  public String getQualidade() {
    return qualidade;
  }

  public void setQualidade(String qualidade) {
    this.qualidade = qualidade;
  }

  public Tamanho getTamanho() {
    return tamanho;
  }

  public void setTamanho(Tamanho tamanho) {
    this.tamanho = tamanho;
  }

  public Devolucao getDevolucao() {
    return devolucao;
  }

  public void setDevolucao(Devolucao devolucao) {
    this.devolucao = devolucao;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public Garantia getGarantia() {
    return garantia;
  }

  public void setGarantia(Garantia garantia) {
    this.garantia = garantia;
  }

  public Embalagem getEmbalagem() {
    return embalagem;
  }

  public void setEmbalagem(Embalagem embalagem) {
    this.embalagem = embalagem;
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

  public Unidade getUnidade() {
    return unidade;
  }

  public void setUnidade(Unidade unidade) {
    this.unidade = unidade;
  }

  public Date getDatacadastro() {
    return datacadastro;
  }

  public void setDatacadastro(Date datacadastro) {
    this.datacadastro = datacadastro;
  }

  public Date getFabricacao() {
    return fabricacao;
  }

  public void setFabricacao(Date fabricacao) {
    this.fabricacao = fabricacao;
  }

  public Date getVencimento() {
    return vencimento;
  }

  public void setVencimento(Date vencimento) {
    this.vencimento = vencimento;
  }

  public List<Grupo> getGrupos() {
    return grupos;
  }

  public void setGrupos(List<Grupo> grupos) {
    this.grupos = grupos;
  }

  public List<Cor> getCors() {
    return cors;
  }

  public void setCors(List<Cor> cors) {
    this.cors = cors;
  }

  public List<Marca> getMarcas() {
    return marcas;
  }

  public void setMarcas(List<Marca> marcas) {
    this.marcas = marcas;
  }

  public List<Embalagem> getEmbalagems() {
    return embalagems;
  }

  public void setEmbalagems(List<Embalagem> embalagems) {
    this.embalagems = embalagems;
  }

  public List<Tamanho> getTamanhos() {
    return tamanhos;
  }

  public void setTamanhos(List<Tamanho> tamanhos) {
    this.tamanhos = tamanhos;
  }

  public List<Devolucao> getDevolucaos() {
    return devolucaos;
  }

  public void setDevolucaos(List<Devolucao> devolucaos) {
    this.devolucaos = devolucaos;
  }

  public List<Tipo> getTipos() {
    return tipos;
  }

  public void setTipos(List<Tipo> tipos) {
    this.tipos = tipos;
  }

  public List<Garantia> getGarantias() {
    return garantias;
  }

  public void setGarantias(List<Garantia> garantias) {
    this.garantias = garantias;
  }

  public List<Unidade> getUnidades() {
    return unidades;
  }

  public void setUnidades(List<Unidade> unidades) {
    this.unidades = unidades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Produto)) return false;
    Produto produto = (Produto) o;
    return Objects.equals(get_id(), produto.get_id()) &&
            Objects.equals(getUuid(), produto.getUuid()) &&
            Objects.equals(getDescricao(), produto.getDescricao()) &&
            Objects.equals(getPreco(), produto.getPreco()) &&
            Objects.equals(getDurabilidade(), produto.getDurabilidade()) &&
            Objects.equals(getPeso(), produto.getPeso()) &&
            Objects.equals(getRotulagem(), produto.getRotulagem()) &&
            Objects.equals(getStatus(), produto.getStatus()) &&
            Objects.equals(getAltura(), produto.getAltura()) &&
            Objects.equals(getLargura(), produto.getLargura()) &&
            Objects.equals(getFormato(), produto.getFormato()) &&
            Objects.equals(getEstilo(), produto.getEstilo()) &&
            Objects.equals(getQualidade(), produto.getQualidade()) &&
            Objects.equals(getTamanho(), produto.getTamanho()) &&
            Objects.equals(getDevolucao(), produto.getDevolucao()) &&
            Objects.equals(getTipo(), produto.getTipo()) &&
            Objects.equals(getGarantia(), produto.getGarantia()) &&
            Objects.equals(getEmbalagem(), produto.getEmbalagem()) &&
            Objects.equals(getGrupo(), produto.getGrupo()) &&
            Objects.equals(getCor(), produto.getCor()) &&
            Objects.equals(getMarca(), produto.getMarca()) &&
            Objects.equals(getImagem(), produto.getImagem()) &&
            Objects.equals(getUnidade(), produto.getUnidade()) &&
            Objects.equals(getDatacadastro(), produto.getDatacadastro()) &&
            Objects.equals(getFabricacao(), produto.getFabricacao()) &&
            Objects.equals(getVencimento(), produto.getVencimento()) &&
            Objects.equals(getGrupos(), produto.getGrupos()) &&
            Objects.equals(getCors(), produto.getCors()) &&
            Objects.equals(getMarcas(), produto.getMarcas()) &&
            Objects.equals(getEmbalagems(), produto.getEmbalagems()) &&
            Objects.equals(getTamanhos(), produto.getTamanhos()) &&
            Objects.equals(getDevolucaos(), produto.getDevolucaos()) &&
            Objects.equals(getTipos(), produto.getTipos()) &&
            Objects.equals(getGarantias(), produto.getGarantias()) &&
            Objects.equals(getUnidades(), produto.getUnidades());
  }

  @Override
  public int hashCode() {
    return Objects.hash(get_id(), getUuid(), getDescricao(), getPreco(), getDurabilidade(), getPeso(), getRotulagem(), getStatus(), getAltura(), getLargura(), getFormato(), getEstilo(), getQualidade(), getTamanho(), getDevolucao(), getTipo(), getGarantia(), getEmbalagem(), getGrupo(), getCor(), getMarca(), getImagem(), getUnidade(), getDatacadastro(), getFabricacao(), getVencimento(), getGrupos(), getCors(), getMarcas(), getEmbalagems(), getTamanhos(), getDevolucaos(), getTipos(), getGarantias(), getUnidades());
  }

  @Override
  public String toString() {
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    StringBuilder builder = new StringBuilder();
    builder.append(", Codigo: ");
    builder.append(get_id());
    builder.append(", Uuid: ");
    builder.append(getUuid());
    builder.append(", Descricao: ");
    builder.append(getDescricao());
    builder.append(", Preco: ");
    builder.append(nf.format(getPreco()));
    builder.append(", Grupo: ");
    builder.append(getGrupo());
    builder.append(", Cor: ");
    builder.append(getCor());
    builder.append(", Marca: ");
    builder.append(getMarca());
    builder.append(", Data: ");
    builder.append(sdf.format(getDatacadastro()));
    return builder.toString();
  }
}