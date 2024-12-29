package tn.esprit.examen.stationSkiSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examen.stationSkiSpringBoot.entities.Abonnement;
import tn.esprit.examen.stationSkiSpringBoot.entities.Skieur;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    Skieur findByNumSkieur(Long numSkieur);
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbon);
  //  Skieur findByAbonnement(Abonnement abonnement);

}
