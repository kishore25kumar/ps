package geeksforgeeks.searching_sorting;

import org.junit.*;
import utils.array.*;

public class QuickSort {
    public void sort(int[] input, int start, int end) {
        if (start < end) {
            int partitionIndex = getPartitionIndex(input, start, end);
            sort(input, start, partitionIndex - 1);
            sort(input, partitionIndex + 1, end);
        }
    }

    private int getPartitionIndex(int[] input, int start, int end) {
        int pivot = input[end];
        int i = start;
        for (int j = start; j < end; j += 1) {
            if (input[j] < pivot) {
                ArrayUtils.swap(input, i, j);
                i += 1;
            }
        }

        ArrayUtils.swap(input, i, end);

        return i;
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
