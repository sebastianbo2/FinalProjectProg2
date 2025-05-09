import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;
import users.BasicMember;
import users.StudentMember;

public class BasicMemberTest {

    @Test
    public void testBorrow_Magazine () {
        BasicMember basicMember = new BasicMember("email", "Johnny", "pass");
        Magazine magazine = new Magazine(1997, "Magazine", "Johnny", 2, "Summary");

        Assertions.assertFalse(basicMember.borrow(magazine));
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
        BasicMember basicMember = new BasicMember("email", "Johnny", "pass");
        ReferenceBook referenceBook = new ReferenceBook(1997, "Magazine", "Johnny", 2);

        Assertions.assertFalse(basicMember.borrow(referenceBook));
    }
}
