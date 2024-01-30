package app;

public class Book {
    private String name;
    private String author;
    private int publishedYear;
    private int pages;
    private Status readStatus;

    public enum Status {
        Reading,
        Dropped,
        Pending,
        Finished,
        Unknown
    }

    public Book(String name, String author, int pages, int publishedYear, String readingStatus) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.pages = pages;

        switch (readingStatus) {
            case "Reading":
                this.readStatus = Status.Reading;
                break;
            case "Dropped":
                this.readStatus = Status.Dropped;
                break;
            case "Pending":
                this.readStatus = Status.Pending;
                break;
            case "Finished":
                this.readStatus = Status.Finished;
                break;
            default:
                this.readStatus = Status.Unknown;
                break;
        }
    }

    public void changeReadStatus(String readingStatus) {
        switch (readingStatus) {
            case "Reading":
                this.readStatus = Status.Reading;
                break;
            case "Dropped":
                this.readStatus = Status.Dropped;
                break;
            case "Pending":
                this.readStatus = Status.Pending;
                break;
            case "Finished":
                this.readStatus = Status.Finished;
                break;
            default:
                this.readStatus = Status.Unknown;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public int getPages() {
        return pages;
    }

    public String getReadingStatus() {
        return readStatus.toString();
    }
}
