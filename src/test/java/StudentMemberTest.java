import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;
import users.StudentMember;

public class StudentMemberTest {

    @Test
    public void testBorrow_Magazine () {
        StudentMember student = new StudentMember("email", "Johnny", "pass", 123);
        Magazine magazine = new Magazine(1997, "Magazine", "Johnny", 2, "Summary");

        Assertions.assertFalse(student.borrow(magazine));
    }

    @Test
    public void testBorrow_Novel () {
        StudentMember student = new StudentMember("email", "Johnny", "pass", 123);
        Novel novel = new Novel(1997, "Magazine", "Johnny", 2);

        student.borrow(novel);

        Assertions.assertTrue(student.getBorrowedBooks().containsKey(novel));
    }

    @Test
    public void testBorrow_ReferenceBook () {
        StudentMember student = new StudentMember("email", "Johnny", "pass", 123);
        ReferenceBook referenceBook = new ReferenceBook(1997, "Magazine", "Johnny", 2);

        student.borrow(referenceBook);

        Assertions.assertTrue(student.getBorrowedBooks().containsKey(referenceBook));
    }
}
