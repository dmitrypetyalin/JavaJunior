package ru.gb.lesson2.task3;

import ru.gb.lesson2.task3.annotations.Column;
import ru.gb.lesson2.task3.annotations.Table;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @author PetSoft
 * @date 20.12.2024 14:15
 */
public class QueryBuilder {
    public String buildInsertQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append(" (");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    query
                            .append(columnAnnotation.name())
                            .append(", ");
                }
            }

            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(") VALUES (");

            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    query
                            .append("'")
                            .append(field.get(obj))
                            .append("', ");
                }
            }

            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }
            query.append(")");
            return query.toString();
        } else {
            return null;
        }
    }

    public String buildSelectQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append(" WHERE ");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey()) {
                        query
                                .append(columnAnnotation.name())
                                .append(" = ")
                                .append(primaryKey);
                        break;
                    }
                }
            }
        }
        return query.toString();
    }

    public String buildUpdateQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("UPDATE ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" SET ");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey())
                        continue;
                    query
                            .append(columnAnnotation.name())
                            .append(" = '")
                            .append(field.get(obj))
                            .append("', ");
                }
            }

            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(" WHERE ");

            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey()) {
                        query
                                .append(columnAnnotation.name())
                                .append(" = '")
                                .append(field.get(obj))
                                .append("'");
                        break;
                    }
                }
            }
        } else {
            return null;
        }
        return query.toString();
    }

    /**
     * TODO: Доработать в рамках домашнего задания
     * @param clazz
     * @param primaryKey
     * @return String representation of the SQL-query
     */
    public String buildDeleteQuery(Class<?> clazz, UUID primaryKey) throws IllegalAccessException {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        query.append(tableAnnotation.name()).append(" WHERE ");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query
                            .append(columnAnnotation.name())
                            .append(" = '")
                            .append(primaryKey)
                            .append("'");
                }
            }
        }
        return query.toString();
    }
}

















