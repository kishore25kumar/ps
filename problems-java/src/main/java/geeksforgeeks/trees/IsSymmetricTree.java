package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

public class IsSymmetricTree {
    public boolean checkSymmetry(TreeNode<Integer> root, TreeNode<Integer> counterPart) {
        if (root == null && counterPart == null) {
            return true;
        } else if (root != null && counterPart != null) {
            boolean leftSymmetry = checkSymmetry(root.getLeft(), counterPart.getRight());
            if (!leftSymmetry) {
                return leftSymmetry;
            }

            boolean rightSymmetry = checkSymmetry(root.getRight(), counterPart.getLeft());

            if (!rightSymmetry) {
                return rightSymmetry;
            }

            return root.getValue().equals(counterPart.getValue());

        } else {
            return false;
        }
    }

    @Test
    public void test1() {
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node2L = new TreeNode<Integer>(2);
        TreeNode<Integer> node2R = new TreeNode<Integer>(2);
        TreeNode<Integer> node1L = new TreeNode<Integer>(1);
        TreeNode<Integer> node1R = new TreeNode<Integer>(1);
        TreeNode<Integer> node6L = new TreeNode<Integer>(6);
        TreeNode<Integer> node6R = new TreeNode<Integer>(6);

        node4.setLeft(node2L);
        node4.setRight(node2R);
        node2L.setRight(node1L);
        node2R.setLeft(node1R);
        node1L.setLeft(node6L);
        node1R.setRight(node6R);

        System.out.println(checkSymmetry(node4, node4));
    }

    @Test
    public void test2() {
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node2L = new TreeNode<Integer>(2);
        TreeNode<Integer> node2R = new TreeNode<Integer>(2);
        TreeNode<Integer> node1L = new TreeNode<Integer>(1);
        TreeNode<Integer> node1R = new TreeNode<Integer>(2);
        TreeNode<Integer> node6L = new TreeNode<Integer>(6);
        TreeNode<Integer> node6R = new TreeNode<Integer>(6);

        node4.setLeft(node2L);
        node4.setRight(node2R);
        node2L.setRight(node1L);
        node2R.setLeft(node1R);
        node1L.setLeft(node6L);
        node1R.setRight(node6R);

        System.out.println(checkSymmetry(node4, node4));
    }
}
