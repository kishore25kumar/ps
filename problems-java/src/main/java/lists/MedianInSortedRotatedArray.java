package lists;

import org.junit.*;

public class MedianInSortedRotatedArray {
    private int getSmallestNumberIndex(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        if (numbers[start] < numbers[end]) {
            return 0;
        }

        while (start <= end) {
            if (start == end) {
                return start;
            }

            int mid = (start + end) / 2;
            if (mid < end && numbers[mid] > numbers[mid + 1]) {
                return mid + 1;
            }

            if (mid > start && numbers[mid] < numbers[mid - 1]) {
                return mid;
            }

            if (numbers[start] <= numbers[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public double median(int[] numbers) {
        int index = getSmallestNumberIndex(numbers);
        if (index == -1) {
            return -1;
        }
        if (numbers.length % 2 == 0) {
            int index1 = numbers.length / 2 - (numbers.length - index);
            int index2 = numbers.length / 2 - 1 - (numbers.length - index);

            if (index1 < 0) {
                index1 = numbers.length + index1;
            }

            if (index2 < 0) {
                index2 = numbers.length + index2;
            }

            return (numbers[index1] + numbers[index2]) / 2.0;
        } else {
            int index1 = numbers.length / 2 - (numbers.length - index);
            if (index1 < 0) {
                index1 = numbers.length + index1;
            }

            return numbers[index1];
        }
    }

    @Test
    public void test1() {
        System.out.println(median(new int[]{6}));
    }
}
