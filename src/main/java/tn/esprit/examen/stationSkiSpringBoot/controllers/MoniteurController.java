package tn.esprit.examen.stationSkiSpringBoot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.stationSkiSpringBoot.entities.Moniteur;
import tn.esprit.examen.stationSkiSpringBoot.services.IMoniteurService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("moniteur")
@RestController
public class MoniteurController {
    private final IMoniteurService moniteurService;
    @GetMapping("/retrieveAllMoniteurs")
    public List<Moniteur> getmoniteurs(){
        List<Moniteur> moniteur = moniteurService.retrieveAllMoniteurs();
        if(moniteur.isEmpty()){
            return null;
        }else return moniteur;
    }

    @GetMapping("/retrievemoniteur/{numMoniteur}")
    public Moniteur getmoniteurs(@PathVariable("numMoniteur") Long numMoniteur){
        return moniteurService.retrieveMoniteur(numMoniteur);
    }

    @PutMapping("/updateMoniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur){
        return moniteurService.updateMoniteur(moniteur);
    }


    @PostMapping("/addMoniteurs")
    public  Moniteur addMoniteurs(@RequestBody Moniteur moniteur){
        return  moniteurService.addMoniteur(moniteur);
    }
    @PostMapping("/addMoniteurAndAssignToCours/{numCours}")
    public  Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur moniteur,@PathVariable("numCours") Long numCours){
        return moniteurService.addMoniteurAndAssignToCours(moniteur,numCours);
    }
}
