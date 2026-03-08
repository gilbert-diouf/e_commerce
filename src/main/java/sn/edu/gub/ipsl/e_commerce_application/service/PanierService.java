package sn.edu.gub.ipsl.e_commerce_application.service;

import org.springframework.stereotype.Service;
import sn.edu.gub.ipsl.e_commerce_application.entity.Panier;
import sn.edu.gub.ipsl.e_commerce_application.repository.PanierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PanierService {

    private PanierRepository panierRepository;

    public PanierService(PanierRepository panierRepository){
        this.panierRepository = panierRepository;
    }

    public List<Panier> findAll(){
        return panierRepository.findAll();
    }

    public Optional<Panier> finfById(Long id){
        return panierRepository.findById(id);
    }

    public Panier createCarte(Panier panier){
        return panierRepository.save(panier);
    }

    public void deleteCarte(Panier panier){
        panierRepository.delete(panier);
    }

    public void deleteById(Long id){
        panierRepository.deleteById(id);
    }

    public Panier update(Panier panier){
        return panierRepository.save(panier);
    }
}
