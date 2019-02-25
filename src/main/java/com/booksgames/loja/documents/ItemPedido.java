package com.booksgames.loja.documents;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "itempedido")
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;

    private Double desconto;
    private Integer quantidade;
    private Double preco;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        this.setPedido(pedido);
        this.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String get_id( ) {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Pedido getPedido( ) {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto( ) {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getSubTotal() {
        return (preco - desconto) * quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;

        ItemPedido that = (ItemPedido) o;

        if (!get_id().equals( that.get_id() )) return false;
        if (!getDesconto().equals( that.getDesconto() )) return false;
        if (!getQuantidade().equals( that.getQuantidade() )) return false;
        if (!getPreco().equals( that.getPreco() )) return false;
        if (!getPedido().equals( that.getPedido() )) return false;
        return getProduto().equals( that.getProduto() );
    }

    @Override
    public int hashCode( ) {
        int result = get_id().hashCode();
        result = 31 * result + getDesconto().hashCode();
        result = 31 * result + getQuantidade().hashCode();
        result = 31 * result + getPreco().hashCode();
        result = 31 * result + getPedido().hashCode();
        result = 31 * result + getProduto().hashCode();
        return result;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        StringBuilder builder = new StringBuilder();
        builder.append(getProduto().getDescricao());
        builder.append(", Qte: ");
        builder.append(getQuantidade());
        builder.append(", Preço unitário: ");
        builder.append(nf.format(getPreco()));
        builder.append(", Subtotal: ");
        builder.append(nf.format(getSubTotal()));
        builder.append("\n");
        return builder.toString();
    }
}
