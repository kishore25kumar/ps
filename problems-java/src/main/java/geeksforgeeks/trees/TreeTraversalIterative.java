package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class TreeTraversalIterative {
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return;
        }

        while (root != null) {
            stack.push(root);
            root = root.getLeft();
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.getValue() + " ");
            top = top.getRight();
            if (top != null) {
                stack.push(top);

                while (top.getLeft() != null) {
                    stack.push(top.getLeft());
                    top = top.getLeft();
                }
            }
        }

        System.out.println();
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.getValue() + " ");
            if (top.getRight() != null) {
                stack.push(top.getRight());
            }

            if (top.getLeft() != null) {
                stack.push(top.getLeft());
            }
        }

        System.out.println();
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> nonProcessed = new Stack<TreeNode>();
        if (root == null) {
            return;
        }

        stack.push(root);
        nonProcessed.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (!nonProcessed.isEmpty() && nonProcessed.peek() == top) {
                nonProcessed.pop();
                stack.push(top);
                if (top.getRight() != null) {
                    stack.push(top.getRight());
                    nonProcessed.push(top.getRight());
                }

                if (top.getLeft() != null) {
                    stack.push(top.getLeft());
                    nonProcessed.push(top.getLeft());
                }
            } else {
                System.out.print(top.getValue() + " ");
            }
        }

        System.out.println();
    }

    public void postOrderOneStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return;
        }

        do {
            while (root != null) {
                if (root.getRight() != null) {
                    stack.push(root.getRight());
                }

                stack.push(root);
                root = root.getLeft();
            }

            root = stack.pop();

            if (root.getRight() != null && !stack.isEmpty() && root.getRight() == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.getRight();
            } else {
                System.out.print(root.getValue() + " ");
                root = null;
            }
        }while (!stack.isEmpty());
        System.out.println();
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

        node5.setLeft(node2);
        node5.setRight(node6);
        node2.setLeft(node1);
        node2.setRight(node4);
        node4.setLeft(node3);
        node6.setRight(node7);

        preOrder(node5);
        inOrder(node5);
        postOrder(node5);
        postOrderOneStack(node5);
    }
}
