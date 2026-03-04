package sn.edu.gub.ipsl.e_commerce_application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.edu.gub.ipsl.e_commerce_application.entity.Produit;
import sn.edu.gub.ipsl.e_commerce_application.service.ApiError;
import sn.edu.gub.ipsl.e_commerce_application.service.ProduitService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
@AllArgsConstructor
public class ProduitController {

    private ProduitService produitService;

    @Operation(
            description = "Retourne la liste des produits",
            summary = "La liste des produits",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des produits est retournee avec succes")
            }

    )

    @GetMapping
    public List<Produit> getAllProduit(){
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.findById(id).orElse(null);
    }

    @PostMapping
    public Produit createProduits(@RequestBody Produit produit) throws ApiError {
        return produitService.createProduit(produit);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        produitService.deleteById(id);
    }

    @PutMapping
    public Produit update(@RequestBody Produit produit){
        return produitService.update(produit);
    }
}
