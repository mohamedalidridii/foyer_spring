package org.example.tpfoyer.repositories;

import org.example.tpfoyer.dto.ChambreDTO;
import org.example.tpfoyer.entities.Chambre;
import org.example.tpfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByTypeChambre(TypeChambre type);

    List<Chambre> findAllBytypeChambre(TypeChambre typeChambre);
    Chambre findByNumeroChambre(long numeroChambre);

    @Query("SELECT c FROM Chambre c JOIN c.reservations r JOIN r.etudiants e WHERE e.cin = : cin")
    Chambre findByCin(@Param("cin") String cin);

}
