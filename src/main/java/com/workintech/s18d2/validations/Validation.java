package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.InvalidException;
import com.workintech.s18d2.exceptions.PlantException;

import java.util.Optional;

public class Validation {
    public static void validateId(Long id) {
        if (id == null || id < 0) {
            throw new InvalidException("ID must be at least 0");
        }
    }

//    public static void validateName(String name) {
//        if (name == null || name.isEmpty()) {
//            throw new InvalidException("Name parameter cannot be empty");
//        }
//    }

    public static void validateFruit(Fruit fruit) {
        if (fruit.getPrice() < 0) {
            throw new InvalidException("Fruit price cannot be negative");
        }
    }

    public static void validateVegetable(Vegetable vegetable) {
        if (vegetable.getPrice() < 0) {
            throw new InvalidException("Vegetable price cannot be negative");
        }
    }

    public static void validateExists(Optional<?> resource, String resourceName) {
        if (resource.isEmpty()) {
            throw new PlantException(resourceName + " not found");
        }
    }
}
