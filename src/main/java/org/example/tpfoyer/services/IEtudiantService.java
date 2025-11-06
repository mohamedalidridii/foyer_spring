package org.example.tpfoyer.services;

import org.example.tpfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    void deleteEtudiant(long id);
    List<Etudiant> getEtudiant();
    Etudiant getEtudiant(long id);
}
