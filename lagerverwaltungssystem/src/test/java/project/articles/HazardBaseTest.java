package project.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for project.articles.HazardBase
 * @author Ruf, Lukas
 */
public class HazardBaseTest {
    private Chemicals c;

    @BeforeEach
    void startUp(){
        c = new Chemicals();
    }

    @Test
    void testHazardBaseInstanceOf() { Assertions.assertTrue(c instanceof HazardBase); }

    @Test
    void testHazardBaseAttrSet(){
        c.setHazard("explosive");
        Assertions.assertEquals("explosive", c.getHazard());
    }

    @Test
    void testHazardBaseEquals() {
        Assertions.assertTrue(c.equals(c));

        Object o = new Object();
        Assertions.assertFalse(c.equals(o));

        Chemicals d = new Chemicals();
        d.setHazard("corrosive");
        Assertions.assertTrue(c.equals(d));
    }

    @Test
    void testHazardBaseHashCode() {
        c.setHazard("corrosive");
        c.setName("test");
        c.setType(1);
        c.setId("test");
        Assertions.assertEquals(552898139, c.hashCode());
    }
}
