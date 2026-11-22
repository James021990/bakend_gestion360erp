package com.gestion360.erp.repository;

import com.gestion360.erp.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>
{
    Optional<Usuarios> findByCorreo(String correo);
}
