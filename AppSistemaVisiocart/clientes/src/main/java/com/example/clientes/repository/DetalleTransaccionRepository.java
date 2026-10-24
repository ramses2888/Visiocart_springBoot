package com.example.clientes.repository;

import com.example.clientes.model.DetalleTransaccion;
import com.example.clientes.model.DetalleTransaccionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleTransaccionRepository extends JpaRepository<DetalleTransaccion, DetalleTransaccionPK> {
}