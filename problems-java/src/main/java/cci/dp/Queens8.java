package cci.dp;

import org.junit.*;

public class Queens8 {
    public boolean queens(int n, int[][] matrix) {
        if (n == 0) {
            return true;
        }

        boolean positionFound = false;

        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 8; j += 1) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = -1;
                    positionFound = true;
                    fillBlocking(matrix, i, j, 1);
                    if (queens(n - 1, matrix)) {
                        return true;
                    } else {
                        positionFound = false;
                        fillBlocking(matrix, i, j, -1);
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        return positionFound;
    }

    public void fillBlocking(int[][] matrix, int r, int c, int value) {
        for (int i = 0; i < 8; i += 1) {
            matrix[r][i] += value;
            matrix[i][c] += value;
        }

        matrix[r][c] = -1;

        for (int i = 1; r - i >=0 && c - i >= 0; i += 1) {
            matrix[r-i][c-i] += value;
        }

        for (int i = 1; r + i < 8 && c + i < 8; i += 1) {
            matrix[r + i][c + i] += value;
        }

        for (int i = 1; r - i >=0 && c + i < 8; i += 1) {
            matrix[r - i][c + i] += value;
        }

        for (int i = 1; r + i < 8 && c - i >= 0; i += 1) {
            matrix[r + i][c - i] += value;
        }


//        for (int i = 0; i < 8; i += 1) {
//            String row = "";
//            for (int j = 0; j < 8; j += 1) {
//                row += matrix[i][j];
//                row += " ";
//            }
//
//            System.out.println(row);
//        }
//
//        System.out.println("DONE");
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

        queens(8, matrix);

        for (int i = 0; i < 8; i += 1) {
            String row = "";
            for (int j = 0; j < 8; j += 1) {
                row += matrix[i][j];
                row += " ";
            }

            System.out.println(row);
        }
    }
}
