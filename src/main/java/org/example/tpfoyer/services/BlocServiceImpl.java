package org.example.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Bloc;
import org.example.tpfoyer.repositories.BlocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;
    @Override
    public Bloc addOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> getBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBloc(long id) {
        return blocRepository.findById(id).get();
    }
}
