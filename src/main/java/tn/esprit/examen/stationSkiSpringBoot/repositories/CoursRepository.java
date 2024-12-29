package tn.esprit.examen.stationSkiSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.stationSkiSpringBoot.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    Cours findByNumCours(Long numCours);

}
