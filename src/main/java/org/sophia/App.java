package org.sophia;

import org.sophia.library.BookKeeping;
import org.sophia.library.Books;
import org.sophia.model.Librarian;
import org.sophia.model.LibraryUsers;

/**
 * Console Library Application
 *
 */
public class App {
    public static void main( String[] args ) {
        BookKeeping bookKeeping = new BookKeeping();

        Librarian librarian = new Librarian("Sophia", "Librarian", "0908");

        LibraryUsers teacherJoy = new LibraryUsers("Joy", "Teacher", "0900");
        librarian.registerUsers(teacherJoy);

        LibraryUsers teacherJohn = new LibraryUsers("John", "Teacher", "0901");
        librarian.registerUsers(teacherJohn);

        LibraryUsers studentJude = new LibraryUsers("Jude", "Student", "0903");
        librarian.registerUsers(studentJude);

        LibraryUsers pupilFaith = new LibraryUsers("Faith", "Pupil", "0903");
        librarian.registerUsers(pupilFaith);

        Books book = new Books("Extrusion Cooking", "9780128153604", "2020", 1);
        librarian.registerBooks(book);

        Books book1 = new Books("Reaching Net Zero", "9780128233665", "2020", 2);
        librarian.registerBooks(book1);

        Books book2 = new Books("Ethanol", "9780128114582", "2019", 1);
        librarian.registerBooks(book2);

//        studentJude.searchBook("Title", "Extrusion Cooking");

//        bookKeeping.displayUsersRecord();
//        bookKeeping.displayBookRecord();

        pupilFaith.borrowRequest("9780128114582");
        teacherJohn.borrowRequest("9780128233665");
        studentJude.borrowRequest("9780128114582");
        teacherJoy.borrowRequest("9780128153604");


//        bookKeeping.displayRequestList();
//        bookKeeping.displayPrioritizedRequestList();

//        librarian.approveRequestOne();
        librarian.approveRequestTwo();

//        bookKeeping.displayBorrowList();
//        bookKeeping.displayBookRecord();

        studentJude.returnBooks("9780128114582");
//        bookKeeping.displayBorrowList();
//        bookKeeping.displayBookRecord();

    }
}
