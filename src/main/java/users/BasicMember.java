package users;

import publications.Novel;
import publications.Publication;

import java.time.LocalDateTime;
import java.util.*;

public class BasicMember extends User implements Borrowable {
    private Map<Publication, LocalDateTime> borrowedBooks;
    private double lateFees;

    public BasicMember(String email, String name, String password) {
        super(email, name, password);
        this.borrowedBooks = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BasicMember that = (BasicMember) o;
        return Objects.equals(borrowedBooks, that.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), borrowedBooks);
    }

    @Override
    public String toString() {
        return "BasicMember{" + super.toString() +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }

    public Map<Publication, LocalDateTime> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<Publication, LocalDateTime> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
