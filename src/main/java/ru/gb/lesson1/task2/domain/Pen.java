package ru.gb.lesson1.task2.domain;

import ru.gb.lesson1.task2.interfaces.Thing;

/**
 * @author PetSoft
 * @date 17.12.2024 22:01
 */
public class Pen implements Thing {

    @Override
    public String getName() {
        return "Pen";
    }
}
