package com.gestion360.erp.service;

import com.gestion360.erp.model.Clientes;
import com.gestion360.erp.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServiceImpl implements IClientesService{

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public List<Clientes> listarTodos() {
        return clientesRepository.findAll();
    }

    @Override
    public Optional<Clientes> buscarPorId(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Clientes guardar(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    @Override
    public void borrar(Long id) {
        clientesRepository.deleteById(id);
    }
}
