package tn.esprit.examen.stationSkiSpringBoot.services;

import tn.esprit.examen.stationSkiSpringBoot.entities.Inscription;

public interface IInscriptionService {
    Inscription addInscription(Inscription inscription);

    Inscription assignInscriptionToCours(Long numInscription, Long numCours);
    Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscription, Long
            numSkieur, Long numCours);
}
