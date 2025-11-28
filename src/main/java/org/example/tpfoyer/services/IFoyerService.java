package org.example.tpfoyer.services;


import org.example.tpfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdateFoyer(Foyer foyer);
    void deleteFoyer(long id);
    List<Foyer> getFoyer();
    Foyer getFoyer(long id);

}
