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
    List<Bloc> findAllBloc(){
        return blocService.getBlocs();

    }
    @GetMapping("/findById/{idBloc}")
    Bloc findByIdBloc(@PathVariable Long idBloc){
        return blocService.getBloc(idBloc);
    }
}
