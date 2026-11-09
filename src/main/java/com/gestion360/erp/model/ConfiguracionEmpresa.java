package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "configuracion_empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_configuracion_empresa;

    @NotBlank(message = "El campo razón social es obligatorio")
    private String razon_social;

    @NotBlank(message = "El campo Nit es obligatorio")
    private String nit;

    @NotBlank(message = "El campo Resolución DIAN es obligatorio")
    private String resolucion_dian;

    @NotBlank(message = "El campo consecutivo factura es obligatorio")
    private String consecutivo_factura;
}
