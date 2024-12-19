package ru.gb.lesson1.task2.domain;

import ru.gb.lesson1.task2.interfaces.Snack;
/**
 * @author PetSoft
 * @date 17.12.2024 22:09
 */
public class BalykCheese implements Snack {
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
        return "Cheese (Balyk)";
    }
}
