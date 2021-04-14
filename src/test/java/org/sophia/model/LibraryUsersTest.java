package org.sophia.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.sophia.library.BookKeeping;
import org.sophia.library.Books;

public class LibraryUsersTest extends TestCase {
    BookKeeping bookKeeping = new BookKeeping();
    Librarian librarian = new Librarian("Sophia", "Librarian", "0908");
    LibraryUsers studentLove = new LibraryUsers("Love", "Student", "0902");
    Books book2 = new Books("Ethanol", "9780128114582", "2019", 1);

    public void testBorrowRequest() {
        librarian.registerUsers(studentLove);
        librarian.registerBooks(book2);
        int sizeBeforeTest = bookKeeping.getBookRequestList().size();
        studentLove.borrowRequest("9780128114582");
        int sizeAfterTest = bookKeeping.getBookRequestList().size();
        Assert.assertTrue(sizeBeforeTest < sizeAfterTest);
    }

    public void testReturnBooks() {
        librarian.approveRequestOne();
        int sizeBeforeTest = bookKeeping.getBorrowedBookRecord().size();
        studentLove.returnBooks("9780128114582");
        int sizeAfterTest = bookKeeping.getBorrowedBookRecord().size();
        Assert.assertTrue(sizeBeforeTest > sizeAfterTest);
    }
}