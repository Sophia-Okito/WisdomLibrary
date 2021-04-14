package org.sophia.library;

public class Books {
    private final String title;
    private final String ISBN;
    private final String publishingYear;
    private final int noOfCopy;

    public Books(String title, String ISBN, String publishingYear, int noOfCopy) {
        this.title = title;
        this.ISBN = ISBN;
        this.publishingYear = publishingYear;
        this.noOfCopy = noOfCopy;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public int getNoOfCopy() {
        return noOfCopy;
    }
}

