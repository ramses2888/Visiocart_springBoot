package com.example.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetalleTransaccionPK implements Serializable {

    @Column(name = "id_transaccion")
    private Integer idTransaccion;

    @Column(name = "id_producto")
    private Integer idProducto;

    public DetalleTransaccionPK() {}

    public DetalleTransaccionPK(Integer idTransaccion, Integer idProducto) {
        this.idTransaccion = idTransaccion;
        this.idProducto = idProducto;
    }

    public Integer getIdTransaccion() { return idTransaccion; }
    public void setIdTransaccion(Integer idTransaccion) { this.idTransaccion = idTransaccion; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleTransaccionPK that = (DetalleTransaccionPK) o;
        return Objects.equals(idTransaccion, that.idTransaccion) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaccion, idProducto);
    }
}