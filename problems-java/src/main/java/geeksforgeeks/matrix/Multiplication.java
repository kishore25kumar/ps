package geeksforgeeks.matrix;

import org.junit.*;

public class Multiplication {
    public int[][] multiply(int[][] m, int[][] n) {
        int[][] output = new int[m.length][n[0].length];
        for(int i = 0; i < m.length; i += 1) {
            for (int j = 0; j < n[0].length; j += 1) {
                int sum = 0;
                for(int k = 0; k < n.length; k += 1) {
                    sum += m[i][k] * n[k][j];
                }
                output[i][j] = sum;
            }
        }

        return output;
    }

    @Test
    public void test1() {
        int[][] m = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };

        int[][] n = new int[][] {
                {1, 6},
                {2, 7},
                {3, 8},
                {4, 9},
                {5, 10}
        };

        int[][] output = multiply(m, n);

        for (int i = 0; i < output.length; i += 1) {
            for (int j = 0; j < output[0].length; j += 1) {
                System.out.println(output[i][j]);
            }
        }
    }
}
