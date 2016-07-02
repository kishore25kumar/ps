package geeksforgeeks.searching_sorting;

import org.junit.*;
import utils.array.*;

public class BubbleSort {
    public void sort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 1) {
            for (int j = 0; j < inputArray.length - i - 1; j += 1) {
                if (inputArray[j] > inputArray[j + 1]) {
                    ArrayUtils.swap(inputArray, j, j + 1);
                }
            }
        }
    }

    @Test
    public void test1() {
        int[] input1 = new int[] {6, 3, 0, 2, 3, 5, 6};
        sort(input1);
        ArrayUtils.print(input1);

        int[] input2 = new int[] {6, 5, 4, 3, 2, 1};
        sort(input2);
        ArrayUtils.print(input2);
    }
}
