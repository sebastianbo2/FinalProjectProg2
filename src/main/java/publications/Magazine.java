package publications;

import java.util.Objects;

public class Magazine extends Publication {
    private String contentSummary;

    public Magazine(int year, String title, String author, int availableCopies, String contentSummary) {
        super(year, title, author, availableCopies);
        this.contentSummary = contentSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(contentSummary, magazine.contentSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contentSummary);
    }

    @Override
    public String toString() {
        return "Magazine{" + super.toString() +
                "contentSummary='" + contentSummary + '\'' +
                '}';
    }

    public String getContentSummary() {
        return contentSummary;
    }

    public void setContentSummary(String contentSummary) {
        this.contentSummary = contentSummary;
    }
}
