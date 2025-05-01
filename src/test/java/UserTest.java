import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import publications.Publication;
import publications.ReferenceBook;
import users.BasicMember;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void testViewPublications_All() {
        User user = new BasicMember("", "", "");

        List<Publication> result = user.viewPublications("");
        List<Publication> expected = new ArrayList<>();

        expected.add(new ReferenceBook(1998, "The story of fire", "John", 2));
        expected.add(new ReferenceBook(1998, "The story of water", "John", 3));

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewPublications_Novels() {
        User user = new BasicMember("", "", "");

        List<Publication> result = user.viewPublications("novel");
        List<Publication> expected = new ArrayList<>();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewPublications_ReferenceBooks() {
        User user = new BasicMember("", "", "");

        List<Publication> result = user.viewPublications("referencebook");
        List<Publication> expected = new ArrayList<>();

        expected.add(new ReferenceBook(1998, "The story of fire", "John", 2));
        expected.add(new ReferenceBook(1998, "The story of water", "John", 3));

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewPublications_Magazines() {
        User user = new BasicMember("", "", "");

        List<Publication> result = user.viewPublications("magazine");
        List<Publication> expected = new ArrayList<>();

        Assertions.assertEquals(expected, result);
    }

}
