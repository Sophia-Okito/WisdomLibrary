package org.sophia.model;

import org.sophia.library.BookKeeping;
import org.sophia.library.BookRequest;

import java.util.List;

public class LibraryUsers extends LibraryMembers {


    public LibraryUsers(String name, String position, String phoneNO) {
        super(name, position, phoneNO);
    }


    //Searches if the book requested for is available in the library and sends a new request.
    public void borrowRequest(String isbn) {
        List theCatalog = BookKeeping.getBookRecord();
        for (Object o : theCatalog) {
            List book = (List) o;
            if (book.get(0).equals(isbn)) {
                BookRequest bookRequest = new BookRequest(this.getPriorityLevel(), this.getName(), isbn);

                //if book is available sends book request to request list and the priority queue.
                BookKeeping.updateQueue(bookRequest);
                BookKeeping.updatePrioritizedQueue(bookRequest);
                System.out.println("*".repeat(30));
                System.out.println(this.name + " sent a request to borrow book with ISBN " + isbn + "\n\n");
                break;
            }
        }
    }



    //returns borrowed books
    public void returnBooks(String isbn) {
        List theCatalog = BookKeeping.getBookRecord();
        List theBorrowedList = BookKeeping.getBorrowedBookRecord();

        //Checks if the user and the book borrowed are registered in the list of borrowed books.
        for (Object record : theBorrowedList) {
            List theRecord = (List)  record;
            if (isbn.equals(theRecord.get(1)) && this.name.equals(theRecord.get(0))) {
                for (Object book : theCatalog) {
                    List theBook = (List) book;
                    if (theBook.get(0).equals(isbn)) {

                        //It increases the book copies by 1
                        int copies = (int) theBook.get(3);
                        theBook.set(3, copies + 1 );
                        break;
                    }
                }

                //removes user from borrowed book list.
                BookKeeping.getBorrowedBookRecord().remove(record);
                System.out.println("*".repeat(30));
                System.out.println(this.name + " returned book with ISBN " + isbn + "\n\n");
                break;
            }

        }

    }

    @Override
    public void getUserInfo() {
        System.out.println("*".repeat(30));
        System.out.println("Name: " + this.name + "\nPosition: " + this.position + "\nLibrary ID: " + this.libraryID);
        System.out.println("*".repeat(30));
    }


}
