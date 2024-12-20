package ru.gb.lesson2.task3;

import java.util.UUID;

/**
 * @author PetSoft
 * @date 20.12.2024 13:23
 */
public class Program {
    /*
     * Задача 3: Рализовать простой фреймворк для создания SQL-запросов на основе Java объектов
     *
     * Фреймворк должен поддерживать аннотации
     * для определения правил валидации для полей объекта.
     *
     * 1. Аннотации для маппинга:
     *      Создайте аннотации, такие как: @Entity, @Table, @Column для маппинга классов,
     *      таблиц и полей в базе данных.
     *
     * 2. Механизм генерации SQL-запросов:
     *      Реализуйте класс QueryBuilder, который сможет принимать объект и генерировать
     *      SQL-запросы для выполнения операций CRUD (Create, Read, Update, Delete) на основе аннотаций.
     *      Используйте Reflection для получения метаданных класса, аннотированного объекта,
     *      чтобы построить соответствующий запрос.
     *
     * 3. Пример использования:
     *      Создайте простой класс, аннотированного для маппинга с базой данных.
     *      Используйте Ваш фреймворк для генерации SQL-запросов для различных опреаций,
     *      таких как вставка, выборка, обновление и удаление.
     */

    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee("Dmitry", "dmitry@gmail.com");
        UUID pk = UUID.randomUUID();
        user.setId(pk);

        QueryBuilder queryBuilder = new QueryBuilder();
        String insertQuery = queryBuilder.buildInsertQuery(user);
        System.out.printf("Insert Query: %s\n", insertQuery);

        String selectQuery = queryBuilder.buildSelectQuery(Employee.class, pk);
        System.out.printf("Select Query: %s\n", selectQuery);

        String updateQuery = queryBuilder.buildUpdateQuery(user);
        System.out.printf("Update Query: %s\n", updateQuery);

        String deleteQuery = queryBuilder.buildDeleteQuery(Employee.class, pk);
        System.out.printf("Delete Query: %s\n", deleteQuery);
    }
}
