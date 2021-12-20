/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatroa.retodos.repository.crud;

import com.cuatroa.retodos.model.Cosmetic;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
* Proyecto pedidos revista por catalogo la hermosa Ursula
 * Diciembre 2021 
 * Reto 5 ciclo 4
 * @author Nelson Melo
 */
public interface CosmeticCrudRepository extends MongoRepository<Cosmetic, String> {
    public List<Cosmetic> findByPriceLessThanEqual(double precio);
    
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Cosmetic> findByDescriptionLike(String description);

}
