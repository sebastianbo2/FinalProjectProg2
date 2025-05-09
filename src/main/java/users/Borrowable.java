package users;

import publications.Novel;
import publications.Publication;

public interface Borrowable {
    double calculateFees(Publication publication);

    boolean borrow(Publication publication);
}
