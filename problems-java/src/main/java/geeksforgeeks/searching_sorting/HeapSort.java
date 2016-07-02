package geeksforgeeks.searching_sorting;

import org.junit.*;
import utils.array.*;

public class HeapSort {
    public void sort(int[] inputArray, int end) {
        if (end == 0) {
            return;
        }

        heapifyArray(inputArray, end);
        ArrayUtils.swap(inputArray, 0, end);
        sort(inputArray, end - 1);
    }

    public void heapifyArray(int[] inputArray, int end) {
        for(int i = end / 2; i >= 0; i -= 1) {
            heapify(inputArray, i, end);
        }
    }

    public void heapify(int[] inputArray, int index, int end) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild <= end && inputArray[largest] < inputArray[leftChild]) {
            largest = leftChild;
        }

        if (rightChild <= end && inputArray[largest] < inputArray[rightChild]) {
            largest = rightChild;
        }

        if (largest != index) {
            ArrayUtils.swap(inputArray, largest, index);
            heapify(inputArray, largest, end);
        }
    }

    public void sortOptimized(int[] inputArray, int end) {
        for(int i = end / 2; i >= 0; i -= 1) {
            heapify(inputArray, i, end);
        }

        for (int i = end; i > 0; i -= 1) {
            ArrayUtils.swap(inputArray, 0, i);
            heapify(inputArray, 0, i - 1);
        }
    }

    @Test
    public void test1() {
        int[] input1 = new int[] {6, 3, 0, 2, 3, 5, 6};
        sort(input1, input1.length - 1);
        ArrayUtils.print(input1);

        int[] input2 = new int[] {6, 5, 4, 3, 2, 1};
        sort(input2, input2.length - 1);
        ArrayUtils.print(input2);
    }

    @Test
    public void test2() {
        int[] input1 = new int[] {6, 3, 0, 2, 3, 5, 6};
        sortOptimized(input1, input1.length - 1);
        ArrayUtils.print(input1);

        int[] input2 = new int[] {6, 5, 4, 3, 2, 1};
        sortOptimized(input2, input2.length - 1);
        ArrayUtils.print(input2);
    }
}
