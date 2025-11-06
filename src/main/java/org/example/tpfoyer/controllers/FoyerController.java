package org.example.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Foyer;
import org.example.tpfoyer.services.IFoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyerController")

@AllArgsConstructor
public class FoyerController {
    IFoyerService foyerService;

    @PostMapping("/AddFoyer")
    Foyer addFoyer(@RequestBody Foyer foyer){
        return foyerService.addOrUpdateFoyer(foyer);

    }
    @PutMapping("/updateFoyer")
    Foyer updateFoyer(@RequestBody Foyer foyer){
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @DeleteMapping("/deleteFoyer/{idFoyer}/")
    void deleteFoyer(@PathVariable Long idFoyer){
        foyerService.deleteFoyer(idFoyer);
    }
    @GetMapping("/findAllFoyer")
    List<Foyer> findAllFoyer(){
        return foyerService.getFoyer();

    }
    @GetMapping("/findById/{idFoyer}")
    Foyer findByIdFoyer(@PathVariable Long idFoyer){
        return foyerService.getFoyer(idFoyer);
    }
}
