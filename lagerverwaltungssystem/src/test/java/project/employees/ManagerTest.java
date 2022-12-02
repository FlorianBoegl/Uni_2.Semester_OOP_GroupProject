package project.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManagerTest {
    @Test
    public void testManagerConstructor(){
        Manager m = new Manager("B");
        Assertions.assertEquals("B",m.getName());
        Assertions.assertEquals("Manager",m.getType());
        Assertions.assertNull(m.getAddress());
        Assertions.assertEquals(0,m.getId()%23);
    }
}
