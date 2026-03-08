package sn.edu.gub.ipsl.e_commerce_application.service;

import org.springframework.stereotype.Service;
import sn.edu.gub.ipsl.e_commerce_application.entity.Carte;
import sn.edu.gub.ipsl.e_commerce_application.repository.CarteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarteService {

    private CarteRepository carteRepository;

    public CarteService(CarteRepository carteRepository){
        this.carteRepository=carteRepository;
    }

    public List<Carte> findAll(){
        return carteRepository.findAll();
    }

    public Optional<Carte> finfById(Long id){
        return carteRepository.findById(id);
    }

    public Carte createCarte(Carte carte){
        return carteRepository.save(carte);
    }

    public void deleteCarte(Carte carte){
        carteRepository.delete(carte);
    }

    public void deleteById(Long id){
        carteRepository.deleteById(id);
    }

    public Carte update(Carte carte){
        return carteRepository.save(carte);
    }
}
