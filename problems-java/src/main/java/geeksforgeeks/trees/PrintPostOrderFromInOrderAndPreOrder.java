package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class PrintPostOrderFromInOrderAndPreOrder {
    public void print(List<Integer> preOrder, List<Integer> inOrder, int rootIndex, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return;
        }

        if (inOrderStart == inOrderEnd) {
            System.out.print(preOrder.get(rootIndex) + " ");
            return;
        }

        int i;

        for (i = inOrderStart; i <= inOrderEnd; i += 1) {
            if (inOrder.get(i).equals(preOrder.get(rootIndex))) {
                break;
            }
        }

        print(preOrder, inOrder, rootIndex + 1, inOrderStart, i - 1);
        print(preOrder, inOrder, rootIndex + (i - inOrderStart) + 1, i + 1, inOrderEnd);

        System.out.print(preOrder.get(rootIndex) + " ");
    }

    @Test
    public void test1() {
        Integer[] inOrder = new Integer[] {4, 2, 5, 1, 3, 6};
        Integer[] preOrder = new Integer[] {1, 2, 4, 5, 3, 6};

        print(Arrays.asList(preOrder), Arrays.asList(inOrder), 0, 0, 5);
    }
}
