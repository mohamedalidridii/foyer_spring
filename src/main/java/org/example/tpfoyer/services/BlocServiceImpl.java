package org.example.tpfoyer.services;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.example.tpfoyer.entities.Bloc;
import org.example.tpfoyer.entities.Foyer;
import org.example.tpfoyer.repositories.BlocRepository;

import org.example.tpfoyer.repositories.FoyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;
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

    @Override
    public Bloc ajouterBlocAvecFoyer(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    @Transactional
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non disponible: " + idBloc));

        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable avec id: " + idFoyer));

        bloc.setF(foyer);
        foyer.getBlocs().add(bloc);
        foyerRepository.save(foyer);
        return blocRepository.save(bloc);
    }
    @Override
    public Bloc desaffecterBlocDeFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc non disponible avec l'id:" + idBloc));
        log.info("");
        Foyer foyer = null;
        if (bloc.getF() != null) {
            log.info("This is an INFO level console log message.");

            foyer = bloc.getF();
        }
        if (foyer.getBlocs() != null) {
            log.info("This is an INFO level console log message.");

            foyer.getBlocs().remove(bloc);
        }
        log.info("This is an INFO level console log message.");

        bloc.setF(null);
        foyerRepository.save(foyer);
        blocRepository.save(bloc);
        log.info("This is an INFO level console log message.");
        return blocRepository.findById(idBloc).orElse(bloc);
    }
    @Override
    public List<Bloc> getBlocsWithNoFoyer(){
        return blocRepository.findAllByfIsNull();
    }
    @Override
    public List<Bloc> getBlocsGreaterThanNumber(){
        return blocRepository.findAllByCapaciteBlocGreaterThan(30);
    }
    @Override
    public  List<Bloc> getBlocsStartingWithCaracter(){
        return blocRepository.findAllByNomBlocStartingWith("B");
    }
    @Override
    public  List<Bloc> getBlocsStartingWithCaracterAndGreaterThanNumber(){
        return blocRepository.findAllByCapaciteBlocGreaterThanAndNomBlocStartingWith(100,"B");

    }
    @Override
    public List<Bloc> findBlocsWithNomjpql(){
        return blocRepository.findBlocsWithNom();
    }
    @Override
    public List<Bloc> findBlocsWithCapaciteBloc(){
        return blocRepository.findBlocsWithCapaciteBloc();
    }
    @Override
    public List<Bloc> findBlocsByFoyerCapacity(Long capacity) {
        return blocRepository.findBlocsWithCapacityFoyer(capacity);
    }

    @Override
    public void renameBloc(Long id, String nomBloc){
        blocRepository.updateNomBloc(id, nomBloc);
    }
    @Override
    public void deleteBloc(String nombloc){
        blocRepository.deleteBloc(nombloc);
    }

}
