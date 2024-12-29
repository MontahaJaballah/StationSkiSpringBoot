package tn.esprit.examen.stationSkiSpringBoot.services;

import tn.esprit.examen.stationSkiSpringBoot.entities.Skieur;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);
    Skieur addSkieurAndAssignToCours(Skieur skieur, Long numCours);
    List<Skieur> retrieveSkieursByTypeAbon(TypeAbonnement typeAbon);
}
