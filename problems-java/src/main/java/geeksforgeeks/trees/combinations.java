package geeksforgeeks.trees;

import org.junit.*;

public class combinations {
    public int getCombinations(int start, int end, int[] array) {
        if (end - start <= 2) {
            int number = 0;
            for (int i = start; i < end; i += 1) {
                number = number * 10 + array[i];
            }

            if (number >= 10 && number <= 26) {
                return 3;
            } else if (number < 10) {
                return 1;
            } else {
                return 2;
            }
        }

        int combos = 0;

        for (int i = start + 1; i < end; i += 1) {
            combos += getCombinations(start, i, array) * getCombinations(i, end, array);
        }

        return combos;
    }

    @Test
    public void test1() {
        System.out.println(getCombinations(0, 3, new int[]{1, 1, 2, 3}));
    }
}
