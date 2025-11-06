package org.example.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Etudiant;
import org.example.tpfoyer.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addOrUpdateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }


    @Override
    public void deleteEtudiant(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiant(long id) {
        return etudiantRepository.findById(id).get();
    }
}
