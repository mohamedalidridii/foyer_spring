package org.example.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Chambre;

import org.example.tpfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    ChambreRepository chambreRepository;


    @Override
    public Chambre addOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> getChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre getChambre(long id) {
        return chambreRepository.findById(id).get();
    }
}
