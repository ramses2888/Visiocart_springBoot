package com.example.clientes.controller;

import com.example.clientes.dto.CrearTransaccionDTO;
import com.example.clientes.model.Transaccion;
import com.example.clientes.service.TransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaccion registrar(@RequestBody CrearTransaccionDTO dto) {
        return transaccionService.registrarTransaccion(dto);
    }
}