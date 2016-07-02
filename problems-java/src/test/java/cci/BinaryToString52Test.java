package cci;

import org.junit.*;
import static org.junit.Assert.*;

public class BinaryToString52Test {
    @Test
    public void testConvert() {
        BinaryToString52 binaryToString52 = new BinaryToString52();
        assertEquals("Not Equals", "101", binaryToString52.convert(0.5));
    }
}
