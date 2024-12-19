package ru.gb.lesson1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author PetSoft
 * @date 17.12.2024 11:31
 */

/*
 * Задача 1: Рализовать систему учета книг в библиотеке. У каждой книги есть название, автор и год издания.
 * Необходимо созлать список книг и выполнить следующие действия:
 * 1. Обычный способ:
 *   - найти все книги написанные оперделённым автором (например "John Doe");
 *   - найти все книги, изданные после определённого года (например, 2010);
 *   - найти все уникальные названия книг в библиотеке.
 * 2. Использование лямбда-выражений:
 *   - Те же задачи, толькл с использованием лямда-выражений  и Stream API для более компактного и выразительного кода.
 */

public class Library {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        //Finding books, written by author
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if ("Лев Толстой".equals(book.getAuthor()))
                authorBooks.add(book);
        }
        System.out.println("Лев Толстой: " + authorBooks);

        //Funding books published after 1866
        List<Book> booksAfterYear = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 1869)
                booksAfterYear.add(book);
        }
        System.out.println("Books published after 1866: " + booksAfterYear);

        //Finding unique book's titles
        List<String> uniqueTitles = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitles.contains(book.getTitle())) {
                uniqueTitles.add(book.getTitle());
            }
        }
        System.out.println("Unique books in library: " + uniqueTitles);

    }
}
