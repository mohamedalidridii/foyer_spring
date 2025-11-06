package org.example.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Chambre;
import org.example.tpfoyer.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambreController")
public class ChambreController {
    @Autowired
    IChambreService chambreService;

    @PostMapping("/AddChambre")
    Chambre addChambre(@RequestBody Chambre chambre){
        return chambreService.addOrUpdateChambre(chambre);

    }
    @PutMapping("/updateChambre")
    Chambre updateChambre(@RequestBody Chambre chambre){
        return chambreService.addOrUpdateChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{idChambre}/")
    void deleteChambre(@PathVariable Long idChambre){
        chambreService.deleteChambre(idChambre);
    }
    @GetMapping("/findAllChambre")
    List<Chambre> findAllChambre(){
        return chambreService.getChambre();

    }
    @GetMapping("/findById/{idChambre}")
    Chambre findByIdChambre(@PathVariable Long idChambre){
        return chambreService.getChambre(idChambre);
    }
}
