package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Cosmetic;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.CosmeticCrudRepository;

/**
 * Proyecto pedidos revista por catalogo la hermosa Ursula
 * Diciembre 2021 
 * Reto 3 ciclo 4
 * @author Nelson Melo
 */
@Repository
public class CosmeticRepository {
    @Autowired
    private CosmeticCrudRepository repository;

    public List<Cosmetic> getAll() {
        return repository.findAll();
    }

    public Optional<Cosmetic> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Cosmetic create(Cosmetic clothe) {
        return repository.save(clothe);
    }

    public void update(Cosmetic clothe) {
        repository.save(clothe);
    }
    
    public void delete(Cosmetic clothe) {
        repository.delete(clothe);
    }
    
    public List<Cosmetic> productByPrice(double precio) {
	return repository.findByPriceLessThanEqual(precio);
        
  }
    
    //Reto 5
    public List<Cosmetic> getByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }

}