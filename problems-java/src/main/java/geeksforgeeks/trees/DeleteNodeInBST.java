package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class DeleteNodeInBST {
    public int getMaximumElementInLeft(TreeNode<Integer> root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }

        return root.getValue();
    }

    public int getMinimumElementInRight(TreeNode<Integer> root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }

        return root.getValue();
    }

    public TreeNode<Integer> getNodeToDelete(TreeNode<Integer> root, int value) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == value) {
            if (root.getLeft() != null) {
                int leftMax = this.getMaximumElementInLeft(root.getLeft());
                root.setValue(leftMax);
                TreeNode<Integer> response = getNodeToDelete(root.getLeft(), leftMax);

                if (response != null) {
                    return response;
                }
            } else if (root.getRight() != null) {
                int rightMin = this.getMinimumElementInRight(root.getRight());
                root.setValue(rightMin);
                TreeNode<Integer> response = getNodeToDelete(root.getRight(), rightMin);

                if (response != null) {
                    return response;
                }
            } else {
                return root;
            }
        }

        TreeNode<Integer> leftResp = getNodeToDelete(root.getLeft(), value);
        if (leftResp != null) {
            return leftResp;
        }

        TreeNode<Integer> rightResp = getNodeToDelete(root.getRight(), value);
        if (rightResp != null) {
            return rightResp;
        }

        return null;
    }

    public void deleteNode(TreeNode<Integer> root, TreeNode<Integer> nodeToDelete) {
        if (root == null) {
            return;
        }

        if (root.getLeft() == nodeToDelete) {
            root.setLeft(null);
            return;
        }

        if (root.getRight() == nodeToDelete) {
            root.setRight(null);
            return;
        }

        deleteNode(root.getLeft(), nodeToDelete);
        deleteNode(root.getRight(), nodeToDelete);
    }

    public TreeNode<Integer> deleteNodeInBst(TreeNode<Integer> root, int value) {
        TreeNode<Integer> nodeToDelete = this.getNodeToDelete(root, value);
        if (nodeToDelete != null) {
            if (nodeToDelete == root) {
                return null;
            }

            deleteNode(root, nodeToDelete);
            return root;
        } else {
            return null;
        }
    }

    @Test
    public void test1() {
        TreeNode<Integer> node24 = new TreeNode<Integer>(24);
        TreeNode<Integer> node16 = new TreeNode<Integer>(16);
        TreeNode<Integer> node12 = new TreeNode<Integer>(12);
        TreeNode<Integer> node20 = new TreeNode<Integer>(20);
        TreeNode<Integer> node18 = new TreeNode<Integer>(18);
        TreeNode<Integer> node22 = new TreeNode<Integer>(22);
        TreeNode<Integer> node48 = new TreeNode<Integer>(48);
        TreeNode<Integer> node30 = new TreeNode<Integer>(30);
        TreeNode<Integer> node96 = new TreeNode<Integer>(96);
        TreeNode<Integer> node70 = new TreeNode<Integer>(70);

        node24.setLeft(node16);
        node24.setRight(node48);
        node16.setLeft(node12);
        node16.setRight(node20);
        node20.setLeft(node18);
        node20.setRight(node22);
        node48.setLeft(node30);
        node48.setRight(node96);
        node96.setLeft(node70);

        TreeNode<Integer> root = this.deleteNodeInBst(node24, node16.getValue());
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode.addInOrder(root, nodes);

        for (int i = 0; i < nodes.size(); i += 1) {
            System.out.print(nodes.get(i).getValue() + " ");
        }
    }
}
