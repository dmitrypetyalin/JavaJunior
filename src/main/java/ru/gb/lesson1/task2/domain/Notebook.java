package ru.gb.lesson1.task2.domain;

import ru.gb.lesson1.task2.interfaces.Thing;

/**
 * @author PetSoft
 * @date 17.12.2024 22:02
 */
public class Notebook implements Thing {
    @Override
    public String getName() {
        return "Notebook";
    }
}
