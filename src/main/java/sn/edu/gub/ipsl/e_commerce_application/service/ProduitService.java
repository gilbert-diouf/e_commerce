package sn.edu.gub.ipsl.e_commerce_application.service;

import org.springframework.stereotype.Service;
import sn.edu.gub.ipsl.e_commerce_application.entity.Produit;
import sn.edu.gub.ipsl.e_commerce_application.repository.ProduitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository){
        this.produitRepository=produitRepository;
    }

    public List<Produit> findAll(){
        return produitRepository.findAll();
    }

    public Optional<Produit> findById(Long id){
        return produitRepository.findById(id);
    }

    public Produit createProduit(Produit produit) throws ApiError{
        if (produit.getNom()==null || produit.getNom().isBlank()){
            throw new ApiError(404,"Le nom du produit est obligatoire");
        }

        return produitRepository.save(produit);
    }

    public void delete(Produit produit){
        produitRepository.delete(produit);
    }

    public void deleteById(Long id){
        produitRepository.deleteById(id);
    }

    public Produit update(Produit produit){
        return produitRepository.save(produit);
    }
}
