package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class PrintRootToLeafPaths {
    public void print(TreeNode root) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        int size = 0;

        if (root == null) {
            return;
        }

        list.add(root);
        size += 1;

        while (size != 0) {
            TreeNode current = list.get(size - 1);

            if (current.getLeft() == null && current.getRight() == null) {
                list.remove(size - 1);
                size -= 1;
            } else if (current.getLeft() != null) {
                list.add(current.getLeft());
                if (current.getLeft().getLeft() == null && current.getLeft().getRight() == null) {
                    String value = "";
                    for (TreeNode t : list) {
                        value += t.getValue();
                        value += " ";
                    }

                    System.out.println(value);
                }
                current.setLeft(null);
                size += 1;
            } else if (current.getRight() != null) {
                list.add(current.getRight());
                if (current.getRight().getLeft() == null && current.getRight().getRight() == null) {
                    String value = "";
                    for (TreeNode t : list) {
                        value += t.getValue();
                        value += " ";
                    }

                    System.out.println(value);
                }
                current.setRight(null);
                size += 1;
            }
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
