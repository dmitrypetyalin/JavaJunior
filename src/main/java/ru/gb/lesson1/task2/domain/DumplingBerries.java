package ru.gb.lesson1.task2.domain;


import ru.gb.lesson1.task2.interfaces.SemiFinishedFood;

/**
 * @author PetSoft
 * @date 18.12.2024 20:05
 */
public class DumplingBerries implements SemiFinishedFood {
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
        return "DumplingBerries";
    }
}
