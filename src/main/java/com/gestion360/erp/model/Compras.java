package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;

    private LocalDateTime fecha_compra;

    @NotNull(message = "El campo Total Compra es obligatorio")
    private BigDecimal total_compra;

    @NotBlank(message = "El campo id proveedor es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedor;

    @NotBlank(message = "El campo id usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;
}
