package geeksforgeeks.searching_sorting;

import org.junit.*;

public class BinarySearch {
    public int searchIterative(int[] inputArray, int searchElement) {
        int start = 0;
        int end = inputArray.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (inputArray[mid] == searchElement) {
                return mid;
            } else if (inputArray[mid] < searchElement) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int searchRecursive(int[] inputArray, int searchElement, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (inputArray[mid] == searchElement) {
            return mid;
        } else if (inputArray[mid] < searchElement) {
            return searchRecursive(inputArray, searchElement, mid + 1, end);
        } else {
            return searchRecursive(inputArray, searchElement, start, mid - 1);
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, searchIterative(new int[]{1, 2, 3, 4, 5, 6}, 3));
        Assert.assertEquals(4, searchIterative(new int[]{1, 2, 3, 4, 5, 6}, 5));
        Assert.assertEquals(0, searchIterative(new int[]{1, 2, 3, 4, 5, 6}, 1));
        Assert.assertEquals(5, searchIterative(new int[]{1, 2, 3, 4, 5, 6}, 6));
        Assert.assertEquals(-1, searchIterative(new int[]{1, 2, 3, 4, 5, 6}, 7));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, searchRecursive(new int[]{1, 2, 3, 4, 5, 6}, 3, 0, 5));
        Assert.assertEquals(4, searchRecursive(new int[]{1, 2, 3, 4, 5, 6}, 5, 0, 5));
        Assert.assertEquals(0, searchRecursive(new int[]{1, 2, 3, 4, 5, 6}, 1, 0, 5));
        Assert.assertEquals(5, searchRecursive(new int[]{1, 2, 3, 4, 5, 6}, 6, 0, 5));
        Assert.assertEquals(-1, searchRecursive(new int[]{1, 2, 3, 4, 5, 6}, 7, 0, 5));
    }
}
