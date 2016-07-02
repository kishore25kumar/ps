package cci.dp;

import org.junit.*;

import java.util.*;

public class RecursiveMultiply {
    public int calculateProduct(int a, int b, Map<Integer, Integer> powerMap) {
        int c = (int) b / 2;

        if (powerMap.get(c) != null && powerMap.get(b - c) != null) {
            return (a << powerMap.get(c)) + (a << powerMap.get(b - c));
        } else if (powerMap.get(c) != null) {
            return (a << powerMap.get(c)) + (calculateProduct(a, b - c, powerMap));
        } else if (powerMap.get(b - c) != null) {
            return (calculateProduct(a, c, powerMap)) + (a << powerMap.get(b - c));
        }else {
            return calculateProduct(a, c, powerMap) + calculateProduct(a, b - c, powerMap);
        }
    }

    @Test
    public void test1() {
        Map<Integer, Integer> powerMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < 32; i += 1) {
            powerMap.put(1 << i, i);
        }

        System.out.println(calculateProduct(0, 4, powerMap));
    }
}
