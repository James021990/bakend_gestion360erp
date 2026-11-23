package com.gestion360.erp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_factura;

    @NotNull(message = "El campo cantidad es obligatorio")
    private Integer cantidad;

    @NotNull(message = "El campo precio unitario es obligatorio")
    private BigDecimal precio;

    @NotNull(message = "El campo subtotal lineal es obligatorio")
    private BigDecimal subtotal_lineal;

    @NotNull(message = "El campo id factura es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_factura")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Facturas factura;

    @NotNull(message = "El campo id producto es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Productos producto;
}
