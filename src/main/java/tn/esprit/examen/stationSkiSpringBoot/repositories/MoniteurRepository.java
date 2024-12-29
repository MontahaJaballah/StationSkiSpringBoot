package tn.esprit.examen.stationSkiSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.stationSkiSpringBoot.entities.Moniteur;

public interface MoniteurRepository  extends JpaRepository<Moniteur, Long> {
}
