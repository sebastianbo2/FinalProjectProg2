import org.junit.jupiter.api.Test;
import publications.Magazine;
import publications.Publication;
import users.StudentMember;

public class StudentMemberTest {

    @Test
    public void testBorrow_Magazine () {
        StudentMember student = new StudentMember("email", "Johnny", "pass", 123);
        Publication publication = new Magazine(1997, "Magazine", "Johnny", 2, "Summary");

        // TODO
    }

    @Test
    public void testBorrow_Novel () {
        StudentMember student = new StudentMember("email", "Johnny", "pass", 123);

        // TODO
    }

    @Test
    public void testBorrow_ReferenceBook () {
        StudentMember student = new StudentMember("email", "Johnny", "pass", 123);

        // TODO
    }
}
