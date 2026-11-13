package com.gestion360.erp.service;

import com.gestion360.erp.model.ConfiguracionEmpresa;
import com.gestion360.erp.repository.ConfiguracionEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracionEmpresaServiceImpl implements IConfiguracionEmpresa {

    @Autowired
    private ConfiguracionEmpresaRepository configuracionEmpresaRepository;

    @Override
    public List<ConfiguracionEmpresa> listarTodos() {
        return configuracionEmpresaRepository.findAll();
    }

    @Override
    public Optional<ConfiguracionEmpresa> buscarPorId(Long id) {
        return configuracionEmpresaRepository.findById(id);
    }

    @Override
    public ConfiguracionEmpresa guardar(ConfiguracionEmpresa configuracionEmpresa) {
        return configuracionEmpresaRepository.save(configuracionEmpresa);
    }

    @Override
    public void borrar(Long id) {
        configuracionEmpresaRepository.deleteById(id);

    }
}
