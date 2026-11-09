package com.gestion360.erp.repository;

import com.gestion360.erp.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long>
{
    
}
