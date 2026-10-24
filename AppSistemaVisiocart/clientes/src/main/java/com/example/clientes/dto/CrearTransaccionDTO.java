package com.example.clientes.dto;

import java.util.List;

public class CrearTransaccionDTO {
    private Integer idCliente;
    private Integer idEmpleado;
    private List<DetalleItemRequestDTO> items;

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public List<DetalleItemRequestDTO> getItems() { return items; }
    public void setItems(List<DetalleItemRequestDTO> items) { this.items = items; }
}