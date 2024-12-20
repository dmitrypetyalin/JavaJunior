package ru.gb.lesson2.task1;

/**
 * @author PetSoft
 * @date 19.12.2024 21:51
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Name";
        this.age = 25;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.printf("Имя: %s; Возраст: %d\n %n", name, age);
    }
}
