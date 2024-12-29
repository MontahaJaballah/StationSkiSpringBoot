package tn.esprit.examen.stationSkiSpringBoot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.stationSkiSpringBoot.entities.Abonnement;
import tn.esprit.examen.stationSkiSpringBoot.entities.Skieur;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;
import tn.esprit.examen.stationSkiSpringBoot.repositories.AbonnementRepository;
import tn.esprit.examen.stationSkiSpringBoot.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Slf4j
@RequiredArgsConstructor
@Service
public class AbonnementServiceImpl implements IAbonnementService{
    private final SkieurRepository skieurRepository;
    private final AbonnementRepository abonnementRepository;

    @Override
    public Set<Abonnement> getAbonnementByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAbon(type);
    }

    @Override
    public List<Abonnement> retrieveAbonnementByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.getAbonnementsByDateDebutBetween(startDate, endDate);
    }

  // @Override
//   @Scheduled(cron = "*/30 * * * * *")
  /*  public void retrieveAbonnements() {
    LocalDate today = LocalDate.now();
    LocalDate dateExpiration = today.plusDays(7);
    log.info("date d'expiration : "+dateExpiration);
    for (Abonnement abonnement: abonnementRepository.findDistinctOrderByDateFinAsc(dateExpiration)) {
        Skieur s = skieurRepository.findByAbonnement(abonnement);
        log.info("num abonnement : "+abonnement.getNumAbon().toString() + " | date fin Abonnement :"+ abonnement.getDateFin().toString()
                + " |num skieur : "+ s.getNumSkieur()     + " | prenom :"+ s.getPrenomS() + "|nom:  " + s.getNomS());
        }
    }*/

}
