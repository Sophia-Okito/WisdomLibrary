package org.sophia.library;

import java.util.*;

public class BookKeeping {

    private static Set<List> userRecord;                             // stores registered users
    private static List<List> bookRecord;                            // stores registered books
    private static Queue<BookRequest> prioritizedRequestList;        // stores request of books based on priority
    private static Queue<BookRequest> bookRequestList;               // stores request of books based on the FIFO principle
    private static List<List> borrowedBookRecord;                    // stores list of borrowed books and it borrowers

    public BookKeeping() {
        userRecord = new HashSet<>();
        bookRecord = new ArrayList<>();
        bookRequestList = new LinkedList<>();
        prioritizedRequestList = new PriorityQueue<>();
        borrowedBookRecord = new ArrayList<>();
    }

    public static void updateUsersRecord(List userList) { userRecord.add(userList); }

    public void displayUsersRecord() { System.out.println(userRecord.toString()); }



    public static void updateBooksRecord(List bookList) {
        bookRecord.add(bookList);
    }

    public void displayBookRecord() { System.out.println(bookRecord.toString()); }



    public static void updateQueue(BookRequest request) {
        bookRequestList.add(request);
    }

    public void displayRequestList() {

        for (BookRequest request : bookRequestList) {
            System.out.println(request.getBorrower() + " " + request.getIsbn() + " " + request.getPriorityLevel());
            System.out.println();
        }
    }


    public static void updatePrioritizedQueue(BookRequest request) { prioritizedRequestList.add(request); }

    public void displayPrioritizedRequestList() {

        for (BookRequest request : prioritizedRequestList) {
            System.out.println(request.getBorrower() + " " + request.getIsbn() + " " + request.getPriorityLevel());
            System.out.println();
        }
    }


    public static void updateBorrowList(List list) {
        borrowedBookRecord.add(list);
    }

    public static void displayBorrowList() { System.out.println(borrowedBookRecord.toString()); }



    public static List<List> getBookRecord() {
        return bookRecord;
    }

    public static Queue<BookRequest> getPrioritizedRequestList() {
        return prioritizedRequestList;
    }

    public static Queue<BookRequest> getBookRequestList() {
        return bookRequestList;
    }

    public static List<List> getBorrowedBookRecord() { return borrowedBookRecord; }

    public static Set<List> getUserRecord() {
        return userRecord;
    }

}
