package org.example.persistencia.controller;

import org.example.persistencia.model.Asignacion;
import org.example.persistencia.model.Bus;
import org.example.persistencia.model.Conductor;
import org.example.persistencia.model.Ruta;
import org.example.persistencia.service.AsignacionService;
import org.example.persistencia.service.BusService;
import org.example.persistencia.service.ConductorService;
import org.example.persistencia.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/asignacion")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private BusService busService;

    @Autowired
    private RutaService rutaService;

    @GetMapping("/view/{id}")
    public String viewAsignacionesByConductor(@PathVariable("id") Long conductorId, Model model) {
        List<Asignacion> asignaciones = asignacionService.getAsignacionesByConductorId(conductorId);
        model.addAttribute("asignaciones", asignaciones);
        return "asignacion-view";
    }

    
    @GetMapping("/create")
    public String crearAsignacion(@RequestParam("conductorId") Long conductorId, Model model) {
        Asignacion asignacion = new Asignacion();
        Conductor conductor = conductorService.recuperarConductor(conductorId); // Asegúrate de que este método existe y funciona
        model.addAttribute("asignacion", asignacion);
        model.addAttribute("conductor", conductor);
        model.addAttribute("buses", busService.listarbuses());
        model.addAttribute("rutas", rutaService.listarrutas());
        model.addAttribute("conductorId", conductorId);
        return "asignacion-create";
    }

    @PostMapping("/create")
    public String createAsignacion(@ModelAttribute @Valid Asignacion asignacion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("buses", busService.listarbuses());
            model.addAttribute("rutas", rutaService.listarrutas());
            return "asignacion-create";
        }

        // Convertir el arreglo de checkboxes seleccionados en un string separado por comas
        String diasSeleccionados = String.join(", ", asignacion.getDiasAsignacion());
        asignacion.setDiasAsignacion(diasSeleccionados);

        // Validar que no haya cruce de días para el mismo conductor
        if (asignacionService.existeConflictoDias(asignacion)) {
            result.rejectValue("diasAsignacion", "error.asignacion", "Los días de asignación no deben cruzarse para el mismo conductor.");
            return "asignacion-create";
        }

        // Validar que el bus no esté asignado a otro conductor en los mismos días
        if (asignacionService.existeConflictoBus(asignacion)) {
            result.rejectValue("bus", "error.asignacion", "El bus ya está asignado a otro conductor en los mismos días.");
            return "asignacion-create";
        }

        // Guardar la asignación
        asignacionService.crearAsignacion(asignacion);

        return "redirect:/asignacion/view/" + asignacion.getConductor().getId();
    }





    @PostMapping("/delete/{id}")
    public RedirectView eliminarAsignacion(@PathVariable("id") Long id) {
        asignacionService.eliminarAsignacion(id);
        return new RedirectView("/asignacion/view/");
    }

}
