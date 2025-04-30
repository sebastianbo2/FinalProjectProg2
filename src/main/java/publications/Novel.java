package publications;

import java.util.Objects;

public class Novel extends Publication {
    private static final int maxBorrowedLength = 3;

    public Novel(int year, String title, String author, int availableCopies) {
        super(year, title, author, availableCopies);
    }

    @Override
    public String toString() {
        return "Novel{" + super.toString() + "}";
    }
}
