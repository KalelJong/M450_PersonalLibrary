package app;
import java.util.Scanner;

public class LibraryApp {
    Library library = new Library();

    public void start() {

        while (true) {
            String menuInput = readString("""
                    ----------------------------------------------------------
                    What would you like to do? 
                    Add List => al 
                    Remove List => rl 
                    Change List name=> cl 
                    Get Lists => l 
                    Add Book => ab 
                    Remove Book => rb
                    Change read status => cr 
                    Get Books from List => bl 
                    Get Book => b 
                    exit => x
                    ----------------------------------------------------------
                    """);
            switch (menuInput) {
                case "al":
                    addList();
                    break;
                case "rl":
                    removeList();
                    break;
                case "cl":
                    changeListName();
                    break;
                case "ab":
                    addBook();
                    break;
                case "rb":
                    removeBook();
                    break;
                case "cr":
                    changeReadStatus();
                    break;
                case "bl":
                    getBooksFromList();
                    break;
                case "b":
                    getBook();
                    break;
                case "l":
                    getLists();
                    break;
                case "x":
                    System.out.println("Goodbye, see you later.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid command!");
            }
        }
    }

    public void addList() {
        String name = readString("What's the name of the list?");
        String creator = readString("What's your name?");

        if (library.add(new BookList(name, creator))) {
            System.out.println("List added");
        } else {
            System.out.println("List with name " + name + " already exists");
        }
    }

    public void removeList() {
        String name = readString("What's the name of the list?");

        if (library.remove(name)) {
            System.out.println("List " + name + " successfully removed");
        } else {
            System.out.println("Failed to remove list " + name);
        }
    }

    public void changeListName() {
        String oldName = readString("What's the current list name?");
        String newName = readString("What's the new list name?");

        var bookList = library.get(oldName);
        if (bookList != null) {
            bookList.setName(newName);
            System.out.println("Successfully changed name from " + oldName + " to " + newName);
        } else {
            System.out.println("Failed to change name from " + oldName + " to " + newName);
        }
    }

    public void addBook() {

        String listName = null;
        boolean listNameValidInput = false;
        while (!listNameValidInput) {
            System.out.println("---------------");
            for (var list : library) {
                System.out.println("[" + library.indexOf(list) + "] " + list.getName() + "  |  " + list.getCreator());
            }
            System.out.println("---------------");
            System.out.println("Add book to list:");
            int idList = readInt("What's the ID of the list?");

            try {
                listNameValidInput = true;
                listName = library.get(idList).getName();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a valid ID!");
            }
        }

        String bookName = readString("What's the book name?");
        String author = readString("Who's the author of the book?");
        Book.Status status = readStatus("What's your read status of the book? (Reading, Dropped, Finished, Pending, Other)");
        int pages = readInt("How many pages has the book?");
        int year = readInt("In which year was the book published?");


        if (library.get(listName).add(new Book(bookName, author, pages, year, status))) {
            System.out.println("Successfully added book " + bookName);
        } else {
            System.out.println("Failed to add book " + bookName);
        }
    }


    public void removeBook() {
        String listName = readString("What's the name of the list from which you want to remove the book?");
        String bookName = readString("What's the name of the book?");

        var bookList = library.get(listName);
        if (bookList.remove(bookName)) {
            System.out.println("Successfully removed " + bookName + " from " + listName);
        } else {
            System.out.println("Failed to remove " + bookName + " from " + listName);
        }
    }

    public void changeReadStatus() {
        String listName = readString("Which list contains the book?");
        String bookName = readString("What's the name of the book?");

        Book.Status status = readStatus("What's the new read status? (Reading, Dropped, Finished, Pending, Other)");

        library.get(listName).getFirstBookByName(bookName).setReadingStatus(status);
    }

    public void getBooksFromList() {
        String listName = readString("What's the name of the list?");
        BookList books = library.get(listName);

        for (Book book : books) {
            System.out.println("--------------------------");
            System.out.println(book.getName() + "\n" + "Author: " + book.getAuthor() + "\n" + "Pages: " + book.getPages() + "\n" + "Published year: " + book.getPublishedYear() + "\n" + "Read Status: " + book.getReadingStatus() + "\n");
        }
    }

    public void getBook() {

        String bookName = readString("What's the name of the book?");

        library.forEach(books -> {
            if (books.getFirstBookByName(bookName) != null) {
                System.out.println("--------------------------");
                System.out.println(books.getFirstBookByName(bookName).getName() + "\n" + "Author: " + books.getFirstBookByName(bookName).getAuthor() + "\n" + "Pages: " + books.getFirstBookByName(bookName).getPages() + "\n" + "Published year: " + books.getFirstBookByName(bookName).getPublishedYear() + "\n" + "Read Status: " + books.getFirstBookByName(bookName).getReadingStatus() + "\n");
            }
        });
    }

    public void getLists() {
        for (BookList list : library) {
            System.out.println("--------------------------");

            System.out.println(list.getName() + "\n" + "Creator: " + list.getCreator() + "\n" + "Books: " + list.size());
        }
    }

    final static Scanner scanner = new Scanner(System.in);

    private String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private Book.Status readStatus(String message) {
        while (true) {
            try {
                return Book.Status.valueOf(readString(message));
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid read status! (Reading, Dropped, Finished, Pending, Other)");
            }
        }
    }

    private int readInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(readString(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}
