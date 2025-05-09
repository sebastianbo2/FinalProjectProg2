package users;

import publications.Magazine;
import publications.Publication;

import java.time.LocalDateTime;
import java.util.*;

public class StudentMember extends User implements Borrowable, Comparable<StudentMember> {
    private Map<Publication, LocalDateTime> borrowedBooks;
    private int studentID;
    private double lateFees;

    public StudentMember(String email, String name, String password, int studentID) {
        super(email, name, password);
        this.studentID = studentID;
        this.borrowedBooks = new HashMap<>();
    }

    public boolean payFees() {
        System.out.println("Redirecting..");
        return true;
    }

    @Override
    public int compareTo(StudentMember o) {
        return Double.compare(this.lateFees, o.lateFees);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentMember that = (StudentMember) o;
        return studentID == that.studentID && Objects.equals(borrowedBooks, that.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), borrowedBooks, studentID);
    }

    @Override
    public String toString() {
        return "StudentMember{" + super.toString() +
                "borrowedBooks=" + borrowedBooks +
                ", studentID=" + studentID +
                '}';
    }

    public Map<Publication, LocalDateTime> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<Publication, LocalDateTime> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

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

    @Override
    public boolean borrow(Publication publication) {
        if (publication instanceof Magazine) {
            System.out.println("Cannot borrow magazine, try another publication!");
            return false;
        }

        if (borrowedBooks.containsKey(publication)) {
            System.out.println("You have already borrowed this book!");
            return false;
        }

        borrowedBooks.put(publication, LocalDateTime.now().plusWeeks(4));
        return true;
    }
}
