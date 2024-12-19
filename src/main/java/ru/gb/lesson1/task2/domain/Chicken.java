package ru.gb.lesson1.task2.domain;


import ru.gb.lesson1.task2.interfaces.HealthyFood;

/**
 * @author PetSoft
 * @date 17.12.2024 22:13
 */
public class Chicken implements HealthyFood {
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Chicken";
    }
}
