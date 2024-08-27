package org.example.persistencia.init;

import java.util.Arrays;
import java.util.List;

import org.example.persistencia.model.Asignacion;
import org.example.persistencia.model.Bus;
import org.example.persistencia.model.Conductor;
import org.example.persistencia.model.Ruta;
import org.example.persistencia.repository.AsignacionRepository;
import org.example.persistencia.repository.BusRepository;
import org.example.persistencia.repository.ConductorRepository;
import org.example.persistencia.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Override
    public void run(String... args) throws Exception {

        Conductor conductor1 = new Conductor("Juan Pérez", "1234567890", "+123456789", "Calle Falsa 123");
        Conductor conductor2 = new Conductor("María López", "0987654321", "+987654321", "Avenida Siempreviva 742");
        Conductor conductor3 = new Conductor("Carlos García", "1122334455", "+1122334455", "Boulevard de los Sueños 1010");

        List<Conductor> conductores = Arrays.asList(conductor1, conductor2, conductor3);
        conductorRepository.saveAll(conductores);

        Bus bus1 = new Bus("ABC123", "Modelo X");
        Bus bus2 = new Bus("XYZ789", "Modelo Y");
        Bus bus3 = new Bus("LMN456", "Modelo Z");

        List<Bus> buses = Arrays.asList(bus1, bus2, bus3);
        busRepository.saveAll(buses);

        Ruta ruta1 = new Ruta("Ruta Norte");
        Ruta ruta2 = new Ruta("Ruta Sur");

        rutaRepository.saveAll(Arrays.asList(ruta1, ruta2));

        Asignacion asignacion1 = new Asignacion(conductor1, bus1, ruta1, "Lunes a Viernes");
        Asignacion asignacion2 = new Asignacion(conductor2, bus2, ruta2, "Sábado y Domingo");
        Asignacion asignacion3 = new Asignacion(conductor3, bus3, ruta1, "Lunes a Domingo");

        asignacionRepository.saveAll(Arrays.asList(asignacion1, asignacion2, asignacion3));
    }
}
