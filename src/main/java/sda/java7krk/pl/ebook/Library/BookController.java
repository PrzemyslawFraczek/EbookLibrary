package sda.java7krk.pl.ebook.Library;

import sda.java7krk.pl.ebook.View.Response;

public class BookController {

    public BookController(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    private BookStorage bookStorage;

    public Response addBook(String title, String author, String isbn) {
        Response response = new Response();
        if (bookStorage.exist(title, author, isbn)) {
            response.setMassage("book exist");
            response.setSuccess(false);
        } else {
            response.setSuccess(true);
            bookStorage.add(title, author, isbn);
        }
        return response;

    }


    public Response getInformationAbout(String isbn) {
        Response response = new Response();

        Book book = bookStorage.searchBy(isbn);
        response.setSuccess(true);
        response.setMassage(book.asJason());
        return response;
    }
}
