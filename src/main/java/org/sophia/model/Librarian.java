package org.sophia.model;

import org.sophia.library.BookKeeping;
import org.sophia.library.BookRequest;
import org.sophia.library.Books;

import java.util.*;

public class Librarian extends LibraryMembers {

    public Librarian(String name, String position, String phoneNO) {
        super(name, position, phoneNO);
    }


    //Register new library members and update the library users record.
    public void registerUsers(LibraryUsers libraryUsers) {
        List<java.io.Serializable> userInfoList = new ArrayList<>();

        //setting priority level of library users
        if (libraryUsers.position.equals("Teacher")) {
            libraryUsers.setPriorityLevel(0);
        }
        if (libraryUsers.position.equals("Student")) {
            libraryUsers.setPriorityLevel(1);
        }

        if (libraryUsers.position.equals("Pupil")) {
            libraryUsers.setPriorityLevel(2);
        }

        //Recording user info in a list.
        userInfoList.add(libraryUsers.name);
        userInfoList.add(libraryUsers.priorityLevel);
        userInfoList.add(libraryUsers.libraryID);

        //Updating the list of registered users
        BookKeeping.updateUsersRecord(userInfoList);

        System.out.println("*".repeat(30));
        System.out.println(libraryUsers.name + " Your registration was successful and your library ID is " + libraryUsers.libraryID + "\n\n");
    }


    //Registers new books
    public void registerBooks(Books books) {
        List<java.io.Serializable> bookInfoList = new ArrayList<>();
        bookInfoList.add(books.getISBN());
        bookInfoList.add(books.getTitle());
        bookInfoList.add(books.getPublishingYear());
        bookInfoList.add(books.getNoOfCopy());

        //Updating the list of registered books
        BookKeeping.updateBooksRecord(bookInfoList);
        System.out.println("*".repeat(30));
        System.out.println("The book with ISBN of " + books.getISBN() + " was successfully registered\n\n");

    }

    public void approveRequestOne() {

        //Uses the FIFO principle in approving users library request.

        Queue<BookRequest> theRequest = BookKeeping.getBookRequestList();
        List theCatalog = BookKeeping.getBookRecord();

        //Checks if the book requested for is in the library.

        for (Object request : theRequest) {
            BookRequest book = (BookRequest) request;
            String isbn = book.getIsbn();
            for (Object o : theCatalog) {
                List books = (List) o;
                if (books.get(0).equals(isbn)) {
                    int copies = (int) books.get(3);

                    //checks if copies of the requested books is greater than 0;
                    if (copies > 0) {
                        List borrowedBook = new ArrayList<>();
                        borrowedBook.add(book.getBorrower());
                        borrowedBook.add(book.getIsbn());
                        BookKeeping.updateBorrowList(borrowedBook);
                        System.out.println("*".repeat(30));
                        System.out.println(book.getBorrower() + " Your request has been approved.\n\n");

                        //reduces the book copies by 1
                        books.set(3, copies - 1);
                    } else {
                        System.out.println("*".repeat(30));
                        System.out.println(book.getBorrower() + " Your request was unsuccessful due to insufficient books\n\n");
                    }
                    break;
                }
            }
        }
    }

    public void approveRequestTwo() {

        //Uses the priority level of the library users in approving users borrow request.


        Queue<BookRequest> theRequest = BookKeeping.getPrioritizedRequestList();
        List theCatalog = BookKeeping.getBookRecord();

        //Checks if the book requested for is in the library.

        for (Object request : theRequest) {
            BookRequest book = (BookRequest) request;
            String isbn = book.getIsbn();
            for (Object o : theCatalog) {
                List books = (List) o;
                if (books.get(0).equals(isbn)) {
                    int copies = (int) books.get(3);

                    //checks if copies of the requested books is greater than 0;
                    if (copies > 0) {
                        List borrowedbook = new ArrayList<>();
                        borrowedbook.add(book.getBorrower());
                        borrowedbook.add(book.getIsbn());
                        BookKeeping.updateBorrowList(borrowedbook);
                        System.out.println("*".repeat(30));
                        System.out.println(book.getBorrower() + " Your request has been approved.\n\n");
                        //reduces the book copies by 1
                        books.set(3, copies - 1);

                    } else {
                        System.out.println("*".repeat(30));
                        System.out.println(book.getBorrower() + " Your request was unsuccessful due to insufficient books\n\n");
                    }
                    break;
                }
            }
        }

    }

    @Override
    public void getUserInfo() {
        System.out.println("*".repeat(30));
        System.out.println("Name: " + this.name + "\nPosition: " + this.position);
    }
}

