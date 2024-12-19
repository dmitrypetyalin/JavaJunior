package ru.gb.lesson1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PetSoft
 * @date 17.12.2024 12:03
 */
public class LibraryV2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        //Finding books, written by author
        List<Book> authorBooks = books.stream()
                .filter(book -> "Лев Толстой".equals(book.getAuthor())).toList();
        System.out.println("Лев Толстой: " + authorBooks);

        //Funding books published after 1866
//        List<Book> booksAfterYear = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getYear() > 1869)
//                booksAfterYear.add(book);
//        }

        List<Book> booksAfterYear = books.stream()
                        .filter(book -> book.getYear() > 1866).toList();
        System.out.println("Books published after 1866: " + booksAfterYear);

        //Finding unique book's titles
//        List<String> uniqueTitles = new ArrayList<>();
//        for (Book book : books) {
//            if (!uniqueTitles.contains(book.getTitle())) {
//                uniqueTitles.add(book.getTitle());
//            }
//        }

//        List<String> uniqueTitles = books.stream()
//                .map(book -> book.getTitle()).distinct().toList();

        List<String> uniqueTitles = books.stream()
                .map(Book::getTitle).distinct().toList();

        System.out.println("Unique books in library: " + uniqueTitles);

    }
}
