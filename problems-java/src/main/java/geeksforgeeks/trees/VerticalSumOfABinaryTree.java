package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

import static org.junit.Assert.*;

public class VerticalSumOfABinaryTree {
    class Boundary {
        int left;
        int right;

        public Boundary() {
            this.left = 0;
            this.right = 0;
        }
    }

    public void updateBoundary(final TreeNode root, int currentDisplacementFromRoot, Boundary boundary) {
        if (root == null) {
            return;
        }

        if (currentDisplacementFromRoot < boundary.left) {
            boundary.left = currentDisplacementFromRoot;
        }

        if (currentDisplacementFromRoot > boundary.right) {
            boundary.right = currentDisplacementFromRoot;
        }

        updateBoundary(root.getLeft(), currentDisplacementFromRoot - 1, boundary);
        updateBoundary(root.getRight(), currentDisplacementFromRoot + 1, boundary);
    }

    public void verticalSum(final TreeNode root, final int currentDisplacementFromRoot, Integer[] sumArray, int maxLeft) {
        if (root == null) {
            return;
        }

        sumArray[currentDisplacementFromRoot - maxLeft] += (Integer) root.getValue();

        verticalSum(root.getLeft(), currentDisplacementFromRoot - 1, sumArray, maxLeft);
        verticalSum(root.getRight(), currentDisplacementFromRoot + 1, sumArray, maxLeft);
    }

    public Integer[] getSum(final TreeNode root) {
        Boundary boundary = new Boundary();

        updateBoundary(root, 0, boundary);

        Integer[] sumArray = new Integer[boundary.right - boundary.left + 1];

        Arrays.fill(sumArray, 0);

        verticalSum(root, 0, sumArray, boundary.left);

        return sumArray;
    }

    @Test
    public void testInput1() {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        Integer[] sumArray = getSum(node1);

        assertEquals("Sum array length is 5", 5, sumArray.length);
        assertEquals(4, (int) sumArray[0]);
        assertEquals(2, (int) sumArray[1]);
        assertEquals(12, (int) sumArray[2]);
        assertEquals(3, (int) sumArray[3]);
        assertEquals(7, (int) sumArray[4]);
    }
}
