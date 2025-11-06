package org.example.tpfoyer.services;


import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Universite;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUniversiteService {

    Universite addOrUpdateUniversite(Universite universite);
    void deleteUniversite(long id);
    List<Universite> getUniversite();
    Universite getUniversite(long id);
}
