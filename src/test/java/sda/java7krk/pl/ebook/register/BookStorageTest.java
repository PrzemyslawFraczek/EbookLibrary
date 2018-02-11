package sda.java7krk.pl.ebook.register;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.library.BookStorage;
import sda.java7krk.pl.ebook.library.BookController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BookStorageTest {
    private static final String TITLE = "Kamsutra";
    public static final String AUTHOR = "Vatsyayana";

    @Test
    public void shouldNewBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = TITLE;
        String author = AUTHOR;

        BookController bookController = new BookController(bookStorage);

        Response response = bookController.addBook(title, author);

        Assert.assertTrue(response.isSuccess());
        Mockito.verify(bookStorage).add(title, author);
    }

    @Test
    public void shouldAddTheSameBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = TITLE;
        String author = AUTHOR;
        BDDMockito.given(bookStorage.exist(title, author)).willReturn(true);
        BookController bookController = new BookController(bookStorage);


        Response response = bookController.addBook(title, author);

        Assert.assertFalse(response.isSuccess());
        Assert.assertEquals(response.getMassage(), "book exist");
        verify(bookStorage, never()).add(title, author);

    }
}
