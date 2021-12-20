package com.cuatroa.retodos.controller;

import com.cuatroa.retodos.model.Cosmetic;
import com.cuatroa.retodos.service.CosmeticService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Proyecto pedidos revista por catalogo la hermosa Ursula
 * Diciembre 2021 
 * Reto 5 ciclo 4
 * @author Nelson Melo
 */
@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class CosmeticController {

    @Autowired
    private CosmeticService accessoryService;

    @GetMapping("/all")
    public List<Cosmetic> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cosmetic> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetic create(@RequestBody Cosmetic gadget) {
        return accessoryService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetic update(@RequestBody Cosmetic gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Cosmetic> productByPrice(@PathVariable("price") double precio) {
        return accessoryService.productByPrice(precio);
    }
    //Reto 5
    @GetMapping("/description/{description}")
    public List<Cosmetic> getByDescriptionLike(@PathVariable("description") String description) {
        return accessoryService.getByDescriptionLike(description);
    }

}
