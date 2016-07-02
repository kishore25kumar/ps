package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class BST1ToN {
    public List<TreeNode<Integer>> getSolutions(int root, List<TreeNode<Integer>> leftSolutions, List<TreeNode<Integer>> rightSolutions) {
        List<TreeNode<Integer>> solutions = new ArrayList<TreeNode<Integer>>();

        for (int i = 0; i < leftSolutions.size(); i += 1) {
            for (int j = 0; j < rightSolutions.size(); j += 1) {
                TreeNode<Integer> rootNode = new TreeNode<Integer>(root);
                rootNode.setLeft(leftSolutions.get(i));
                rootNode.setRight(rightSolutions.get(j));
                solutions.add(rootNode);
            }
        }

        return solutions;
    }
    public List<TreeNode<Integer>> allBst(int start, int end) {
        List<TreeNode<Integer>> solutions = new ArrayList<TreeNode<Integer>>();
        if (start > end) {
            solutions.add(null);
        } else {
            for (int i = start; i <= end; i += 1) {
                List<TreeNode<Integer>> solutionsLeft = allBst(start, i - 1);
                List<TreeNode<Integer>> solutionsRight = allBst(i + 1, end);
                solutions.addAll(getSolutions(i + 1, solutionsLeft, solutionsRight));
            }
        }

        return solutions;
    }

    @Test
    public void test1() {
        List<TreeNode<Integer>> solutions = allBst(0, 2);

        System.out.println(solutions);
    }
}
