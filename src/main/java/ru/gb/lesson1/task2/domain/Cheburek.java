package ru.gb.lesson1.task2.domain;

import ru.gb.lesson1.task2.interfaces.SemiFinishedFood;

/**
 * @author PetSoft
 * @date 17.12.2024 22:12
 */
public class Cheburek implements SemiFinishedFood {
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
        return "Cheburek";
    }
}
