package users;

import org.example.LibrarySystem;
import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;

import java.util.List;

public class Librarian extends User {
    List<User> usersWithFees;

    public Librarian(String email, String name, String password) {
        super(email, name, password);
    }

    public void addPublication(Publication publication) {
        if (publication instanceof Novel novel) {
            LibrarySystem.novels.add(novel);
        } else if (publication instanceof ReferenceBook referenceBook) {
            LibrarySystem.referenceBooks.add(referenceBook);
        } else if (publication instanceof Magazine magazine){
            LibrarySystem.magazines.add(magazine);
        }

        LibrarySystem.export();
    }

    public void removePublication(Publication publication) {
        if (publication instanceof Novel novel) {
            LibrarySystem.novels.remove(novel);
        } else if (publication instanceof ReferenceBook referenceBook) {
            LibrarySystem.referenceBooks.remove(referenceBook);
        } else if (publication instanceof Magazine magazine){
            LibrarySystem.magazines.remove(magazine);
        }

        LibrarySystem.export();
    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() + "}";
    }
}
