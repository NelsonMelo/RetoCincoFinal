package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Cosmetic;
import com.cuatroa.retodos.repository.CosmeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Proyecto pedidos revista por catalogo la hermosa Ursula
 * Diciembre 2021 
 * Reto 3 ciclo 4
 * @author Nelson Melo
 */
@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepository repository;

    public List<Cosmetic> getAll() {
        return repository.getAll();
    }

    public Optional<Cosmetic> getClothe(String reference) {
        return repository.getClothe(reference);
    }

    public Cosmetic create(Cosmetic accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Cosmetic update(Cosmetic accesory) {

        if (accesory.getReference() != null) {
            Optional<Cosmetic> accesoryDb = repository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Cosmetic> productByPrice(double price) {
        return repository.productByPrice(price);
    }

   //Reto 5
    public List<Cosmetic> getByDescriptionLike(String description) {
        return repository.getByDescriptionLike(description);
    }

}
