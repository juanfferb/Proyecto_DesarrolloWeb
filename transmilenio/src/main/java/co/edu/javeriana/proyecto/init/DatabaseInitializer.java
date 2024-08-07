package co.edu.javeriana.proyecto.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.edu.javeriana.proyecto.model.Bus;
import co.edu.javeriana.proyecto.model.Conductor;
import co.edu.javeriana.proyecto.repository.ConductorRepository;
import co.edu.javeriana.proyecto.repository.BusRepository;


@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private BusRepository busRepository;

    @Override
    public void run(String... args) throws Exception {
        Conductor conductor = conductorRepository.save(new Conductor(null, "Alice", "1234", "31124567", "Colina", null));

        Bus bus = busRepository.save(new Bus(null, "ABC123", "Volvo", null));
        Bus bus2 = busRepository.save(new Bus(null, "DEF456", "Kia", null));
        

    }

}
