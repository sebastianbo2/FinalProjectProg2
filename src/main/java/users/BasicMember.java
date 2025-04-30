package users;

import publications.Novel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicMember extends User implements Borrowable {
    private List<Novel> borrowedBooks;
    private double lateFees;

    public BasicMember(String email, String name, String password) {
        super(email, name, password);
        this.borrowedBooks = new ArrayList<>();
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

    public List<Novel> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Novel> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
