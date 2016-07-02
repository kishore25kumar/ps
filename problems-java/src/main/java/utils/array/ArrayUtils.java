package utils.array;

public class ArrayUtils {
    public static void print(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 1) {
            System.out.print(inputArray[i] + " ");
        }

        System.out.println();
    }

    public static void swap(int[] inputArray, int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }
}
