package org.example.tpfoyer.controllers;

import org.example.tpfoyer.dto.ChambreDTO;

import org.example.tpfoyer.entities.Chambre;
import org.example.tpfoyer.entities.TypeChambre;
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
    ChambreDTO addChambre(@RequestBody ChambreDTO chambreDTO){
        return chambreService.addOrUpdateChambre(chambreDTO);

    }

    @PutMapping("/updateChambre")
    ChambreDTO updateChambre(@RequestBody ChambreDTO chambreDTO){
        return chambreService.addOrUpdateChambre(chambreDTO);
    }
    @DeleteMapping("/deleteChambre/{idChambre}/")
    void deleteChambre(@PathVariable Long idChambre){
        chambreService.deleteChambre(idChambre);
    }
    @GetMapping("/findAllChambre")
    List<ChambreDTO> findAllChambre(){
        return chambreService.getAllChambres();
    }
    @GetMapping("/findById/{idChambre}")
    ChambreDTO findByIdChambre(@PathVariable Long idChambre){
        return chambreService.getChambreById(idChambre);
    }

    @GetMapping("/getAllChambresByType/{type}")
    public List<Chambre> getAllChambres(@PathVariable TypeChambre type) {
        return chambreService.getAllchambresbyType(type);
    }
    @GetMapping("/getChambreByNumero/{numero}")
    public Chambre getchambresbynumero(@PathVariable long numero) {
        return chambreService.getchambresbynumero(numero);

    }
}
