package co.edu.javeriana.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.proyecto.model.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    
    
} 
