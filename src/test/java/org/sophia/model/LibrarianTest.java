package org.sophia.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.sophia.library.BookKeeping;
import org.sophia.library.Books;

public class LibrarianTest extends TestCase {
    BookKeeping bookKeeping = new BookKeeping();
    Librarian librarian = new Librarian("Sophia", "Librarian", "0908");
    LibraryUsers teacherJoy = new LibraryUsers("Joy", "Teacher", "0900");
    LibraryUsers studentJude = new LibraryUsers("Jude", "Student", "0903");
    LibraryUsers pupilFaith = new LibraryUsers("Faith", "Pupil", "0903");
    Books book2 = new Books("Ethanol", "9780128114582", "2019", 1);
    Books book = new Books("Extrusion Cooking", "9780128153604", "2020", 1);
    Books book1 = new Books("Reaching Net Zero", "9780128233665", "2020", 2);


    public void testApproveRequestOne() throws Exception {
        librarian.registerUsers(studentJude);
        librarian.registerUsers(teacherJoy);
        librarian.registerBooks(book2);
        studentJude.borrowRequest("9780128114582");
        teacherJoy.borrowRequest("9780128114582");
        int sizeBeforeTest = bookKeeping.getBorrowedBookRecord().size();
        librarian.approveRequestOne();
        int sizeAfterTest = bookKeeping.getBorrowedBookRecord().size();
        Assert.assertTrue(sizeBeforeTest < sizeAfterTest);
    }

    public void testApproveRequestTwo() throws Exception {
        librarian.registerBooks(book);
        studentJude.borrowRequest("9780128153604");
        teacherJoy.borrowRequest("9780128153604");
        int sizeBeforeTest = bookKeeping.getBorrowedBookRecord().size();
        librarian.approveRequestTwo();
        int sizeAfterTest = bookKeeping.getBorrowedBookRecord().size();
        Assert.assertTrue(sizeBeforeTest < sizeAfterTest);
    }

    public void testRegisterBooks() throws Exception {
        int sizeBeforeTest = bookKeeping.getBookRecord().size();
        librarian.registerBooks(book1);
        int sizeAfterTest = bookKeeping.getBookRecord().size();
        Assert.assertTrue(sizeBeforeTest < sizeAfterTest);
    }

    public void testRegisterUsers() throws Exception {
        int sizeBeforeTest = bookKeeping.getUserRecord().size();
        librarian.registerUsers(pupilFaith);
        int sizeAfterTest = bookKeeping.getUserRecord().size();
        Assert.assertTrue(sizeBeforeTest < sizeAfterTest);

    }
}