package tn.esprit.examen.stationSkiSpringBoot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.stationSkiSpringBoot.entities.Piste;
import tn.esprit.examen.stationSkiSpringBoot.services.IPisteService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("piste")
@RestController
public class PisteRestController {
    private final IPisteService pisteservices;

    @GetMapping("/retrieveAllPistes")
    public List<Piste> getPistes(){
        List<Piste> pistes = pisteservices.retrieveAllPistes();
        if(pistes.isEmpty()){
            return null;
        }else return pistes;
    }

    @GetMapping("/retrievePiste/{numPiste}")
    public Piste getPiste(@PathVariable("numPiste") Long numPiste){
        return pisteservices.retrievePiste(numPiste);
    }

    @PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste piste){
        return pisteservices.updatePiste(piste);
    }

    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste piste){

        return  pisteservices.addPiste(piste);
    }

}
