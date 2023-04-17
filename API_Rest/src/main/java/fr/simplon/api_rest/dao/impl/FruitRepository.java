package fr.simplon.api_rest.dao.impl;

import fr.simplon.api_rest.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {


    // < > entre crochets dit qu'on veut une collection, dedans, Fruit est le nom de la classe et Lon le type de l'ID
}


