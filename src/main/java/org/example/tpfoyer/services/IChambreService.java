package org.example.tpfoyer.services;

import org.example.tpfoyer.dto.ChambreDTO;
import org.example.tpfoyer.entities.Chambre;
import org.example.tpfoyer.entities.TypeChambre;


import java.util.List;

public interface IChambreService {
    ChambreDTO getChambreById(long id); // Returns entity
    List<ChambreDTO> getAllChambres(); // Returns list of entities
    ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO);
    void deleteChambre(long id);
    List<Chambre> getAllchambresbyType(TypeChambre type);
    Chambre getchambresbynumero(long numero);
}
