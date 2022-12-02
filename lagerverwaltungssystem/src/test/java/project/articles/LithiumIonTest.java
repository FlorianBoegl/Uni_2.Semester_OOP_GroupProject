package project.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for project.articles.LithiumIon
 * @author Ruf, Lukas
 */
public class LithiumIonTest {
    @Test
    void testLithiumIonConstructor(){
        LithiumIon li = new LithiumIon("test");
        Assertions.assertEquals("explosive", li.getHazard());
        Assertions.assertEquals("test", li.getName());
        Assertions.assertTrue(li.getId().startsWith("LI:"));
        Assertions.assertTrue(li.getAvailability());
    }

}
