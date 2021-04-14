package org.sophia.library;

public class BookRequest implements Comparable<BookRequest> {
    private final String borrower;
    private final String isbn;
    private final int priorityLevel;


    public BookRequest(int priorityLevel, String borrower, String isbn) {
        this.priorityLevel = priorityLevel;
        this.borrower = borrower;
        this.isbn = isbn;
    }

    @Override
    public int compareTo(BookRequest o) {
        return o.priorityLevel > this.priorityLevel ? -1 : 1;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
}

