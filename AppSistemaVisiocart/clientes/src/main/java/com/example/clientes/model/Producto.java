package com.example.clientes.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre", nullable = false, length = 120)
    private String nombre;

    @Column(name = "precio_catalogo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCatalogo;

    @Column(name = "peso_esperado", nullable = false)
    private Float pesoEsperado;

    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;

    public Producto() {}

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecioCatalogo() { return precioCatalogo; }
    public void setPrecioCatalogo(BigDecimal precioCatalogo) { this.precioCatalogo = precioCatalogo; }

    public Float getPesoEsperado() { return pesoEsperado; }
    public void setPesoEsperado(Float pesoEsperado) { this.pesoEsperado = pesoEsperado; }

    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
}