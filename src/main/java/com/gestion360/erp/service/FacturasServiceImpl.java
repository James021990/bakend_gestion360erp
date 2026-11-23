package com.gestion360.erp.service;

import com.gestion360.erp.model.Clientes;
import com.gestion360.erp.model.Facturas;
import com.gestion360.erp.model.Usuarios;
import com.gestion360.erp.repository.ClientesRepository;
import com.gestion360.erp.repository.FacturasRepository;
import com.gestion360.erp.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasServiceImpl implements IFacturasService {

    @Autowired
    private FacturasRepository facturasRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Facturas> listarTodas() {
        return facturasRepository.findAll();
    }

    @Override
    public Optional<Facturas> buscarPorId(Long id) {
        return facturasRepository.findById(id);
    }

    @Override
    public Facturas guardar(Facturas factura) {
        if (factura.getCliente() != null && factura.getCliente().getId_clientes()!= null) {
            Clientes clienteReal = clientesRepository.findById(factura.getCliente().getId_clientes())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            factura.setCliente(clienteReal);
        } else {
            throw new RuntimeException("Debe indicar un cliente válido");
        }

        if (factura.getUsuario() != null && factura.getUsuario().getId_usuario() != null) {
            Usuarios usuarioReal = usuariosRepository.findById(factura.getUsuario().getId_usuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            factura.setUsuario(usuarioReal);
        } else {
            throw new RuntimeException("Debe indicar un usuario válido");
        }

        return facturasRepository.save(factura);
    }

    @Override
    public void borrar(Long id) {
        facturasRepository.deleteById(id);
    }
}
