package com.booksgames.loja.documents;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.booksgames.loja.documents.enums.EstadoPagamento;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "pagamentocomboleto")
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(String _id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(_id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
