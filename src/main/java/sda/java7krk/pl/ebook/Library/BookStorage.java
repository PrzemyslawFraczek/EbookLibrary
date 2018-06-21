package sda.java7krk.pl.ebook.Library;

public interface BookStorage {
    void add(String title, String author, String isbn);
    boolean exist(String title, String author, String isbn);



    Book searchBy(String isbn);
}
//użyć wzorca adapter do FileBookReader