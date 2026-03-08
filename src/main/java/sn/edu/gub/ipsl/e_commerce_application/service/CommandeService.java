package sn.edu.gub.ipsl.e_commerce_application.service;

import sn.edu.gub.ipsl.e_commerce_application.entity.Commande;
import sn.edu.gub.ipsl.e_commerce_application.entity.Status;
import sn.edu.gub.ipsl.e_commerce_application.repository.CommandeRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CommandeService {

    private CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository){
        this.commandeRepository=commandeRepository;
    }

    public List<Commande> findAll(){
        return  commandeRepository.findAll();
    }

    public Optional<Commande> findById(Long id){
        return commandeRepository.findById(id);
    }

    public Commande createCommande(Commande commande){
        commande.builder()
                .montantTotal(BigDecimal.valueOf(35000))
                .dateMiseJour(LocalDateTime.now())
                .dateCreation(LocalDateTime.now())
                .status(Status.EN_COURS)
                .build();
        return commandeRepository.save(commande);
    }

    public void delete(Commande commande){
        commandeRepository.delete(commande);
    }

    public void deleteById(Long id){
        commandeRepository.deleteById(id);
    }

    public Commande update(Commande commande){
        return commandeRepository.save(commande);
    }

}
