package leetcode.trees;

import org.junit.*;
import utils.list.*;

public class SumFromRootToLeaf {
    public int sum(TreeNode<Integer> root, int currentDecimal) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.getLeft(), (currentDecimal + root.getValue()) * 10);
        int rightSum = sum(root.getRight(), (currentDecimal + root.getValue()) * 10);

        if (root.getLeft() == null && root.getRight() == null) {
            return currentDecimal + root.getValue();
        } else {
            return leftSum + rightSum;
        }
    }

    @Test
    public void test1() {
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

        System.out.println(sum(node1, 0));
    }
}
