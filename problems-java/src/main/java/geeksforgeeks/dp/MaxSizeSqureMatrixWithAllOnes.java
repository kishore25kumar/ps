package geeksforgeeks.dp;

import org.junit.*;

public class MaxSizeSqureMatrixWithAllOnes {
    public int getMaxSizeSquare(int[][] matrix, int rows, int columns) {
        int best = 0;

        if (rows < columns) {
            for (int i = 0; i < columns - rows; i += 1) {
                int value = getMaxSizeSquare(matrix, 0, i, rows, rows + i);

                if (best < value) {
                    best = value;
                }
            }
        } else {
            for (int i = 0; i < rows - columns; i += 1) {
                int value = getMaxSizeSquare(matrix, i, 0, columns + i, columns);

                if (best < value) {
                    best = value;
                }
            }
        }

        return best;
    }

    public int getMaxSizeSquare(int[][] matrix, int startR, int startC, int endR, int endC) {
        if (startR >= endR || startC >= endC) {
            return 0;
        }

        boolean hasAllOnes = true;

        for (int i = startR; i < endR; i += 1) {
            for (int j = startC; j < endC; j += 1) {
                if (matrix[i][j] == 0) {
                    hasAllOnes = false;
                    break;
                }
            }
        }

        if (hasAllOnes) {
            return endR - startR;
        }

        int r1 = getMaxSizeSquare(matrix, startR + 1, startC + 1, endR, endC);
        int r2 = getMaxSizeSquare(matrix, startR, startC, endR - 1, endC - 1);
        int r3 = getMaxSizeSquare(matrix, startR + 1, startC, endR, endC - 1);
        int r4 = getMaxSizeSquare(matrix, startR, startC + 1, endR - 1, endC);

        return Math.max(Math.max(r1, r2), Math.max(r3, r4));
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][] {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        System.out.println(getMaxSizeSquare(matrix, 6, 5));
    }

    @Test
    public void test2 () {
        int[][] matrix = new int[][] {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
        };

        System.out.println(getMaxSizeSquare(matrix, 4, 5));
    }

    @Test
    public void test3 () {
        int[][] matrix = new int[][] {
                {0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 0, 1, 0}
        };

        System.out.println(getMaxSizeSquare(matrix, 4, 5));
    }

    @Test
    public void test4 () {
        int[][] matrix = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(getMaxSizeSquare(matrix, 4, 5));
    }
}
