package com.gestion360.erp.repository;

import com.gestion360.erp.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturasRepository extends JpaRepository<Facturas, Long>
{
    
}
