package project.articles;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Test class for testing interactive elements
 * @author Ruf, Lukas
 */
public class InputOutputTest {

    // Preserving the standard streams
    static final InputStream systemInputStream = System.in;
    static final PrintStream systemOutputStream = System.out;

    // custom i/o streams
    static ByteArrayInputStream testInputStream;
    static ByteArrayOutputStream testOutputStream;

    // BeforeEach because I want to reset the output stream every time
    @BeforeEach
    void setUp() {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @AfterAll
    static void tearDown() {
        System.setIn(systemInputStream);
        System.setOut(systemOutputStream);
    }

    void addInput(String s) {
        testInputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(testInputStream);
    }

    String getOut() {
        return testOutputStream.toString();
    }

    @Test
    void testChemicalsAddValid() {
        addInput(String.join("\n", "", "test", "y"));
        try {
            Chemicals r = Chemicals.create();

            Assertions.assertEquals("corrosive", r.getHazard());
            Assertions.assertEquals("test", r.getName());
            Assertions.assertTrue(r.getAvailability());
        } catch (IllegalNameException e) {
            Assertions.assertTrue(false); // uggh
        }
    }

    @Test
    void testChemicalsAddIllegalNameExact() {
        addInput(String.join("\n", "", "bad", "y"));
        Assertions.assertThrows(IllegalNameException.class, () -> {
            Chemicals r = Chemicals.create();
        });
    }

    @Test
    void testChemicalsAddIllegalNameContains() {
        addInput(String.join("\n", "", "badname", "y"));
        Assertions.assertThrows(IllegalNameException.class, () -> {
            Chemicals r = Chemicals.create();
        });
    }

    @Test
    void testSportAddValid() {
        addInput(String.join("\n", "test", "3"));
        Sport r = Sport.create();

        Assertions.assertEquals("test", r.getName());
        Assertions.assertEquals(3, r.getType());
        Assertions.assertTrue(r.getAvailability());
    }

    @Test
    void testSportAddInvalid() {
        addInput(String.join("\n", "test", "a", "3"));
        Sport r = Sport.create();

        Assertions.assertEquals("test", r.getName());
        Assertions.assertEquals(3, r.getType());
        Assertions.assertTrue(r.getAvailability());
        Assertions.assertTrue(getOut().contains("Input has to be an integer"));
    }

    @Test
    void testLeisureAddValid() {
        addInput(String.join("\n", "test", "3"));
        Leisure r = Leisure.create();

        Assertions.assertEquals("test", r.getName());
        Assertions.assertEquals(3, r.getType());
        Assertions.assertTrue(r.getAvailability());
    }

    @Test
    void testLeisureAddInvalid() {
        addInput(String.join("\n", "test", "a", "3"));
        Leisure r = Leisure.create();

        Assertions.assertEquals("test", r.getName());
        Assertions.assertEquals(3, r.getType());
        Assertions.assertTrue(r.getAvailability());
        Assertions.assertTrue(getOut().contains("Input has to be an integer"));
    }

    @Test
    void testLithiumIonAddValid() {
        addInput(String.join("\n", "test"));
        LithiumIon r = LithiumIon.create();

        Assertions.assertEquals("test", r.getName());
        Assertions.assertEquals("explosive", r.getHazard());
        Assertions.assertTrue(r.getAvailability());
    }

    @Test
    void testChooseArticleOperationInvalid() {
        addInput(String.join("\n", "a", "3"));
        Article.chooseArticleOperation();

        Assertions.assertTrue(getOut().contains("Input has to be an integer"));
    }

    @Test
    void testCreateArticleOperationInvalidNotInteger() {
        addInput(String.join("\n", "a", "6"));
        try {
            Article.createArticleOperation();
        } catch (NoSuchMethodException e) {
            Assertions.assertTrue(false);
        }

        Assertions.assertTrue(getOut().contains("Input has to be an integer"));
    }

    @Test
    void testCreateArticleOperationInvalidNotInRange() {
        addInput(String.join("\n", "8", "5"));
        try {
            Article.createArticleOperation();
        } catch (NoSuchMethodException e) {
            Assertions.assertTrue(false);
        }

        Assertions.assertTrue(getOut().contains("Given Integer not in range"));
    }

    @Test
    void testPrintArticlesIsEmpty() {
        try {
            Article.printArticles();
        } catch (IllegalStateException e) {}

        Assertions.assertTrue(getOut().isEmpty());
    }


    @Test
    void testArticlecreateNoSuchMethodException() {
        addInput(String.join("\n", "5"));
        Assertions.assertThrows(NoSuchMethodException.class, () -> {
           Article.createArticleOperation();
        });
    }
}
