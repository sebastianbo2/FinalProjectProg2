package publications;

import java.util.Objects;

public class Novel extends Publication {
    private String returnDate;

    private static final int maxBorrowedLength = 3;

    public Novel(int year, String title, String author, int availableCopies) {
        super(year, title, author, availableCopies);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Novel novel = (Novel) o;
        return Objects.equals(returnDate, novel.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), returnDate);
    }

    @Override
    public String toString() {
        return "Novel{" + super.toString() +
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
