package ru.gb.lesson1.homework1;

import java.util.*;

/**
 * @author PetSoft
 * @date 19.12.2024 1:00
 */
public class Program {
    public static void main(String[] args) {
        List<Integer> list = fillInTheList(10);
        System.out.println("Source list: " + list);

        System.out.println("Odd items of the list: " + list.stream().filter(v -> v % 2 == 0).toList());

        // 1
        System.out.println("The average of list's odd items: " + list.stream()
                .filter(v -> v % 2 == 0)
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage());
        // 2
        System.out.println("The average of list's odd items: " + list.stream()
                .filter(v -> v % 2 == 0)
                .mapToDouble(v -> v)
                .average()
                .orElse(Double.NaN));
        // 3
        System.out.println("The average of list's odd items: " + list.stream()
                .filter(v -> v % 2 == 0)
                .mapToInt(e -> e)
                .average()
                .getAsDouble());
    }

    static List<Integer> fillInTheList(int capacity) {
        List<Integer> list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add((int) (Math.random() * 10));
        }
        return list;
    }
}
