import org.example.LibrarySystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import publications.Magazine;
import publications.Novel;
import publications.ReferenceBook;
import users.Librarian;

public class LibrarianTest {

    @Test
    public void testAddPublication_Novel() {
        Novel novel = new Novel(1998, "The story of water", "John", 3);
        int currSize = LibrarySystem.novels.size();

        Librarian librarian = new Librarian("", "", "");
        librarian.addPublication(novel);

        Assertions.assertTrue(LibrarySystem.novels.size() - 1 == currSize
                && LibrarySystem.novels.get(currSize).equals(novel));
    }

    @Test
    public void testAddPublication_Magazine() {
        Magazine magazine = new Magazine(1998, "The story of water", "John", 3, "Text");
        int currSize = LibrarySystem.magazines.size();

        Librarian librarian = new Librarian("", "", "");
        librarian.addPublication(magazine);

        Assertions.assertTrue(LibrarySystem.magazines.size() - 1 == currSize
                && LibrarySystem.magazines.get(currSize).equals(magazine));
    }

    @Test
    public void testAddPublication_ReferenceBook() {
        ReferenceBook referenceBook = new ReferenceBook(1998, "The story of water", "John", 3);
        int currSize = LibrarySystem.referenceBooks.size();

        Librarian librarian = new Librarian("", "", "");
        librarian.addPublication(referenceBook);

        Assertions.assertTrue(LibrarySystem.referenceBooks.size() - 1 == currSize
                && LibrarySystem.referenceBooks.get(currSize).equals(referenceBook));
    }

    @Test
    public void testRemovePublication_Novel() {
        Novel novel = new Novel(1998, "The story of water", "John", 3);
        int currSize = LibrarySystem.novels.size();

        Librarian librarian = new Librarian("", "", "");
        librarian.removePublication(novel);

        Assertions.assertTrue(LibrarySystem.novels.size() == currSize - 1
                && !LibrarySystem.novels.contains(novel));
    }

    @Test
    public void testRemovePublication_Magazine() {
        Magazine magazine = new Magazine(1998, "The story of water", "John", 3, "Text");
        int currSize = LibrarySystem.magazines.size();

        Librarian librarian = new Librarian("", "", "");
        librarian.removePublication(magazine);

        Assertions.assertTrue(LibrarySystem.magazines.size() == currSize - 1
                && !LibrarySystem.magazines.contains(magazine));
    }

    @Test
    public void testRemovePublication_ReferenceBook() {
        ReferenceBook referenceBook = new ReferenceBook(1998, "The story of water", "John", 3);
        int currSize = LibrarySystem.referenceBooks.size();

        Librarian librarian = new Librarian("", "", "");
        librarian.removePublication(referenceBook);

        Assertions.assertTrue(LibrarySystem.referenceBooks.size() == currSize - 1
                && !LibrarySystem.referenceBooks.contains(referenceBook));
    }
}
