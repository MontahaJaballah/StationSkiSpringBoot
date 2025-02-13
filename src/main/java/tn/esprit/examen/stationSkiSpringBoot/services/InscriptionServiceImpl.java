package tn.esprit.examen.stationSkiSpringBoot.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.stationSkiSpringBoot.configs.UtilityFonction;
import tn.esprit.examen.stationSkiSpringBoot.entities.Cours;
import tn.esprit.examen.stationSkiSpringBoot.entities.Inscription;
import tn.esprit.examen.stationSkiSpringBoot.entities.Skieur;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeCours;
import tn.esprit.examen.stationSkiSpringBoot.repositories.CoursRepository;
import tn.esprit.examen.stationSkiSpringBoot.repositories.InscriptionRepository;
import tn.esprit.examen.stationSkiSpringBoot.repositories.SkieurRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class InscriptionServiceImpl implements IInscriptionService {
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }
    @Override
    public Inscription assignInscriptionToCours(Long numInscription, Long numCours) {
        Inscription inscription = inscriptionRepository.findByNumInscription(numInscription);
        Cours cours = coursRepository.findByNumCours(numCours);
        inscription.setCours(cours);
        inscriptionRepository.save(inscription);
        return inscription;

    }

  //  @Override
    @Transactional
    public Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur s = skieurRepository.findByNumSkieur(numSkieur);
        Cours c = coursRepository.findByNumCours(numCours);
        int ageSkieur = UtilityFonction.calculateAge(s.getDateNaissance());
        if (c.getTypeCours().equals(TypeCours.COLLECTIF_ENFANT) && ageSkieur < 12) {
            if (c.getInscriptions().size() < 6) {
                inscriptionRepository.save(inscription);
                inscription.setSkieur(s);
                inscription.setCours(c);
            }
        }
        else if (c.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE) && ageSkieur >= 18) {
            if (c.getInscriptions().size() < 6) {
                inscriptionRepository.save(inscription);
                inscription.setSkieur(s);
                inscription.setCours(c);
            }
        }

        return inscription; }

}
