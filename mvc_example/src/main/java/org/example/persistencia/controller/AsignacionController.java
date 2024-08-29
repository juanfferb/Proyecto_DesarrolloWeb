package org.example.persistencia.controller;

import org.example.persistencia.model.Asignacion;
import org.example.persistencia.model.Conductor;
import org.example.persistencia.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping(value = "/create")
    public Object nuevoConductor(@Valid Asignacion asignacion, BindingResult result) {
    if (result.hasErrors()) {
        return new ModelAndView("asignacion-create");
    }
    asignacionService.crearAsignacion(asignacion);
    return new RedirectView("/asignacion/view");
    }

    @PostMapping(value = "/create")
    public Object crearConductor(@Valid Asignacion asignacion, BindingResult result) {
    if (result.hasErrors()) {
        return new ModelAndView("asignacion-create");
    }
    asignacionService.crearAsignacion(asignacion);
    return new RedirectView("/asignacion/view");
    }
}
