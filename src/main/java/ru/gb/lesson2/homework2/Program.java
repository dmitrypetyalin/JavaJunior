package ru.gb.lesson2.homework2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author PetSoft
 * @date 19.12.2024 19:35
 */
public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Arrays.stream(String.class.getDeclaredMethods()).forEach(System.out::println);
    }
}
