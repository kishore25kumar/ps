package geeksforgeeks.trees;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class MaximumDifferenceBetweenAncestorAndNode {
    public int difference(Node n) {
        updateWithDiff(n);
        return findMaxSum(n, 0, 0);
    }

    private void updateWithDiff(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.diff = root.value - root.left.value;
        }

        if (root.right != null) {
            root.right.diff = root.value - root.right.value;
        }

        updateWithDiff(root.left);
        updateWithDiff(root.right);
    }

    private int findMaxSum(Node root, int maxTillNow, int sum) {
        if (root == null) {
            return maxTillNow;
        }

        sum += root.diff;
        if (sum > maxTillNow) {
            maxTillNow = sum;
        }

        int maxTillNowLeft = findMaxSum(root.left, maxTillNow, sum);
        int maxTillNowRight = findMaxSum(root.right, maxTillNow, sum);
        return Math.max(Math.max(maxTillNowLeft, maxTillNowRight), maxTillNow);
    }

    private int maxDiff(Node root, int diffSum, int maxDiff) {
        if (root == null) {
            return maxDiff;
        }

        if (diffSum > maxDiff) {
            maxDiff = diffSum;
        }

        int maxTillNowLeft = 0;
        int maxTillNowRight = 0;

        if (root.left != null) {
            maxTillNowLeft = maxDiff(root.left, root.value - root.left.value + diffSum, maxDiff);
        }

        if (root.right != null) {
            maxTillNowRight = maxDiff(root.right, root.value - root.right.value + diffSum, maxDiff);
        }

        return Math.max(Math.max(maxTillNowLeft, maxTillNowRight), maxDiff);
    }

    @Test
    public void testDiff() {
        int[] numbers = new int[] {2, 3, 10, 1, 6, 14, 4, 7, 13};
        HashMap<Integer, Node> nodeHashMap = new HashMap<Integer, Node>();
        for (int i = 0; i < numbers.length; i += 1) {
            nodeHashMap.put(numbers[i], new Node(numbers[i]));
        }

        nodeHashMap.get(2).left = nodeHashMap.get(3);
        nodeHashMap.get(2).right = nodeHashMap.get(10);
        nodeHashMap.get(3).left = nodeHashMap.get(1);
        nodeHashMap.get(3).right = nodeHashMap.get(6);
        nodeHashMap.get(6).left = nodeHashMap.get(4);
        nodeHashMap.get(6).right = nodeHashMap.get(7);
        nodeHashMap.get(10).right = nodeHashMap.get(14);
        nodeHashMap.get(14).left = nodeHashMap.get(13);

        assertEquals("Diff not matching", 2, difference(nodeHashMap.get(2)));
        assertEquals("Diff not matching", 2, maxDiff(nodeHashMap.get(2), 0, 0));
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;
    public int diff;
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.diff = 0;
    }
}
