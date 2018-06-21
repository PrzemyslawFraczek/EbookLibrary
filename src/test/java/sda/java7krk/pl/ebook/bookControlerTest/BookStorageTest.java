package sda.java7krk.pl.ebook.bookControlerTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import sda.java7krk.pl.ebook.Library.Book;
import sda.java7krk.pl.ebook.Library.BookStorage;
import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.Library.BookController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BookStorageTest {


    public static final String TITLE = "Kamasutra";
    public static final String AUTHOR = "Vatsyayana";
    public static final String ISBN = "13:69:07";

    @Test
    public void shouldReturnInformationAboutExistingBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = TITLE;
        String author = AUTHOR;
        String isbn = ISBN;
        BDDMockito.given(bookStorage.exist(title, author, isbn)).willReturn(true);
        BDDMockito.given(bookStorage.searchBy(isbn)).willReturn(new Book(title, author, isbn));

        BookController bookController = new BookController(bookStorage);

        Response response = bookController.getInformationAbout(isbn);

        Assert.assertTrue(response.isSuccess());
        Assert.assertEquals(anExpectedInformation(title, author, isbn), response.getMassage());
    }


    private String anExpectedInformation(String title, String author, String isbn) {
        return "{" +

                "title:" + title + "," +
                "author:" + author +"," +
                "isbn:" + isbn +
                "}";
    }

    @Test
    public void shouldAddBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = TITLE;
        String author = AUTHOR;
        String isbn = ISBN;
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.addBook(title, author, isbn);

        assertTrue(response.isSuccess());
        Mockito.verify(bookStorage).add(title, author, isbn);
    }

    @Test
    public void shouldAddTheSameBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = TITLE;
        String author = AUTHOR;
        String isbn = ISBN;
        BDDMockito.given(bookStorage.exist(title, author, isbn)).willReturn(true);
        BookController bookController = new BookController(bookStorage);


        Response response = bookController.addBook(title, author, isbn);

        Assert.assertFalse(response.isSuccess());
        Assert.assertEquals(response.getMassage(), "book exist");
        verify(bookStorage, never()).add(title, author, isbn);

    }


    private void assertTrue(boolean success) {
    }
}
