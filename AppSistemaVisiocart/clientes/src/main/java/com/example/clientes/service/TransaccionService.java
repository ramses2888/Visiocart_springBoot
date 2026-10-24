package com.example.clientes.service;

import com.example.clientes.dto.CrearTransaccionDTO;
import com.example.clientes.dto.DetalleItemRequestDTO;
import com.example.clientes.model.DetalleTransaccion;
import com.example.clientes.model.Producto;
import com.example.clientes.model.Transaccion;
import com.example.clientes.repository.ProductoRepository;
import com.example.clientes.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final ProductoRepository productoRepository;

    public TransaccionService(TransaccionRepository transaccionRepository, ProductoRepository productoRepository) {
        this.transaccionRepository = transaccionRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public Transaccion registrarTransaccion(CrearTransaccionDTO dto) {
        Transaccion transaccion = new Transaccion();
        transaccion.setFecha(LocalDateTime.now());
        transaccion.setIdCliente(dto.getIdCliente());
        transaccion.setIdEmpleado(dto.getIdEmpleado());

        BigDecimal totalCalculado = BigDecimal.ZERO;

        for (DetalleItemRequestDTO item : dto.getItems()) {
            Producto producto = productoRepository.findById(item.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + item.getIdProducto()));

            BigDecimal subtotal = producto.getPrecioCatalogo().multiply(BigDecimal.valueOf(item.getCantidad()));
            totalCalculado = totalCalculado.add(subtotal);

            DetalleTransaccion detalle = new DetalleTransaccion();
            detalle.setTransaccion(transaccion);
            detalle.setProducto(producto);
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioVentaUnitario(producto.getPrecioCatalogo());

            transaccion.getDetalles().add(detalle);
        }

        transaccion.setTotalNeto(totalCalculado);
        return transaccionRepository.save(transaccion);
    }
}