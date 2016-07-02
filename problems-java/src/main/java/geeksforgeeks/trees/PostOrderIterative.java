package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class PostOrderIterative {
    public void print(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack1 = new Stack<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> stack2 = new Stack<TreeNode<Integer>>();

        if (root == null) {
            return;
        }

        stack1.push(root);
        stack2.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<Integer> top = stack1.pop();


            if (top.getRight() != null) {
                stack1.add(top.getRight());
                stack2.add(top.getRight());
            }

            if (top.getLeft() != null) {
                stack1.add(top.getLeft());
                stack2.add(top.getLeft());
            }

            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    TreeNode<Integer> output = stack2.pop();
                    System.out.print(output.getValue() + " ");
                }

                break;
            }

            while (stack1.peek() != stack2.peek()) {
                TreeNode<Integer> output = stack2.pop();
                System.out.print(output.getValue() + " ");
            }
        }
    }

    @Test
    public void test1() {
        TreeNode<Integer> n20 = new TreeNode<Integer>(20);
        TreeNode<Integer> n22 = new TreeNode<Integer>(22);
        TreeNode<Integer> n12 = new TreeNode<Integer>(12);
        TreeNode<Integer> n10 = new TreeNode<Integer>(10);
        TreeNode<Integer> n14 = new TreeNode<Integer>(14);
        TreeNode<Integer> n8 = new TreeNode<Integer>(8);
        TreeNode<Integer> n4 = new TreeNode<Integer>(4);

        n20.setRight(n22);
        n20.setLeft(n8);
        n8.setLeft(n4);
        n8.setRight(n12);
        n12.setLeft(n10);
        n12.setRight(n14);

        print(n20);
    }
}
