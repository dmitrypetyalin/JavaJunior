package ru.gb.lesson2.task1;

import java.lang.reflect.*;

/**
 * @author PetSoft
 * @date 19.12.2024 21:42
 */
public class Program {
    /**
     * Задача 1: Основы Reflection API
     * ===============================
     * <p>
     * Получите информацию о классе "Person" с использванием Reflection API:
     *  - выведите все поля и методы класса;
     *  - создайте экземпляр класса "Person" с использванием Reflection API;
     *  - установите значения полей и вызовите методы;
     *  - реализуйте обработку исключений для обеспечения корректного взаимодейстия с Reflection API.
     */

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("ru.gb.lesson2.task1.Person");

        //List of fields
        Field[] fields = personalClass.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("Field: " + field.getName());
        }

        //List of constructors
        Constructor<?>[] constructors = personalClass.getConstructors();

        Object personInstance = constructors[0].newInstance();

        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personInstance, "Alice");

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personInstance, 30);

        Method displayInfoMethod = personalClass.getDeclaredMethod("displayInfo");
        displayInfoMethod.invoke(personInstance);
    }
}
