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

  @DBRef(lazy = true)
  private List<Grupo> grupos = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Cor> cors = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Marca> marcas = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Embalagem> embalagems = new ArrayList<>();
  
  // Constructors
   public Produto(String _id, UUID uuid, String descricao, Double preco, Embalagem embalagem,
                  String durabilidade, Double peso, String rotulagem, String status,
                  Grupo grupo, Cor cor, Marca marca, GridFS imagem, Date datacadastro) {
    this._id = _id;
    this.uuid = uuid;
    this.descricao = descricao;
    this.preco = preco;
    this.embalagem = embalagem;
    this.durabilidade = durabilidade;
    this.peso = peso;
    this.rotulagem = rotulagem;
    this.status =  status;
    this.grupo = grupo;
    this.cor = cor;
    this.marca = marca;
    this.imagem = imagem;
    this.datacadastro = datacadastro;
    this.grupos = grupos;
    this.cors = cors;
    this.marcas = marcas;
    this.embalagems = embalagems;
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
            Objects.equals(getEmbalagem(), produto.getEmbalagem()) &&
            Objects.equals(getDurabilidade(), produto.getDurabilidade()) &&
            Objects.equals(getPeso(), produto.getPeso()) &&
            Objects.equals(getRotulagem(), produto.getRotulagem()) &&
            Objects.equals(getStatus(), produto.getStatus()) &&
            Objects.equals(getGrupo(), produto.getGrupo()) &&
            Objects.equals(getCor(), produto.getCor()) &&
            Objects.equals(getMarca(), produto.getMarca()) &&
            Objects.equals(getImagem(), produto.getImagem()) &&
            Objects.equals(getDatacadastro(), produto.getDatacadastro()) &&
            Objects.equals(getGrupos(), produto.getGrupos()) &&
            Objects.equals(getCors(), produto.getCors()) &&
            Objects.equals(getMarcas(), produto.getMarcas()) &&
            Objects.equals(getEmbalagems(), produto.getEmbalagems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(get_id(), getUuid(), getDescricao(), getPreco(), getEmbalagem(), getDurabilidade(), getPeso(), getRotulagem(), getStatus(), getGrupo(), getCor(), getMarca(), getImagem(), getDatacadastro(), getGrupos(), getCors(), getMarcas(), getEmbalagems());
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