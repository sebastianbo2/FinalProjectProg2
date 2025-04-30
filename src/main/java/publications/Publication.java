package publications;

import java.util.Objects;

public abstract class Publication {
    protected int year;
    protected String title;
    protected String author;
    protected int availableCopies;

    public Publication(int year, String title, String author, int availableCopies) {
        this.year = year;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && availableCopies == that.availableCopies && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, title, author, availableCopies);
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availableCopies=" + availableCopies;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
