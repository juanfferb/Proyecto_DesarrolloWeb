package org.example.persistencia.controller;

import org.example.persistencia.model.Asignacion;
import org.example.persistencia.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequestMapping("/asignacion")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping("/view/{id}")
    public String viewAsignacionesByConductor(@PathVariable("id") Long conductorId, Model model) {
        List<Asignacion> asignaciones = asignacionService.getAsignacionesByConductorId(conductorId);
        model.addAttribute("asignaciones", asignaciones);
        return "asignacion-view"; // Nombre de la vista Thymeleaf para mostrar las asignaciones
    }
}
