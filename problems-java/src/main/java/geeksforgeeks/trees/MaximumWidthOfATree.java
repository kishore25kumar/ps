package geeksforgeeks.trees;

import org.junit.*;
import static org.junit.Assert.*;
import utils.list.*;

public class MaximumWidthOfATree {
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

    public int getWidth(final TreeNode root) {
        Boundary boundary = new Boundary();

        updateBoundary(root, 0, boundary);

        return boundary.right - boundary.left;
    }

    @Test
    public void testBasicScenario() {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node8);
        node8.setLeft(node6);
        node8.setRight(node7);

        assertEquals("Maximum width not matching", 5, getWidth(node1));
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
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11);
        TreeNode<Integer> node12 = new TreeNode<Integer>(12);
        TreeNode<Integer> node13 = new TreeNode<Integer>(13);
        TreeNode<Integer> node14 = new TreeNode<Integer>(14);
        TreeNode<Integer> node15 = new TreeNode<Integer>(15);
        TreeNode<Integer> node16 = new TreeNode<Integer>(16);
        TreeNode<Integer> node17 = new TreeNode<Integer>(17);
        TreeNode<Integer> node18 = new TreeNode<Integer>(18);
        TreeNode<Integer> node19 = new TreeNode<Integer>(19);
        TreeNode<Integer> node20 = new TreeNode<Integer>(20);
        TreeNode<Integer> node21 = new TreeNode<Integer>(21);
        TreeNode<Integer> node22 = new TreeNode<Integer>(22);
        TreeNode<Integer> node23 = new TreeNode<Integer>(23);
        TreeNode<Integer> node24 = new TreeNode<Integer>(24);
        TreeNode<Integer> node25 = new TreeNode<Integer>(25);
        TreeNode<Integer> node26 = new TreeNode<Integer>(26);
        TreeNode<Integer> node27 = new TreeNode<Integer>(27);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node6.setLeft(node7);
        node7.setLeft(node8);
        node8.setLeft(node9);
        node9.setLeft(node10);
        node10.setLeft(node11);
        node11.setLeft(node12);
        node12.setRight(node13);
        node13.setRight(node14);
        node14.setRight(node15);
        node15.setRight(node16);
        node16.setRight(node17);
        node17.setRight(node18);
        node18.setRight(node19);
        node19.setRight(node20);
        node20.setRight(node21);
        node21.setRight(node22);
        node22.setRight(node23);
        node23.setRight(node24);
        node24.setRight(node25);
        node25.setRight(node26);
        node26.setRight(node27);

        assertEquals("Maximum width not matching", 15, getWidth(node1));
    }
}
