package users;

import publications.Publication;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class StudentMember extends User implements Borrowable {
    private Map<Publication, LocalDateTime> borrowedBooks;
    private int studentID;
    private double lateFees;

    public StudentMember(String email, String name, String password, int studentID) {
        super(email, name, password);
        this.studentID = studentID;
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
    public double calculateFees() {
        // TODO

        return 0;
    }

    @Override
    public boolean borrow() {
        // TODO

        return false;
    }
}
