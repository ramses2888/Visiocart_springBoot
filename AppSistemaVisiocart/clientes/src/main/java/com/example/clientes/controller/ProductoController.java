package com.example.clientes.controller;

import com.example.clientes.model.Producto;
import com.example.clientes.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // 1. READ ALL (GET)
    @GetMapping
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    // 2. READ BY ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREATE (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // 4. UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto productoDetalles) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoDetalles.getNombre());
                    producto.setPrecioCatalogo(productoDetalles.getPrecioCatalogo());
                    producto.setPesoEsperado(productoDetalles.getPesoEsperado());
                    producto.setIdCategoria(productoDetalles.getIdCategoria());
                    Producto actualizado = productoRepository.save(producto);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}