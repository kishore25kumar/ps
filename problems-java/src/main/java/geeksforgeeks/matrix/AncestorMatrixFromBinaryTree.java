package geeksforgeeks.matrix;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class AncestorMatrixFromBinaryTree {
    public void updateImmediateParent(final TreeNode<Integer> root, final int[][] ancestorMatrix) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            TreeNode<Integer> left = root.getLeft();
            ancestorMatrix[root.getValue()][left.getValue()] = 1;
            updateImmediateParent(root.getLeft(), ancestorMatrix);
        }

        if (root.getRight() != null) {
            TreeNode<Integer> right = root.getRight();
            ancestorMatrix[root.getValue()][right.getValue()] = 1;
            updateImmediateParent(root.getRight(), ancestorMatrix);
        }
    }

    private void updateAncestorMatrix(final int[][] ancestorMatrix, int parent, int child) {
        int columnLength = ancestorMatrix[parent].length;

        for (int i = 0; i < columnLength; i += 1) {
            if (ancestorMatrix[child][i] == 1) {
                ancestorMatrix[parent][i] = 1;
            }
        }
    }

    public void updateAncestors(final TreeNode<Integer> root, final int[][] ancestorMatrix) {
        if(root == null) {
            return;
        }

        if (root.getLeft() != null) {
            updateAncestorMatrix(ancestorMatrix, root.getValue(), (Integer) root.getLeft().getValue());
            updateAncestors(root.getLeft(), ancestorMatrix);
        }

        if (root.getRight() != null) {
            updateAncestorMatrix(ancestorMatrix, root.getValue(), (Integer) root.getRight().getValue());
            updateAncestors(root.getRight(), ancestorMatrix);
        }
    }

    public void print(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i += 1) {
            int columnSize = matrix[i].length;
            String output = "";
            for (int j = 0; j < columnSize; j += 1) {
                output += matrix[i][j];
                output += " ";
            }

            System.out.println(output.trim());
        }
    }

    @Test
    public void test1() {
        TreeNode<Integer> node0 = new TreeNode<Integer>(0);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);

        node5.setLeft(node1);
        node5.setRight(node2);
        node1.setLeft(node0);
        node1.setRight(node4);
        node2.setRight(node3);

        int[][] matrix = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        updateImmediateParent(node5, matrix);
        updateAncestors(node5, matrix);

        print(matrix);
    }
}
