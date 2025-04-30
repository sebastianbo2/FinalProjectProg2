package publications;

import java.util.Objects;

public class ReferenceBook extends Publication {
    private static final int maxBorrowedLength = 6;

    public ReferenceBook(int year, String title, String author, int availableCopies) {
        super(year, title, author, availableCopies);
    }

    @Override
    public String toString() {
        return "ReferenceBook{" + super.toString() + "}";
    }
}
