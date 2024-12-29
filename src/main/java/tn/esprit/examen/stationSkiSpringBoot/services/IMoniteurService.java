package tn.esprit.examen.stationSkiSpringBoot.services;

import tn.esprit.examen.stationSkiSpringBoot.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);
    Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, Long numCours);
}
