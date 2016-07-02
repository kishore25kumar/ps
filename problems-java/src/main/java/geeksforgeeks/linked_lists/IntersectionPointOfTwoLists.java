package geeksforgeeks.linked_lists;

import org.junit.*;
import utils.list.*;

public class IntersectionPointOfTwoLists {
    public SingleLinkedListNode getIntersectionNode(SingleLinkedListNode l1, SingleLinkedListNode l2) {
        int l1Length = 0;
        int l2Length = 0;
        SingleLinkedListNode l1Copy = l1;
        SingleLinkedListNode l2Copy = l2;

        while (l1Copy != null) {
            l1Length += 1;
            l1Copy = l1Copy.getNext();
        }

        while (l2Copy != null) {
            l2Length += 1;
            l2Copy = l2Copy.getNext();
        }

        while (l1Length < l2Length) {
            l2 = l2.getNext();
            l2Length--;
        }

        while (l2Length < l1Length) {
            l1 = l1.getNext();
            l1Length--;
        }

        while (l1 != l2) {
            l1 = l1.getNext();
            l2 = l2.getNext();
        }

        return l1;
    }

    @Test
    public void test1() {
        SingleLinkedListNode l1 = new SingleLinkedListUtils<Integer>().createList(new Integer[] {1, 2, 3, 4, 5});
        SingleLinkedListNode l2 = new SingleLinkedListUtils<Integer>().createList(new Integer[] {5, 6, 7, 8, 9, 10, 11});

        SingleLinkedListNode l2Copy = l2;
        l2Copy = l2Copy.getNext();
        l2Copy = l2Copy.getNext();
        l2Copy = l2Copy.getNext();
        l2Copy.setNext(l1.getNext());

        System.out.println(getIntersectionNode(l1, l2).getValue());
    }
}
