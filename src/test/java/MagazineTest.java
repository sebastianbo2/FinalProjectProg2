import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import publications.Magazine;

public class MagazineTest {

    @Test
    public void testViewSummary() {
        String summary = "This magazine covers interesting topics";
        Magazine magazine = new Magazine(1999, "Interesting Magazine", "Johnny", 2, summary);

        Assertions.assertTrue(magazine.viewSummary().equals(magazine.getContentSummary())
                && magazine.viewSummary().equals(summary));
    }
}
