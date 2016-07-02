package geeksforgeeks.searching_sorting;

import org.junit.*;
import utils.array.*;

public class InsertionSort {
    public void sort(int[] inputArray) {
        for(int i = 1; i < inputArray.length; i += 1) {
            int j = i - 1;
            int temp = inputArray[i];
            while (j >= 0 && temp < inputArray[j]) {
                inputArray[j + 1] = inputArray[j];
                j --;
            }

            inputArray[j + 1] = temp;
        }
    }

    public void sortOptimized(int[] inputArray) {

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
