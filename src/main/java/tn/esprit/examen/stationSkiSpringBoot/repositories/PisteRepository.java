package tn.esprit.examen.stationSkiSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.stationSkiSpringBoot.entities.Piste;

public interface PisteRepository extends JpaRepository<Piste, Long> {
    Piste findByNumPiste(Long numPiste);
}