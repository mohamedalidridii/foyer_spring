package org.example.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Universite;
import org.example.tpfoyer.services.IUniversiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universiteController")

@AllArgsConstructor
public class UniversiteController {
    IUniversiteService universiteService;

    @PostMapping("/AddUniversite")
    Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addOrUpdateUniversite(universite);

    }
    @PutMapping("/updateUniversite")
    Universite updateUniversite(@RequestBody Universite universite){
        return universiteService.addOrUpdateUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{idUniversite}/")
    void deleteUniversite(@PathVariable Long idUniversite){
        universiteService.deleteUniversite(idUniversite);
    }
    @GetMapping("/findAllUniversite")
    List<Universite> findAllUniversite(){
        return universiteService.getUniversite();

    }
    @GetMapping("/findById/{idUniversite}")
    Universite findByIdUniversite(@PathVariable Long idUniversite){
        return universiteService.getUniversite(idUniversite);
    }
}
