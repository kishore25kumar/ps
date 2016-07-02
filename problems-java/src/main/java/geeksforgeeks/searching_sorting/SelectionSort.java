package geeksforgeeks.searching_sorting;

import org.junit.*;
import utils.array.*;

import static utils.array.ArrayUtils.swap;

public class SelectionSort {
    public void sort(int[] inputArray) {
        int minimum;
        int minimumIndex;

        for(int i = 0; i < inputArray.length - 1; i += 1) {
            minimumIndex = i;
            minimum = inputArray[minimumIndex];
            for (int j = i + 1; j < inputArray.length; j += 1) {
                if (minimum > inputArray[j]) {
                    minimum = inputArray[j];
                    minimumIndex = j;
                }
            }

            swap(inputArray, i, minimumIndex);
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
