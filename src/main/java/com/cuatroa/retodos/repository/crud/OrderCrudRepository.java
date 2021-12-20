package com.cuatroa.retodos.repository.crud;

import com.cuatroa.retodos.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Proyecto pedidos revista por catalogo la hermosa Ursula
 * Diciembre 2021 
 * Reto 4 ciclo 4
 * @author Nelson Melo
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

//Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
 //Retorna las ordenes x estado   
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();

}
