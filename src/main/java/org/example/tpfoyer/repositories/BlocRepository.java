package org.example.tpfoyer.repositories;

import org.example.tpfoyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findAllByfIsNull();
    List<Bloc> findAllByCapaciteBlocGreaterThan(long capaciteBloc);
    List<Bloc> findAllByNomBlocStartingWith(String NomBloc );
    List<Bloc> findAllByCapaciteBlocGreaterThanAndNomBlocStartingWith(long CapaciteBloc, String NomBloc );


}
