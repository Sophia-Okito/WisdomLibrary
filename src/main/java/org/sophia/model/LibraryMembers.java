package org.sophia.model;

import org.sophia.library.BookKeeping;

import java.util.ArrayList;
import java.util.List;

public abstract class LibraryMembers {
    protected String name;
    protected String position;
    protected String phoneNO;
    protected String libraryID;
    protected int priorityLevel;
    private final List searchList;


    public LibraryMembers(String name, String position, String phoneNO) {
        this.name = name;
        this.position = position;
        this.phoneNO = phoneNO;
        searchList = new ArrayList();
        int random = (int) (Math.random() * 1000);
        libraryID = "0000" + name + random;
    }


    //This is used to search for books based on ISBN, Year, and Title.
    public void searchBook(String mood, String keyword) {
        List<List> theCatalog = BookKeeping.getBookRecord();

        switch (mood) {
            case "ISBN": {
                //Checking if book is available in the library

                for (Object o : theCatalog) {
                    List book = (List) o;
                    if (book.get(0).equals(keyword)) {
                        searchList.add(book);
                        System.out.println(searchList.toString() + "\n\n");
                        break;
                    }
                }
                break;
            }
            case "Year": {
                //Checking if book is available in the library

                for (Object o : theCatalog) {
                    List book = (List) o;
                    if (book.get(2).equals(keyword)) {
                        searchList.add(book);
                    }
                }
                System.out.println("*".repeat(30));
                System.out.println(searchList.toString() + "\n\n");
                break;
            }
            case "Title": {

                //Checking if book is available in the library
                for (Object o : theCatalog) {
                    List book = (List) o;
                    if (book.get(1).equals(keyword)) {
                        searchList.add(book);
                        System.out.println("*".repeat(30));
                        System.out.println(searchList.toString() +"\n\n");
                        break;
                    }
                }
                break;
            }
            default:
                System.out.println("*".repeat(30));
                System.out.println("Wrong search mood inputted\n\n");
                break;
        }
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public abstract void getUserInfo();

    public String getName() {
        return name;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
}

