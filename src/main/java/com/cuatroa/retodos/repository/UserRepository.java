package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Order;
import com.cuatroa.retodos.model.User;
import com.cuatroa.retodos.repository.crud.UserCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Proyecto pedidos revista por catalogo la hermosa Ursula
 * Diciembre 2021 
 * Reto 5 ciclo 4
 * @author Nelson Melo
 */
@Repository
    /**
    * Class UserRepository
    */
public class UserRepository {
    @Autowired
    /**
     * Dependencies Injection
     */
    private UserCrudRepository userCrudRepository;
        @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * This method returns a list of all the users
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * This method returns a user by its id
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * This method create a user
     * @param user
     * @return
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * This method updates a user
     * @param user
     */
        public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * This method deletes a user
     * @param user
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * This method verifies if the email is registered in the database
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    /**
     * This method authenticates a user by its email and password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * This method returns a user by its monthBirthDay
     * @param monthBirthDay
     * @return
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
    
}
