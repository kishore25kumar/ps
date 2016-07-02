package cci.dp;

import org.junit.*;

import java.util.*;

public class TripleStep {
    public int possibleWays(final int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        return possibleWays(n - 1) + possibleWays(n - 2) + possibleWays(n - 3);
    }

    public int possibleWaysMemoziation(final int n, int[] savedValues) {
        int result = savedValues[n];

        if (result != -1) {
            return result;
        }
        if (n == 1) {
            result = 1;
        }

        if (n == 2) {
            result = 2;
        }

        if (n == 3) {
            result = 4;
        }

        result =  possibleWays(n - 1) + possibleWays(n - 2) + possibleWays(n - 3);

        savedValues[n] = result;

        return result;
    }

    public int solution(final int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return possibleWays(n - 1) + possibleWays(n - 2) + possibleWays(n - 3);
    }

    @Test
    public void basicTest() {
        System.out.println(possibleWays(10));
    }

    @Test
    public void test1() {
        int[] savedValues = new int[11];
        Arrays.fill(savedValues, -1);

        System.out.println(possibleWaysMemoziation(10, savedValues));
    }

    @Test
    public void test() {
        System.out.println(solution(10));
    }
}
