package com.booksgames.loja.documents;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import com.booksgames.loja.documents.enums.EstadoPagamento;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "pagamento")
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    private Integer estado;
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(String _id, EstadoPagamento estado, Pedido pedido) {
        super();
        this._id = _id;
        this.estado = (estado==null) ? null : estado.getCod();
        this.pedido = pedido;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_id == null) ? 0 : _id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (_id == null) {
            if (other._id != null)
                return false;
        } else if (!_id.equals(other._id))
            return false;
        return true;
    }
}
