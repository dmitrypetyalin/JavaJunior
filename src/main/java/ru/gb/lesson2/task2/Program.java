package ru.gb.lesson2.task2;

import java.lang.reflect.Field;

/**
 * @author PetSoft
 * @date 19.12.2024 22:29
 */
public class Program {
    /*
      Задача 2: Применение Reflection API в разработке
      ================================================
      <p>
      Реализуйте обобщённый метод, который принимает объект и выводит в консоль значения полей.
      Создайте класс "Car" с различными полями (например, модель, цвет, год выпуска).
      Примените Reflection API для вывода значений полей созданного объекта класса "Car"
      с использованием ранее созданного метода.
     */

    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("Toyota", "Blue", 2022);
        task2(car);
    }

    private static <T> void task2(T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields)  {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
    }
}
