package org.example.persistencia.service;

import org.example.persistencia.model.Asignacion;
import org.example.persistencia.repository.AsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<Asignacion> getAsignacionesByConductorId(Long conductorId) {
        return asignacionRepository.findAsignacionesByConductorId(conductorId);
    }
}
