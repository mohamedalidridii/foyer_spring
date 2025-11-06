package org.example.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Etudiant;
import org.example.tpfoyer.services.IEtudiantService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/etudiantController")

@AllArgsConstructor
public class EtudiantController {
    IEtudiantService etudiantService;

    @PostMapping("/AddEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addOrUpdateEtudiant(etudiant);

    }
    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}/")
    void deleteEtudiant(@PathVariable Long idEtudiant){
        etudiantService.deleteEtudiant(idEtudiant);
    }
    @GetMapping("/findAllEtudiant")
    List<Etudiant> findAllEtudiant(){
        return etudiantService.getEtudiant();

    }
    @GetMapping("/findById/{idEtudiant}")
    Etudiant findByIdEtudiant(@PathVariable Long idEtudiant){
        return etudiantService.getEtudiant(idEtudiant);
    }
}
