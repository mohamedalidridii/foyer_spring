package org.example.tpfoyer.services;

import org.example.tpfoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addOrUpdateBloc(Bloc bloc);
    void deleteBloc(long id);
    List<Bloc> getBlocs();
    Bloc getBloc(long id);
}
