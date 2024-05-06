package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if (fruit.isEmpty()) {
            throw new PlantException("Fruit not found with ID: " + id);
        }
        return fruit.get();
    }

    @Override
    public Fruit save(Fruit fruit) {
        Validation.validateFruit(fruit);
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = getById(id);
        Validation.validateExists(Optional.ofNullable(fruit), fruit.getName());
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
