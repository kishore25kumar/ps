package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class DiagonalPrint {
    public void print(final TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode right = root;
        List<TreeNode> diagonal = new ArrayList<TreeNode>();
        List<TreeNode> swapList = new ArrayList<TreeNode>();

        while (right != null) {
            diagonal.add(right);
            right = right.getRight();
        }

        String value = "";
        for (TreeNode t : diagonal) {
            value += t.getValue();
            value += " ";
        }

        System.out.println(value);

        while (diagonal.size() != 0) {
            for (TreeNode t : diagonal) {
                right = t.getLeft();
                while (right != null) {
                    swapList.add(right);
                    right = right.getRight();
                }
            }

            diagonal = new ArrayList<TreeNode>(swapList);
            swapList = new ArrayList<TreeNode>();

            value = "";
            for (TreeNode t : diagonal) {
                value += t.getValue();
                value += " ";
            }

            System.out.println(value);
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
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node8);
        node8.setLeft(node6);
        node8.setRight(node7);

        print(node1);
    }
}
