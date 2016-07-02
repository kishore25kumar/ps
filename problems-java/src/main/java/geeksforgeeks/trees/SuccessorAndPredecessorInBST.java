package geeksforgeeks.trees;

import utils.list.*;

public class SuccessorAndPredecessorInBST {
    class Solution {
        TreeNode<Integer> successor;
        TreeNode<Integer> predecessor;
    }

    public void successorAndPredecessorInBst(TreeNode<Integer> root, int key, Solution solution) {
        if (root == null) {
            return;
        }

        if (root.getValue() == key) {
            if (root.getLeft() != null) {
                TreeNode<Integer> temp = root.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }

                solution.predecessor = temp;
            }

            if (root.getRight() != null) {
                TreeNode<Integer> temp = root.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }

                solution.successor = temp;

            }

            return;
        }

        if (key < root.getValue()) {
            solution.successor = root;
            successorAndPredecessorInBst(root.getLeft(), key, solution);
        } else {
            solution.predecessor = root;
            successorAndPredecessorInBst(root.getRight(), key, solution);
        }
    }
}
