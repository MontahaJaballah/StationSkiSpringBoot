package tn.esprit.examen.stationSkiSpringBoot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.stationSkiSpringBoot.entities.Skieur;
import tn.esprit.examen.stationSkiSpringBoot.entities.TypeAbonnement;
import tn.esprit.examen.stationSkiSpringBoot.services.ISkieurService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("skieur")
@RestController
public class SkieurController {
    private final ISkieurService skieurService;
    @GetMapping("/retrieveAllSkieurs")
    public List<Skieur> getSkieurs(){
        List<Skieur> skieurs = skieurService.retrieveAllSkieurs();
        if(skieurs.isEmpty()){
            return null;
        }else return skieurs;
    }
    @PostMapping("/addSkieurs")
    public  Skieur addSkieur(@RequestBody Skieur skieur){
        return  skieurService.addSkieur(skieur);
    }
    @DeleteMapping("/remove-skieurs/{numSkieur}")
    public void removeSkieur(@PathVariable("numSkieur") Long numSkieur){
        skieurService.removeSkieur(numSkieur);
    }
    @GetMapping("/retrieveSkieur/{numSkieur}")
    public Skieur getSkieurs(@PathVariable("numSkieur") Long numSkieur){
        return skieurService.retrieveSkieur(numSkieur);
    }
    @PostMapping("/assign-skieur/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur") Long numSkieur, @PathVariable("numPiste") Long numPiste){
        return skieurService.assignSkieurToPiste(numSkieur, numPiste);
    }

    @PostMapping("/addSkieurAndAssignToCours/{numCours}")
    public Skieur addSkieurAndAssignToCours(@RequestBody Skieur skieur, @PathVariable("numCours") Long numCours){
        return skieurService.addSkieurAndAssignToCours(skieur,numCours);
        //return s;
    }

    @GetMapping("/retrieveSkieursByTypeAbonnement/{typeAbon}")
    public List<Skieur> retrieveSkieursByTypeAbon(@PathVariable("typeAbon") TypeAbonnement typeAbon){
        List<Skieur> skieurs = skieurService.retrieveSkieursByTypeAbon(typeAbon);
        return skieurs;
    }

}
