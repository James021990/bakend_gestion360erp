package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clientes;

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre_o_razon_social;

    @NotBlank(message = "El campo nit es obligatorio")
    private String nit_o_cc;

    @NotBlank(message = "El campo correo es obligatorio")
    private String correo;

    @NotBlank(message = "El campo telefono es obligatorio")
    private String telefono;

    @NotBlank(message = "El campo dirección es obligatorio")
    private String direccion;
}
