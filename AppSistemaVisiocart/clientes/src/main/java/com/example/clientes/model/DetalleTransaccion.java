package com.example.clientes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DETALLE_TRANSACCION")
public class DetalleTransaccion {

    @EmbeddedId
    private DetalleTransaccionPK id = new DetalleTransaccionPK();

    @JsonIgnore // <-- OBLIGATORIO: Evita el bucle infinito al generar el JSON
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idTransaccion")
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_venta_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVentaUnitario;

    public DetalleTransaccion() {}

    // Getters y Setters
    public DetalleTransaccionPK getId() { return id; }
    public void setId(DetalleTransaccionPK id) { this.id = id; }

    public Transaccion getTransaccion() { return transaccion; }
    public void setTransaccion(Transaccion transaccion) { this.transaccion = transaccion; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioVentaUnitario() { return precioVentaUnitario; }
    public void setPrecioVentaUnitario(BigDecimal precioVentaUnitario) { this.precioVentaUnitario = precioVentaUnitario; }
}