package geeksforgeeks.trees;

import org.junit.*;
import utils.list.*;

import java.util.*;

public class TreeFromAncestorMatrix {
    public TreeNode getTreeRoot(final Integer[][] ancestorMatrix, final int size) {
        for(int j = 0; j < size; j += 1) {
            int currentParent = -1;
            for (int i = 0; i < size; i += 1) {
                if(ancestorMatrix[i][j] == 1) {
                    if (currentParent == -1) {
                        currentParent = i;
                    } else {
                        if(ancestorMatrix[currentParent][i] == 1) {
                            ancestorMatrix[currentParent][j] = 0;
                            currentParent = i;
                        } else {
                            ancestorMatrix[i][j] = 0;
                        }
                    }
                }
            }
        }

        int parent = -1;

        for (int j = 0; j < size; j += 1) {
            boolean hasParent = true;
            for (int i = 0; i < size; i += 1) {
                if(ancestorMatrix[i][j] == 1) {
                    hasParent = false;
                    break;
                }
            }

            if (hasParent) {
                parent = j;
                break;
            }
        }

        List<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode root = null;

        for (int i = 0; i < size; i += 1) {
            TreeNode<Integer> node = new TreeNode<Integer>(i);
            nodes.add(node);
            if (parent == i) {
                root = node;
            }
        }

        for (int j = 0; j < size; j += 1) {
            for (int i = 0; i < size; i += 1) {
                if (ancestorMatrix[i][j] == 1) {
                    TreeNode parentNode = nodes.get(i);
                    TreeNode childNode = nodes.get(j);

                    if(parentNode.getLeft() == null) {
                        parentNode.setLeft(childNode);
                    } else if (parentNode.getRight() == null) {
                        parentNode.setRight(childNode);
                    }
                }
            }
        }

        return root;
    }

    @Test
    public void basicTest() {
        Integer[][] input = new Integer[][] {
                {0, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };

        TreeNode root = this.getTreeRoot(input, 3);

        List<TreeNode> inOrder = new ArrayList<TreeNode>();

        TreeNode.addInOrder(root, inOrder);

        String value = "";

        for (TreeNode t : inOrder) {
            value += t.getValue();
            value += " ";
        }

        System.out.println(value);
    }

    @Test
    public void basicTest1() {
        Integer[][] input = new Integer[][] {
                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0}
        };

        TreeNode root = this.getTreeRoot(input, 6);

        List<TreeNode> inOrder = new ArrayList<TreeNode>();

        TreeNode.addInOrder(root, inOrder);

        String value = "";

        for (TreeNode t : inOrder) {
            value += t.getValue();
            value += " ";
        }

        System.out.println(value);
    }
}
