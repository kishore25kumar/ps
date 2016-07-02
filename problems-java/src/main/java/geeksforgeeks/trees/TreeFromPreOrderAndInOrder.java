package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class TreeFromPreOrderAndInOrder {
    public TreeNode<Integer> getTree(List<Integer> preOrder, List<Integer> inOrder, int rootIndex, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        if (inOrderStart == inOrderEnd) {
            return new TreeNode<Integer>(preOrder.get(rootIndex));
        }

        TreeNode<Integer> root = new TreeNode<Integer>(preOrder.get(rootIndex));
        int i;

        for (i = inOrderStart; i <= inOrderEnd; i += 1) {
            if (inOrder.get(i).equals(root.getValue())) {
                break;
            }
        }

        root.setLeft(getTree(preOrder, inOrder, rootIndex + 1, inOrderStart, i - 1));
        root.setRight(getTree(preOrder, inOrder, rootIndex + (i - inOrderStart) + 1, i + 1, inOrderEnd));

        return root;
    }

    @Test
    public void test1() {
        Integer[] inOrder = new Integer[] {4, 2, 5, 1, 3, 6};
        Integer[] preOrder = new Integer[] {1, 2, 4, 5, 3, 6};

        TreeNode<Integer> root = getTree(Arrays.asList(preOrder), Arrays.asList(inOrder), 0, 0, 5);

        TreeNode.printPostOrder(root);
    }
}
