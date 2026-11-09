package com.gestion360.erp.repository;

import com.gestion360.erp.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>
{

}
