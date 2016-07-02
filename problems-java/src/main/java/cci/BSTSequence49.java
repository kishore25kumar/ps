package cci;

import java.util.*;
import java.util.concurrent.*;

public class BSTSequence49 {
    public List<List<Integer>> getPossibleArrays(Node node) {
        if (node.left == null && node.right == null) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(node.value);
            ArrayList<List<Integer>> resultOfResults = new ArrayList<List<Integer>>();
            resultOfResults.add(result);
            return resultOfResults;
        }

        List<List<Integer>> leftList = this.getPossibleArrays(node.left);
        List<List<Integer>> rightList = this.getPossibleArrays(node.right);
        return merge(leftList, rightList, node.value);
    }

    public List<List<Integer>> merge(List<List<Integer>> l1, List<List<Integer>> l2, int currentNode) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (List<Integer> l1Item : l1) {
            for (List<Integer> l2Item : l2) {
                weave(l1Item, l2Item, new ArrayList<Integer>(), resultList);
            }
        }

        for (List<Integer> resultListItem : resultList) {
            resultListItem.add(0, currentNode);
        }

        return resultList;
    }

    public void weave (List<Integer> l1, List<Integer> l2, List<Integer> currentWeaveList, List<List<Integer>> allWeaveList) {
        if (l1.size() == 0 || l2.size() == 0) {
            List<Integer> newWeaveList = new ArrayList<Integer>(currentWeaveList);
            newWeaveList.addAll(l1);
            newWeaveList.addAll(l2);
            allWeaveList.add(newWeaveList);
            return;
        }

        int firstHead = l1.get(0);
        l1.remove(0);
        currentWeaveList.add(firstHead);
        weave(l1, l2, currentWeaveList, allWeaveList);
        l1.add(0, firstHead);
        currentWeaveList.remove(currentWeaveList.size() - 1);
        int secondHead = l2.get(0);
        currentWeaveList.add(secondHead);
        l2.remove(0);
        weave(l1, l2, currentWeaveList, allWeaveList);
        l2.add(0, secondHead);
        currentWeaveList.remove(currentWeaveList.size() - 1);
    }

    public static void main(String[] args) {
        BSTSequence49 bstSequence49 = new BSTSequence49();
        Node n10 = new Node(10);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n6 = new Node(6);
        Node n13 = new Node(13);
        Node n12 = new Node(12);
        Node n14 = new Node(14);
        n10.left = n7;
        n10.right = n13;
        n7.left = n6;
        n7.right = n8;
        n13.left = n12;
        n13.right = n14;

        long start = System.currentTimeMillis();
        List<List<Integer>> result = bstSequence49.getPossibleArrays(n10);
        System.out.println("Time is " + (System.currentTimeMillis() - start));
        for (List<Integer> r1 : result) {
            System.out.println(r1.toString());
        }

        System.out.println(result.size());
        System.out.println();
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
