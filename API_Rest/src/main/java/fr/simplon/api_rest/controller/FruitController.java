package fr.simplon.api_rest.controller;

import fr.simplon.api_rest.dao.impl.FruitRepository;
import fr.simplon.api_rest.entity.Fruit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitRepository repo;

    public FruitController(FruitRepository fr) {
        this.repo = fr;

        //this.repo.save (new Fruit("Banane", "Norvège", 12.03));
        //this.repo.save (new Fruit("Ananas", "Suède", 23.45));
        //this.repo.save (new Fruit("Pastèque", "Bretagne", 6.78));

    }

    @GetMapping("/rest/fruits")
    public List<Fruit> getFruits() {
        return repo.findAll();
    }

    @GetMapping("/rest/fruits/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/rest/fruits/")
    public List<Fruit> saveFruit(@RequestBody Fruit fruit) {
        repo.save(fruit);
        return repo.findAll();
    }

    @DeleteMapping("/rest/fruits/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Le fruit " + id + " a été supprimé");
    }


    @PutMapping("/rest/fruits/{id}")
    public Fruit updateFruit(@PathVariable Long id, @RequestBody Fruit updatedFruit) {
        Fruit fruit = repo.findById(id).orElse(null);
        if (fruit != null) {
            fruit.setNom(updatedFruit.getNom());
            fruit.setOrigine(updatedFruit.getOrigine());
            fruit.setPrix(updatedFruit.getPrix());
            repo.save(fruit);
        }
        return fruit;
    }

}
