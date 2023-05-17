package hw1.topic3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookSeller {
    static class Book{
        private int id;
        private String isbn;
        private String name;
        private String author;
        private LocalDate publishDate;

        public Book(int id, String isbn, String name, String author, LocalDate publishDate) {
            this.id = id;
            this.isbn = isbn;
            this.name = name;
            this.author = author;
            this.publishDate = publishDate;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", isbn='" + isbn + '\'' +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", publishDate=" + publishDate +
                    '}';
        }
    }
    private static final List<Book> books = new ArrayList<>();
    private static List<Book> sellBooks(){
        books.add(new Book(1, "9780544003415", "The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21)));
        books.add(new Book(2, "9780439554930", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
        books.add(new Book(3, "9780061120084", "To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11)));
        return books;
    }

    public static void main(String[] args) {
        System.out.println(sellBooks());
    }
}
