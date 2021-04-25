package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book first = new Book("First book", 125);
        Book second = new Book("Second book", 210);
        Book third = new Book("Third book", 350);
        Book fourth = new Book("Clean code", 150);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getValueOfPage() + " pages");
        }
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getValueOfPage() + " pages");
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getValueOfPage()
                        + " pages");
            }
        }
    }
}
