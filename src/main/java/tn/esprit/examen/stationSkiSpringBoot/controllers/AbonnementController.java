package tn.esprit.examen.stationSkiSpringBoot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.examen.stationSkiSpringBoot.entities.Abonnement;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;
import tn.esprit.examen.stationSkiSpringBoot.services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("abonnement")
@RestController
public class AbonnementController {
   private final IAbonnementService abonnementService;

    @GetMapping("/retrieveAllAbonnementByTypeAbon/{typeAbon}")
    Set<Abonnement> getAbonnementByTypeAbon(@PathVariable("typeAbon") TypeAbonnement typeAbon) {
       return abonnementService.getAbonnementByType(typeAbon);
           }

    @GetMapping("/getAbonnementsByDates/{date1}/{date2}")
    public List<Abonnement> getAbonnementsByDates(
            @PathVariable("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return abonnementService.retrieveAbonnementByDates(startDate, endDate);
    }

}
