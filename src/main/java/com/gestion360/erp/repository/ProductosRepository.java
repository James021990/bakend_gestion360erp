package com.gestion360.erp.repository;

import com.gestion360.erp.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long>
{
    
}
