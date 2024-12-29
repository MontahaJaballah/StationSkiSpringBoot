package tn.esprit.examen.stationSkiSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examen.stationSkiSpringBoot.entities.Abonnement;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbon);
    List<Abonnement> getAbonnementsByDateDebutBetween(LocalDate date1, LocalDate date2);


}