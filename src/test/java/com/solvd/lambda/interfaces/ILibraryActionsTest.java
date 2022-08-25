package com.solvd.lambda.interfaces;

import com.solvd.other.lambda.interfaces.ILibraryActions;
import org.junit.jupiter.api.Test;

class ILibraryActionsTest {
    int bookCount = 0;

    ILibraryActions addBook = (message, name, author, exists) -> {
        bookCount++;
        System.out.println("Name: " + name
                + "\nAuthor: " + author
                + "\nIs In Storage: " + exists
                + "\n" + message + "\nBook amount in library: " + bookCount);
        System.out.println("-------------------------------");
    };

    ILibraryActions removeBook = (message, name, author, exists) -> {
        bookCount--;
        System.out.println("Name: " + name
                + "\nAuthor: " + author
                + "\nIs In Storage: " + exists
                + "\n" + message + "\nBook amount in library: " + bookCount);
        System.out.println("-------------------------------");
    };

    private void perform(ILibraryActions action, String message, String name, String author, boolean exists) {
        action.applyAction(message, name, author, exists);
    }

    @Test
    public void libraryTest1() {
        System.out.println("Testing Library with lambda function as parameter");
        perform(addBook, "Book has been added!", "Something", "ann", true);
        perform(addBook, "Book has been added!", "Something", "ann", true);
        perform(removeBook, "Book has been removed!", "Something", "ann", false);
        perform(addBook, "Book has been added!", "Something", "ann", true);
        perform(removeBook, "Book has been removed!", "Something", "ann", false);

    }

    @Test
    public void libraryTest2() {
        System.out.println("Testing Library with directly called lambda");
        addBook.applyAction("Book has been added!", "Something", "eleanor", true);
        addBook.applyAction("Book has been added!", "Something", "eleanor", true);
        removeBook.applyAction("Book has been removed!", "Something", "eleanor", false);

    }


}