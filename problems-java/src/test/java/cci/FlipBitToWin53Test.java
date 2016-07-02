package cci;

import org.junit.*;
import static org.junit.Assert.*;
public class FlipBitToWin53Test {
    @Test
    public void testMax1s() {
        FlipBitToWin53 flipBitToWin53 = new FlipBitToWin53();
        assertEquals("Max bits not matching", 8, flipBitToWin53.max1s(1775));
    }
}
