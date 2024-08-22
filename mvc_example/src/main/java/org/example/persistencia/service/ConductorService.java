package org.example.persistencia.service;

import java.util.List;

import org.example.persistencia.model.Conductor;
import org.example.persistencia.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    public List<Conductor> listarconductores() {
        return conductorRepository.findAll();
    }

    public Conductor recuperarConductor(Long id) {
        return conductorRepository.findById(id).orElseThrow();
    }

    public void guardarConductor(Conductor conductor) {
        conductorRepository.save(conductor);
    }

    public List<Conductor> buscarPorNombre(String textoBusqueda) {
        return conductorRepository.findAllByNombreStartingWith(textoBusqueda);
    }

}
