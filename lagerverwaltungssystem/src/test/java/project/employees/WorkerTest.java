package project.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class WorkerTest {
    @Test
    public void testWorkerConstructor(){
        Worker w = new Worker("D");
        Assertions.assertEquals("D",w.getName());
        Assertions.assertEquals("Worker",w.getType());
        Assertions.assertNull(w.getAddress());
        Assertions.assertEquals(0,w.getId()%31);
    }
}
