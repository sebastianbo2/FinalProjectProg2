package publications;

import java.util.Objects;

public class ReferenceBook extends Publication {
    private String returnDate;

    private static final int maxBorrowedLength = 6;

    public ReferenceBook(int year, String title, String author, int availableCopies, String returnDate) {
        super(year, title, author, availableCopies);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReferenceBook that = (ReferenceBook) o;
        return Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), returnDate);
    }

    @Override
    public String toString() {
        return "ReferenceBook{" + super.toString() +
                "returnDate='" + returnDate + '\'' +
                '}';
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
