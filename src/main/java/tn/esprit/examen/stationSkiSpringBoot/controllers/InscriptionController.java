package tn.esprit.examen.stationSkiSpringBoot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.stationSkiSpringBoot.entities.Inscription;
import tn.esprit.examen.stationSkiSpringBoot.services.IInscriptionService;

@RequiredArgsConstructor
@RequestMapping("inscriptions")
@RestController
public class InscriptionController {
    private final IInscriptionService inscriptionService;
    @PostMapping("/addInscription")
    public Inscription addInscription(@RequestBody Inscription inscription){
        return inscriptionService.addInscription(inscription);

    }
   @PostMapping("/assignInscriptionToCours/{numInscription}/{numCours}")
    public Inscription assignInscriptionToCours(@PathVariable("numInscription") Long numInscription,@PathVariable("numCours") Long numCours)
    {
        return inscriptionService.assignInscriptionToCours(numInscription,numCours);
    }

    @PostMapping("/addInscriptionAndAssignToSkieurAndCours/{numSkieur}/{numCours}")
    public Inscription addInscriptionAndAssignToSkieurAndCours(@RequestBody Inscription inscription,@PathVariable("numSkieur") Long numSkieur,@PathVariable("numCours") Long numCours)
    {
        return inscriptionService.addInscriptionAndAssignToSkieurAndCours(inscription,numSkieur,numCours);
    }

}
