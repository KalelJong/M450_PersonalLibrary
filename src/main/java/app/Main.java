package app;

import java.util.*;

public class Main {
    public Library library = new Library();

    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------------------");
            System.out.println("What would you like to do? \n" +
                    "Add List => al \n" +
                    "Remove List => rl \n" +
                    "Change List name=> cl \n" +
                    "Get Lists => l \n" +
                    "Add Book => ab \n" +
                    "Remove Book => rb \n" +
                    "Change read status => cr \n" +
                    "Get Books from List => bl \n" +
                    "Get Book => b \n" +
                    "exit => x");
            String menuInput = scanner.nextLine();

            switch (menuInput) {
                case "al":
                    main.addList();
                    break;
                case "rl":
                    main.removeList();
                    break;
                case "cl":
                    main.changeListName();
                    break;
                case "ab":
                    main.addBook();
                    break;
                case "rb":
                    main.removeBook();
                    break;
                case "cr":
                    main.changeReadStatus();
                    break;
                case "bl":
                    main.getBooksFromList();
                    break;
                case "b":
                    main.getBook();
                    break;
                case "l":
                    main.getLists();
                    break;
                case "x":
                    System.out.println("Goodbye, see you later.");
                    System.exit(0);
                    break;
            }
        }
    }

    public void addList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Add new List:");
        System.out.println("What's the name of the list?");
        String name = scanner.nextLine();

        System.out.println("What's your name?");
        String creator = scanner.nextLine();

        if (library.newBookList(name, creator)) {
            System.out.println("List " + name + " by " + creator + " successfully created");
        } else {
            System.out.println("List with name " + name + " already exists");
        }
    }

    public void removeList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Remove List:");
        System.out.println("What's the name of the list?");
        String name = scanner.nextLine();

        if (library.removeBookList(name)) {
            System.out.println("List " + name + " successfully removed");
        } else {
            System.out.println("Failed to remove list " + name);
        }
    }

    public void changeListName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Change List name:");
        System.out.println("What's the current list name?");
        String oldName = scanner.nextLine();

        System.out.println("What's the new list name?");
        String newName = scanner.nextLine();

        if (library.changeListName(oldName, newName)) {
            System.out.println("Successfully changed name from " + oldName + " to " + newName);
        } else {
            System.out.println("Failed to change name from " + oldName + " to " + newName);
        }
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");

        String listName = null;
        boolean listNameValidInput = false;
        while (!listNameValidInput)
        {
            System.out.println("---------------");
            for (var list: library.getBookLists()) {
                System.out.println("[" + library.getBookLists().indexOf(list) + "] " + list.getName() + "  |  " + list.getCreator());
            }
            System.out.println("---------------");
            System.out.println("Add book to list:");
            System.out.println("What's the ID of the list?");
            int idList = 0;

            try {
                idList = Integer.parseInt(scanner.nextLine());
                listNameValidInput = true;
                listName = library.getBookLists().get(idList).getName();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid format! e.g., 19");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a valid ID! e.g., 19");
            }
        }

        System.out.println("What's the book name?");
        String bookName = scanner.nextLine();

        System.out.println("Who's the author of the book?");
        String author = scanner.nextLine();

        System.out.println("What's your read status of the book? (Reading, Dropped, Finished, Pending, Other)");
        String readStatus = scanner.nextLine();

        System.out.println("How many pages has the book?");
        int pages = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                pages = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number of pages! e.g., 199");
            }
        }

        System.out.println("In which year was the book published?");
        int year = 0;
        validInput = false;
        while (!validInput) {
            try {
                year = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid year! e.g., 1857");
            }
        }

        if (library.addBook(listName, bookName, author, pages, year, readStatus)) {
            System.out.println("Successfully added book " + bookName);
        } else {
            System.out.println("Failed to add book " + bookName);
        }
    }

    public void removeBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Remove book from list:");
        System.out.println("What's the name of the list from which you want to remove the book?");
        String listName = scanner.nextLine();

        System.out.println("What's the name of the book?");
        String bookName = scanner.nextLine();

        if (library.removeBook(listName, bookName)) {
            System.out.println("Successfully removed " + bookName + " from " + listName);
        } else {
            System.out.println("Failed to remove " + bookName + " from " + listName);
        }
    }

    public void changeReadStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Change ReadStatus from book:");
        System.out.println("Which list contains the book?");
        String listName = scanner.nextLine();

        System.out.println("What's the name of the book?");
        String bookName = scanner.nextLine();

        System.out.println("What's the new read status? (Reading, Dropped, Finished, Pending, Other)");
        String readStatus = scanner.nextLine();

        library.changeReadStatus(readStatus, listName, bookName);
    }

    public void getBooksFromList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Get Books from List:");
        System.out.println("What's the name of the list?");
        String listName = scanner.nextLine();

        List<Book> books = library.getBookList(listName).getBooks();

        for (Book book : books) {
            System.out.println("--------------------------");
            System.out.println(book.getName() + "\n" +
                    "Author: " + book.getAuthor() + "\n" +
                    "Pages: " + book.getPages() + "\n" +
                    "Published year: " + book.getPublishedYear() + "\n" +
                    "Read Status: " + book.getReadingStatus() + "\n");
        }
    }

    public void getBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Get app.Book by name:");
        System.out.println("What's the name of the book?");
        String bookName = scanner.nextLine();

        List<Book> books = library.getBook(bookName);

        for (Book book : books) {
            System.out.println("--------------------------");
            System.out.println(book.getName() + "\n" +
                    "Author: " + book.getAuthor() + "\n" +
                    "Pages: " + book.getPages() + "\n" +
                    "Published year: " + book.getPublishedYear() + "\n" +
                    "Read Status: " + book.getReadingStatus() + "\n");
        }
    }

    public void getLists() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Get Lists:");

        List<BookList> lists = library.getBookLists();

        for (BookList list : lists) {
            System.out.println("--------------------------");

            System.out.println(list.getName() + "\n" +
                    "Creator: " + list.getCreator() + "\n" +
                    "Books: " + list.getBooks().size());
        }
    }
}
