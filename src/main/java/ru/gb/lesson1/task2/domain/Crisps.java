package ru.gb.lesson1.task2.domain;


import ru.gb.lesson1.task2.interfaces.Snack;

/**
 * @author PetSoft
 * @date 17.12.2024 22:15
 */
public class Crisps implements Snack {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Crisps";
    }
}
