package cci.dp;

import org.junit.*;

import java.util.*;

public class SubSets {
    public void getSubSets(int start, int end, int count, int[] array, Stack<Integer> set) {
        if (count == 0) {
            System.out.println(set);
            return;
        }

        for(int i = start; i <= end - count; i += 1) {
            set.push(array[i]);
            getSubSets(i + 1, end, count - 1, array, set);
            set.pop();
        }
    }

    public void printAllSubSets(int[] array) {
        for(int i = 1; i <= array.length; i += 1) {
            getSubSets(0, array.length, i, array, new Stack<Integer>());
        }
    }

    @Test
    public void test1() {
        printAllSubSets(new int[] {1, 2, 3, 4});
    }
}
