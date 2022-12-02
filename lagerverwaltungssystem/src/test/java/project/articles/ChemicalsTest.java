package project.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for project.articles.Chemicals
 * @author Ruf, Lukas
 */
public class ChemicalsTest {
    @Test
    void testChemicalsConstructor(){
        Chemicals c = new Chemicals();
        Assertions.assertEquals("corrosive", c.getHazard());
    }

    @Test
    void testChemicalsAttrSet(){
        Chemicals c = new Chemicals("explosive", "name");
        Assertions.assertEquals("explosive", c.getHazard());
        Assertions.assertEquals("name", c.getName());
        Assertions.assertTrue(c.getId().startsWith("C:"));
        Assertions.assertFalse(c.getAvailability());
    }
}
