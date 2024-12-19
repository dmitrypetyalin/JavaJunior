package ru.gb.lesson1.task2.domain;

import ru.gb.lesson1.task2.interfaces.HealthyFood;

/**
 * @author PetSoft
 * @date 18.12.2024 20:07
 */
public class OliveOil implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "OliveOil";
    }
}
