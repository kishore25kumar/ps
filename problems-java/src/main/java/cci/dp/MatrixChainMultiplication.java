package cci.dp;

import org.junit.*;

public class MatrixChainMultiplication {
    public int minimumOperations(int start, int end, int[] array) {
        if (end - 1 == start) {
            return 0;
        }
        int minimumOperations = Integer.MAX_VALUE;

        for (int i = start + 1; i < end; i += 1) {
            int left = minimumOperations(start, i, array);
            int right = minimumOperations(i, end, array);

            if (minimumOperations > left + right + (array[start] * array[i] * array[end])) {
                minimumOperations = left + right + (array[start] * array[i] * array[end]);
            }
        }

        return minimumOperations;
    }

    @Test
    public void test1() {
        System.out.println(minimumOperations(0, 3, new int[] {1, 2, 3, 4}));
    }
}
