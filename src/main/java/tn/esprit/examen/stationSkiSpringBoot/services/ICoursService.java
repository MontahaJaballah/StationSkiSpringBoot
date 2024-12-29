package tn.esprit.examen.stationSkiSpringBoot.services;

import tn.esprit.examen.stationSkiSpringBoot.entities.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCourses();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Cours retrieveCours (Long numCours);
}
