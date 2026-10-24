package com.example.clientes.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRANSACCION")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Integer idTransaccion;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "total_neto", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalNeto;

    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @OneToMany(mappedBy = "transaccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleTransaccion> detalles = new ArrayList<>();

    public Transaccion() {}

    public Integer getIdTransaccion() { return idTransaccion; }
    public void setIdTransaccion(Integer idTransaccion) { this.idTransaccion = idTransaccion; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getTotalNeto() { return totalNeto; }
    public void setTotalNeto(BigDecimal totalNeto) { this.totalNeto = totalNeto; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public List<DetalleTransaccion> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleTransaccion> detalles) { this.detalles = detalles; }
}