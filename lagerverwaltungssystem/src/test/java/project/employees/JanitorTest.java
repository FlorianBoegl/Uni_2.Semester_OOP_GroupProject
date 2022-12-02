package project.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JanitorTest {
    @Test
    public void testJanitorConstructor(){
        Janitor j = new Janitor("A");
        Assertions.assertEquals("A",j.getName());
        Assertions.assertEquals("Janitor",j.getType());
        Assertions.assertNull(j.getAddress());
        Assertions.assertEquals(0,j.getId()%37);
    }
}
