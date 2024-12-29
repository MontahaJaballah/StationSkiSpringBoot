package tn.esprit.examen.stationSkiSpringBoot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.stationSkiSpringBoot.entities.Cours;
import tn.esprit.examen.stationSkiSpringBoot.entities.Piste;
import tn.esprit.examen.stationSkiSpringBoot.services.ICoursService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("cours")
@RestController
public class CoursController {
    private final ICoursService courservices;

    @GetMapping("/retrieveAllCours")
    public List<Cours> getcours(){
        List<Cours> cours = courservices.retrieveAllCourses();
        if(cours.isEmpty()){
            return null;
        }else return cours;
    }

    @GetMapping("/retrievecour/{numCours}")
    public Cours getCours(@PathVariable("numCours") Long numCours){
        return courservices.retrieveCours(numCours);
    }

    @PutMapping("/updatecour")
    public Cours updateCours(@RequestBody Cours cours){
        return courservices.updateCours(cours);
    }


    @PostMapping("/addCours")
        public Cours addCours(@RequestBody Cours cours){

        return  courservices.addCours(cours);
    }


}
