package tn.esprit.examen.stationSkiSpringBoot.services;

import tn.esprit.examen.stationSkiSpringBoot.entities.Abonnement;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    Set<Abonnement> getAbonnementByType(TypeAbonnement type);

    List<Abonnement> retrieveAbonnementByDates(LocalDate startDate, LocalDate endDate);
    //void retrieveAbonnements();
}
