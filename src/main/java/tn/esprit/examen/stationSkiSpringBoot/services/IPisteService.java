package tn.esprit.examen.stationSkiSpringBoot.services;

import tn.esprit.examen.stationSkiSpringBoot.entities.Piste;

import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    List<Piste> retrieveAllPistes();
    Piste updatePiste (Piste piste);
    Piste retrievePiste (Long numPiste);
    void test();
}
