package org.example.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Bloc;
import org.example.tpfoyer.services.IBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocController")

@AllArgsConstructor
public class BlocController {
    IBlocService blocService;

    @PostMapping("/AddBloc")
    Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.addOrUpdateBloc(bloc);

    }
    @PutMapping("/updateBloc")
    Bloc updateBloc(@RequestBody Bloc bloc){
        return blocService.addOrUpdateBloc(bloc);
    }

    @DeleteMapping("/deleteBloc/{idBloc}/")
    void deleteBloc(@PathVariable Long idBloc){
        blocService.deleteBloc(idBloc);
    }
    @GetMapping("/findAllBloc")
    List<Bloc> findAllBloc() throws InterruptedException {
        return blocService.getBlocs()  ;

    }
    @GetMapping("/findById/{idBloc}")
    Bloc findByIdBloc(@PathVariable Long idBloc){
        return blocService.getBloc(idBloc);
    }

    @PutMapping("/affecterBlocAFoyer/{idBloc}/{idFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return blocService.affecterBlocAFoyer(idBloc, idFoyer);
    }

    @PostMapping("/ajouterBlocAvecFoyer")
    public Bloc ajouterBlocAvecFoyer(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @PutMapping("/desaffecterBlocDeFoyer/{idBloc}")
    public Bloc desaffecterBlocDeFoyer(@PathVariable Long idBloc) {
        return blocService.desaffecterBlocDeFoyer(idBloc);
    }

    @GetMapping("/getBlocsWithNoFoyer")
    public List<Bloc> getBlocsWithNoFoyer() {
        return blocService.getBlocsWithNoFoyer();
    }

    @GetMapping("/getBlocsGreaterThan30")
    public List<Bloc> getBlocsGreaterThanNumber() {
        return blocService.getBlocsGreaterThanNumber();
    }
//
    @GetMapping("/getBlocsStartsWithCaractereA")
    public List<Bloc> getBlocsStartingWithCaracter() {
        return blocService.getBlocsStartingWithCaracter();
    }
    @GetMapping("/getBlocsStartsWithCaractereA_AndgetBlocsGreaterThan30")
    public  List<Bloc> getBlocsStartingWithCaracterAndGreaterThanNumber(){
        return blocService.getBlocsStartingWithCaracterAndGreaterThanNumber();
    }
    @GetMapping("/getBlocsnotnulljpql")
    public List<Bloc> getBlocsnotnulljpql() {
        return blocService.findBlocsWithNomjpql();
    }
    @GetMapping("/findBlocsWithCapaciteBloc")
    public List<Bloc> findBlocsWithCapaciteBloc() {
        return blocService.findBlocsWithCapaciteBloc();
    }
    @GetMapping("/findBlocsfoyer/{capacity}")
    public List<Bloc> findBlocsfoyer(@PathVariable Long capacity) {
        return blocService.findBlocsByFoyerCapacity(capacity);
    }
    @GetMapping("/renamebloc/{id}/{nombloc}")
    public void renameBloc(@PathVariable Long id, @PathVariable String nombloc){
         blocService.renameBloc(id,nombloc);
    }

    @GetMapping("/deletebloc/{nombloc}")
    public void deletebloc(@PathVariable String nombloc){
            blocService.deleteBloc(nombloc);
    }

}
