package users;

import publications.Novel;
import publications.Publication;

import java.time.LocalDateTime;
import java.util.*;

public class BasicMember extends User implements Borrowable, Comparable<BasicMember>{
    private Map<Publication, LocalDateTime> borrowedBooks;
    private double lateFees;

    public BasicMember(String email, String name, String password) {
        super(email, name, password);
        this.borrowedBooks = new HashMap<>();
    }

    public BasicMember(String email, String name, int hashedPassword) {
        super(email, name, hashedPassword);
        this.borrowedBooks = new HashMap<>();
    }

    /**
     * returns a book back to the library, provided that the book has been borrowed already
     * @param publication
     * @param processingLibrarian
     */
    public void returnBook(Publication publication, Librarian processingLibrarian) {
        if (!borrowedBooks.containsKey(publication)) {
            System.out.println("You have not borrowed this book!");
            return;
        }

        processingLibrarian.processReturn(this, publication);
    }

    // UNIMPLEMENTED METHOD
    public boolean payFees() {
        System.out.println("Redirecting..");
        return true;
    }

    /**
     * calculates the fees a member has to pay for a borrowed book (15 cents per missed day)
     * @param publication the book to calculate fees of
     * @return the fees for that book
     */
    @Override
    public double calculateFees(Publication publication) {
        if (!borrowedBooks.containsKey(publication)) {
            System.out.println("Invalid request, you have not borrowed this book!");
            return 0;
        }

        if (borrowedBooks.get(publication).plusYears(1).isAfter(LocalDateTime.now())) {
            return 25;
        }

        return borrowedBooks.get(publication).getDayOfYear() - LocalDateTime.now().getDayOfYear() * 0.05;
    }

    /**
     * borrows a book from the library system, provided it is a novel
     * @param publication the book to borrow
     * @return whether it was successfully borrowed (true) or not (false)
     */
    @Override
    public boolean borrow(Publication publication) {
        if (borrowedBooks.containsKey(publication)) {
            System.out.println("You have already borrowed this book!");
            return false;
        }

        if (publication.getAvailableCopies() < 1) {
            System.out.println("This book is not currently available to borrow, please try another time!");
            return false;
        }

        if (publication instanceof Novel novel) {
            borrowedBooks.put(novel, LocalDateTime.now().plusWeeks(2));
            publication.setAvailableCopies(publication.getAvailableCopies() - 1);
        } else {
            System.out.println("You can only borrow novels, please try a different book!");
        }

        return false;
    }

    @Override
    public int compareTo(BasicMember o) {
        return Double.compare(this.lateFees, o.lateFees);
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

    public double getLateFees() {
        return lateFees;
    }

    public void setLateFees(double lateFees) {
        this.lateFees = lateFees;
    }
}
