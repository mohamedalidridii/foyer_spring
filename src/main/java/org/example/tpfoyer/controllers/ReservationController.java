package org.example.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Reservation;
import org.example.tpfoyer.services.IReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectController")

@AllArgsConstructor
public class ReservationController {
    IReservationService projectService;

    @PostMapping("/AddReservation")
    Reservation addReservation(@RequestBody Reservation reservation){
        return projectService.addOrUpdateReservation(reservation);

    }
    @PutMapping("/updateReservation")
    Reservation updateReservation(@RequestBody Reservation reservation){
        return projectService.addOrUpdateReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{idReservation}/")
    void deleteReservation(@PathVariable String idReservation){
        projectService.deleteReservation(idReservation);
    }
    @GetMapping("/findAllReservation")
    List<Reservation> findAllReservation(){
        return projectService.getReservation();

    }
    @GetMapping("/findById/{idReservation}")
    Reservation findByIdReservation(@PathVariable String idReservation){
        return projectService.getReservation(idReservation);
    }
}
