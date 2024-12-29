package tn.esprit.examen.stationSkiSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.stationSkiSpringBoot.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    Inscription findByNumInscription(Long numInscription);
}
