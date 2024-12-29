package tn.esprit.examen.stationSkiSpringBoot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.stationSkiSpringBoot.entities.Cours;
import tn.esprit.examen.stationSkiSpringBoot.repositories.CoursRepository;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class CoursServicesImpl implements ICoursService {
    private final CoursRepository coursRepository;
    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }
}
