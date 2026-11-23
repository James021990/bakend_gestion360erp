package com.gestion360.erp.service;

import com.gestion360.erp.model.DetalleFactura;
import com.gestion360.erp.model.Facturas;
import com.gestion360.erp.model.Productos;
import com.gestion360.erp.repository.DetalleFacturaRepository;
import com.gestion360.erp.repository.FacturasRepository;
import com.gestion360.erp.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    private FacturasRepository facturasRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<DetalleFactura> listarTodas() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public Optional<DetalleFactura> buscarPorId(Long id) {
        return detalleFacturaRepository.findById(id);
    }

    @Override
    public DetalleFactura guardar(DetalleFactura detalle) {
        if (detalle.getFactura() != null && detalle.getFactura().getId_factura() != null) {
            Facturas facturaReal = facturasRepository.findById(detalle.getFactura().getId_factura())
                    .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
            detalle.setFactura(facturaReal);
        } else {
            throw new RuntimeException("Debe indicar una factura válida");
        }

        if (detalle.getProducto() != null && detalle.getProducto().getId_productos() != null) {
            Productos productoReal = productosRepository.findById(detalle.getProducto().getId_productos())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            detalle.setProducto(productoReal);
        } else {
            throw new RuntimeException("Debe indicar un producto válido");
        }

        return detalleFacturaRepository.save(detalle);
    }

    @Override
    public void borrar(Long id) {
        detalleFacturaRepository.deleteById(id);
    }
}
