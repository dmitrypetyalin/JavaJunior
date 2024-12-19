package ru.gb.lesson1.task2.domain;

import ru.gb.lesson1.task2.interfaces.SemiFinishedFood;

/**
 * @author PetSoft
 * @date 18.12.2024 20:06
 */
public class DumplingMeat implements SemiFinishedFood {
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
        return "DumplingMeat";
    }
}
