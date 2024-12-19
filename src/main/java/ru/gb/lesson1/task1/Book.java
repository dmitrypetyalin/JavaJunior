package ru.gb.lesson1.task1;

/**
 * @author PetSoft
 * @date 17.12.2024 11:25
 */
public class Book {
    //region Fields
    private final String title;
    private final String author;
    private final int year;
    //endregion

    //region Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    //endregion

    //region Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    //endregion


    @Override
    public String toString() {
        return "Book{" +
                "title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", year: " + year +
                '}';
    }
}
