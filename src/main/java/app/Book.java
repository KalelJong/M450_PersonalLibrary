package app;
public class Book {
    private String name;
    private String author;
    private int publishedYear;
    private int pages;
    private Status readingStatus;

    public enum Status {
        Reading, Dropped, Pending, Finished, Unknown
    }

    public Book(String name, String author, int pages, int publishedYear, Status readingStatus) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.pages = pages;
        this.readingStatus = readingStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Status getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(Status readingStatus) {
        this.readingStatus = readingStatus;
    }
}
