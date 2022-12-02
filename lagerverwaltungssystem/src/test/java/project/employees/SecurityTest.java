package project.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SecurityTest {
    @Test
    public void testSecurityConstructor(){
        Security s = new Security("C");
        Assertions.assertEquals("C",s.getName());
        Assertions.assertEquals("Security",s.getType());
        Assertions.assertNull(s.getAddress());
        Assertions.assertEquals(0,s.getId()%29);
    }
}
