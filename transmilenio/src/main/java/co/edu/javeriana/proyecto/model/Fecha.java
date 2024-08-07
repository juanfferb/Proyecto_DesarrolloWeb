package co.edu.javeriana.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Fecha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dia;

    @OneToMany (mappedBy = "fechaAsignado")
    private List<Asignacion> AsignacionesFechas = new ArrayList<>();

}

