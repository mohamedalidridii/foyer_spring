package org.example.tpfoyer.services;

import org.example.tpfoyer.dto.ChambreDTO;
import org.example.tpfoyer.entities.Chambre;
import org.example.tpfoyer.entities.TypeChambre;
import org.example.tpfoyer.mapper.ChambreMapper;
import org.example.tpfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private ChambreMapper chambreMapper;  // Only ONE mapper declaration

    @Override
    public ChambreDTO getChambreById(long id) {
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found with id: " + id));
        return chambreMapper.toDTO(chambre);  // Changed from toDoto to toDTO
    }

    @Override
    public ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO) {
        Chambre chambre = chambreMapper.toEntity(chambreDTO);
        Chambre savedChambre = chambreRepository.save(chambre);
        return chambreMapper.toDTO(savedChambre);  // Changed from toDoto to toDTO
    }

    @Override
    public void deleteChambre(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<ChambreDTO> getAllChambres() {
        return chambreRepository.findAll()
                .stream()
                .map(chambreMapper::toDTO)  // Changed from toDoto to toDTO
                .toList();
    }
    @Override
    public List<Chambre> getAllchambresbyType(TypeChambre type) {

        return chambreRepository.findAllByTypeChambre(type);
    }
//
//
    public Chambre getchambresbynumero(long numero) {

        return chambreRepository.findByNumeroChambre(numero);
    }

}