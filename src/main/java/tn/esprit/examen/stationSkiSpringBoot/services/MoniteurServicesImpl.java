package tn.esprit.examen.stationSkiSpringBoot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.stationSkiSpringBoot.entities.Cours;
import tn.esprit.examen.stationSkiSpringBoot.entities.Moniteur;
import tn.esprit.examen.stationSkiSpringBoot.repositories.CoursRepository;
import tn.esprit.examen.stationSkiSpringBoot.repositories.MoniteurRepository;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class MoniteurServicesImpl implements IMoniteurService {
    private final CoursRepository coursRepository;

    public final MoniteurRepository moniteurRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, Long numCours) {
        Moniteur savedMoniteur = moniteurRepository.save(moniteur);
        Cours cours = coursRepository.findByNumCours(numCours);
        /*savedMoniteur.getCours().add(cours);
        return moniteurRepository.save(savedMoniteur);
        //return moniteur;*/
        cours.setNumCours(numCours);
        moniteurRepository.save(savedMoniteur);
        return savedMoniteur;
        /*   Cours cours = coursRepository.findByNumCours(numCours).orElse(null);
        List<Moniteur> list=new ArrayList<>();
        list.add(moniteur);
        if(cours.getMoniteurs()==null){
            cours.setMoniteurs(list);
        }
        else{
            cours.getMoniteurs().add(moniteur);
        }
        return moniteurRepository.save(moniteur);
    }*/
    }
}
