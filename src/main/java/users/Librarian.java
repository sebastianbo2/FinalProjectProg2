package users;

import org.example.LibrarySystem;
import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Librarian extends User {
    List<BasicMember> basicUsersWithFees;
    List<StudentMember> studentUsersWithFees;

    public Librarian(String email, String name, String password) {
        super(email, name, password);
        this.basicUsersWithFees = new ArrayList<>();
        this.studentUsersWithFees = new ArrayList<>();
    }

    public Librarian(String email, String name, int hashedPassword) {
        super(email, name, hashedPassword);
        this.basicUsersWithFees = new ArrayList<>();
        this.studentUsersWithFees = new ArrayList<>();
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

    /**
     * processes a member's book return and calculates the fees to pay for that book
     * @param basicMember the member returning a book
     * @param publication the book the member is returning
     */
    public void processReturn(BasicMember basicMember, Publication publication) {
        basicMember.getBorrowedBooks().remove(publication);
        basicMember.setLateFees(basicMember.calculateFees(publication));
        publication.setAvailableCopies(publication.getAvailableCopies() + 1);

        if (basicMember.getLateFees() > 0) {
            basicUsersWithFees.add(basicMember);
        }
    }

    /**
     * processes a student's book return and calculates the fees to pay for that book
     * @param student the student returning a book
     * @param publication the book the member is returning
     */
    public void processReturn(StudentMember student, Publication publication) {
        student.getBorrowedBooks().remove(publication);
        student.setLateFees(student.calculateFees(publication));
        publication.setAvailableCopies(publication.getAvailableCopies() + 1);

        if (student.getLateFees() > 0) {
            studentUsersWithFees.add(student);
        }
    }

    public List<StudentMember> viewStudentsWithLateFees() {
        Collections.sort(studentUsersWithFees);

        return studentUsersWithFees;
    }

    public List<BasicMember> viewBasicMembersWithLateFees() {
        Collections.sort(basicUsersWithFees);

        return basicUsersWithFees;
    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() + "}";
    }
}
