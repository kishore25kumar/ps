package geeksforgeeks.searching_sorting;

import org.junit.*;
import utils.array.*;

public class MergeSort {
    public void sort(int[] inputArray, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(inputArray, start, mid);
            sort(inputArray, mid + 1, end);
            merge(inputArray, start, mid, end);
        }
    }

    public void merge(int[] inputArray, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (inputArray[i] < inputArray[j]) {
                temp[k] = inputArray[i];
                k += 1;
                i += 1;
            } else {
                temp[k] = inputArray[j];
                j += 1;
                k += 1;
            }
        }

        while (i <= mid) {
            temp[k] = inputArray[i];
            k += 1;
            i += 1;
        }
        while (j <= end) {
            temp[k] = inputArray[j];
            k += 1;
            j += 1;
        }

        for (i = 0; i < k; i += 1) {
            inputArray[start + i] = temp[i];
        }
    }

    @Test
    public void test1() {
        int[] input1 = new int[] {6, 3, 0, 2, 3, 5, 6};
        sort(input1, 0, input1.length - 1);
        ArrayUtils.print(input1);

        int[] input2 = new int[] {6, 5, 4, 3, 2, 1};
        sort(input2, 0, input2.length - 1);
        ArrayUtils.print(input2);
    }
}
