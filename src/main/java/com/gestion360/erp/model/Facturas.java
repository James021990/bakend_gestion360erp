package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @NotBlank(message = "El campo numero factura es obligatorio")
    private String numero_factura;

    private LocalDateTime fecha_emision;

    @NotNull(message = "El campo subtotal es obligatorio")
    private BigDecimal subtotal;

    @NotNull(message = "El campo iva es obligatorio")
    private BigDecimal iva;

    @NotNull(message = "El campo Total es obligatorio")
    private BigDecimal total;

    @NotBlank(message = "El campo forma de pago es obligatorio")
    private String forma_pago;

    @NotBlank(message = "El campo estado de la factura es obligatorio")
    private String estado_factura;

    @NotBlank(message = "El campo id_cliente es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @NotBlank(message = "El campo id_usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;
}
