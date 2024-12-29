package tn.esprit.examen.stationSkiSpringBoot.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.stationSkiSpringBoot.entities.*;
import tn.esprit.examen.stationSkiSpringBoot.repositories.CoursRepository;
import tn.esprit.examen.stationSkiSpringBoot.repositories.PisteRepository;
import tn.esprit.examen.stationSkiSpringBoot.repositories.SkieurRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class SkieurServiceImpl implements ISkieurService {
    private final CoursRepository coursRepository;
    private final PisteRepository pisteRepository;
    private final SkieurRepository skieurRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
    skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findByNumSkieur(numSkieur);
        Piste piste = pisteRepository.findByNumPiste(numPiste);
        skieur.getPistes().add(piste);
        skieurRepository.save(skieur);
        return skieur;
    }

    @Override
    @Transactional
    public Skieur addSkieurAndAssignToCours(Skieur skieur, Long numCours) {
        Cours cours = coursRepository.findByNumCours(numCours);
        Skieur s = skieurRepository.save(skieur);
        Set<Inscription> inscriptions = new HashSet<>();
        inscriptions.stream().forEach(inscription -> inscription.setCours(cours));
        inscriptions.stream().forEach(inscription -> inscription.setSkieur(s));
        cours.getInscriptions().addAll(inscriptions);
        coursRepository.save(cours);
        return s;
    }

    @Override
    public List<Skieur> retrieveSkieursByTypeAbon(TypeAbonnement typeAbon) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbon);
    }


}
