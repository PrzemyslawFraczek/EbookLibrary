package sda.java7krk.pl.ebook.Library;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    public String asJason() {
        return "{" +

                "title:" + title + "," +
                "author:" + author +"," +
                "isbn:" + isbn +
                "}";
    }
}
