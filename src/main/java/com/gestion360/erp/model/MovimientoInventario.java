package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_inventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_movimiento_inventario;

    @NotBlank(message = "El campo tipo movimiento es obligatorio")
    private String tipo_movimiento;

    @NotNull(message = "El campo cantidad es obligatorio")
    private Integer cantidad;

    @NotBlank(message = "El campo motivo es obligatorio")
    private String motivo;

    private LocalDateTime fecha;

    @NotBlank(message = "El campo id producto es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;

    @PrePersist
    protected void prePersist() {
        this.fecha = LocalDateTime.now();
    }
}
