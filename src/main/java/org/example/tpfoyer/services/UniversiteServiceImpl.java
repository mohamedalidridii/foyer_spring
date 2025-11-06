package org.example.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Universite;
import org.example.tpfoyer.repositories.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;
    @Override
    public Universite addOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }


    @Override
    public void deleteUniversite(long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public List<Universite> getUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversite(long id) {
        return universiteRepository.findById(id).get();
    }
}
