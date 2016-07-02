package cci;

import org.junit.*;
import static org.junit.Assert.*;

public class Insertion51Test {
    @Test
    public void testInsert() {
        Insertion51 insertion51 = new Insertion51();
        assertEquals("Output not as expected", insertion51.insert(8, 2, 1, 2), 12);
        assertEquals("Output not as expected", insertion51.insert(1024, 19, 2, 6), 1100);
    }

    @Test
    public void testInsertM1() {
        Insertion51 insertion51 = new Insertion51();
        assertEquals("Output not as expected", insertion51.insertM1(8, 2, 1, 2), 12);
        assertEquals("Output not as expected", insertion51.insertM1(1024, 19, 2, 6), 1100);
    }
}
