package project.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;

/**
 * Test class for project.articles.Sport
 * @author Ruf, Lukas
 */
public class SportTest {
    @Test
    void testSportConstructor(){
        Sport s = new Sport("test", 32);
        Assertions.assertEquals("test", s.getName());
        Assertions.assertEquals(32, s.getType());
        Assertions.assertTrue(s.getId().startsWith("S:"));
        Assertions.assertTrue(s.getAvailability());
    }

    @Test
    void testSportsetTypeException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Sport("test", -1);
        });
    }
}
