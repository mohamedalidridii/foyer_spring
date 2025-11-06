package org.example.tpfoyer.services;

import org.example.tpfoyer.entities.Chambre;
import org.example.tpfoyer.repositories.ChambreRepository;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(long id);
    List<Chambre> getChambre();
    Chambre getChambre(long id);
}
