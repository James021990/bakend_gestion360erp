package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedores;

    @NotBlank(message = "El campo nombre proveedor es obligatorio")
    private String nombre_proveedor;

    @NotBlank(message = "El campo Nit es obligatorio")
    private String nit;

    @NotBlank(message = "El campo telefono es obligatorio")
    private String telefono;

    @NotBlank(message = "El campo correo es obligatorio")
    private String correo;

    @NotBlank(message = "El campo dirección es obligatorio")
    private String direccion;
}
