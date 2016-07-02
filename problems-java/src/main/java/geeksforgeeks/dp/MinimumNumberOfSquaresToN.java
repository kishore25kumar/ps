package geeksforgeeks.dp;

import org.junit.*;

import java.util.*;

public class MinimumNumberOfSquaresToN {
    public void minimumSquares(int number, List<Integer> sumOfSquares) {
        if (number == 0) {
            return;
        }

        int i = 1;
        for (; i <= number; i += 1) {
            if (i * i > number) {
                break;
            }
        }

        sumOfSquares.add(i - 1);

        minimumSquares(number - (i - 1) * (i - 1), sumOfSquares);
    }

    public int minimumSquares(int number, Map<Integer, Integer> cache) {
        if (number == 0) {
            return 0;
        }

        int minSquares = number;

        int i = 1;
        for (; i <= number; i += 1) {
            if (i * i > number) {
                break;
            } else {
                if (cache.containsKey(number - i * i)) {
                    minSquares = Math.min(minSquares, 1 + cache.get(number - i * i));
                } else {
                    minSquares = Math.min(minSquares, 1 + minimumSquares(number - i * i, cache));
                }
            }
        }

        if (cache.containsKey(number)) {
            if (cache.get(number) > minSquares) {
                cache.put(number, minSquares);
            }
        } else {
            cache.put(number, minSquares);
        }

        return minSquares;
    }

    @Test
    public void test1() {
        List<Integer> squares = new ArrayList<Integer>();

        minimumSquares(100, squares);

        System.out.println(squares);
    }

    @Test
    public void test2() {
        List<Integer> squares = new ArrayList<Integer>();

        minimumSquares(6, squares);

        System.out.println(squares);
    }

    @Test
    public void test3() {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

        System.out.println(minimumSquares(6, cache));
        cache = new HashMap<Integer, Integer>();
        System.out.println(minimumSquares(12, cache));
        cache = new HashMap<Integer, Integer>();
        System.out.println(minimumSquares(100, cache));
    }
}
