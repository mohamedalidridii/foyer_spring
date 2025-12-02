package org.example.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.example.tpfoyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findAllByfIsNull();
    List<Bloc> findAllByCapaciteBlocGreaterThan(long capaciteBloc);
    List<Bloc> findAllByNomBlocStartingWith(String NomBloc );
    List<Bloc> findAllByCapaciteBlocGreaterThanAndNomBlocStartingWith(long CapaciteBloc, String NomBloc );

    @Query("SELECT b FROM Bloc b WHERE b.nomBloc IS NOT NULL")
    List<Bloc> findBlocsWithNom();

    @Query("SELECT b FROM Bloc b WHERE b.capaciteBloc < 500")
    List<Bloc> findBlocsWithCapaciteBloc();
    @Query("SELECT b FROM Bloc b WHERE b.f.capaciteFoyer =:capacity")
    List<Bloc> findBlocsWithCapacityFoyer(@Param("capacity") long capacity);

    @Modifying
    @Transactional
    @Query("UPDATE Bloc b SET b.nomBloc =:nomBloc WHERE b.idBloc =:idBloc")
    int updateNomBloc(@Param("idBloc") Long idBloc, @Param("nomBloc") String nomBloc);

    @Modifying
    @Transactional
    @Query("DELETE FROM Bloc b WHERE b.nomBloc = :nombloc")
    int deleteBloc(@Param("nombloc") String nombloc);
}
