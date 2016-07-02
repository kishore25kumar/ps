package geeksforgeeks.q;

import org.junit.*;

import java.util.*;

public class RottenOranges {
    class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int getMinimumTimeRequired(final int[][] matrix, int maxR, int maxC) {
        Queue<Point> queue = new LinkedList<Point>();

        int rottenCount = 0;

        for(int i = 0; i < maxR; i += 1) {
            for(int j = 0; j < maxC; j += 1) {
                if(matrix[i][j] == 2) {
                    rottenCount += 1;
                    queue.add(new Point(i, j));
                }
            }
        }

        int time = 0;
        int newRottenCount = 0;

        while (!queue.isEmpty()) {
            Point point = queue.peek();

            queue.remove();

            rottenCount -= 1;

            if (point.r + 1 >=0 && point.r + 1 < maxR) {
                if (matrix[point.r + 1][point.c] == 1) {
                    queue.add(new Point(point.r + 1, point.c));
                    matrix[point.r + 1][point.c] = 2;
                    newRottenCount += 1;
                }
            }

            if (point.r - 1 >= 0 && point.r -1 < maxR) {
                if (matrix[point.r - 1][point.c] == 1) {
                    queue.add(new Point(point.r - 1, point.c));
                    matrix[point.r - 1][point.c] = 2;
                    newRottenCount += 1;
                }
            }

            if (point.c + 1 >=0 && point.c + 1 < maxC) {
                if (matrix[point.r][point.c + 1] == 1) {
                    queue.add(new Point(point.r, point.c + 1));
                    matrix[point.r][point.c + 1] = 2;
                    newRottenCount += 1;
                }
            }

            if (point.c - 1 >=0 && point.c - 1 < maxC) {
                if (matrix[point.r][point.c - 1] == 1) {
                    queue.add(new Point(point.r, point.c - 1));
                    matrix[point.r][point.c - 1] = 2;
                    newRottenCount += 1;
                }
            }

            if(rottenCount == 0) {
                rottenCount = newRottenCount;
                time += 1;
                newRottenCount = 0;
            }
        }

        for(int i = 0; i < maxR; i += 1) {
            for(int j = 0; j < maxC; j += 1) {
                if(matrix[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time - 1;
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][] {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        System.out.println(getMinimumTimeRequired(matrix, 3, 5));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][] {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        System.out.println(getMinimumTimeRequired(matrix, 3, 5));
    }
}
