package co.edu.javeriana.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.proyecto.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
