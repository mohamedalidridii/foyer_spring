package org.example.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Foyer;
import org.example.tpfoyer.repositories.FoyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;
    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }


    @Override
    public void deleteFoyer(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> getFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyer(long id) {
        return foyerRepository.findById(id).get();
    }
}
