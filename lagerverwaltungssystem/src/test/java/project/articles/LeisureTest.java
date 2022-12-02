package project.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for project.articles.Leisure
 * @author Ruf, Lukas
 */
public class LeisureTest {
    @Test
    void testLeisureConstructor(){
        Leisure l = new Leisure("test", 32);
        Assertions.assertEquals("test", l.getName());
        Assertions.assertEquals(32, l.getType());
        Assertions.assertTrue(l.getId().startsWith("L:"));
        Assertions.assertTrue(l.getAvailability());
    }
}
