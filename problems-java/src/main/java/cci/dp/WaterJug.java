package cci.dp;

import org.junit.*;

import java.util.*;

public class WaterJug {
    public boolean isPossible(int n, int m, int d, Map<Integer, Boolean> isVisited) {
        if (d == m || d == n) {
            return true;
        }

        if (d == 0 || d > n) {
            return false;
        }

        if (isVisited.get(d) != null && isVisited.get(d) == true) {
            return false;
        }

        isVisited.put(d, true);

        boolean left = isPossible(m, n, m + d, isVisited);
        boolean right = isPossible(m, n, d - m + n, isVisited);

        isVisited.put(d, false);

        return left || right;
    }

    @Test
    public void test1() {
        System.out.println(isPossible(8, 5, 1, new HashMap<Integer, Boolean>()));
    }
}
