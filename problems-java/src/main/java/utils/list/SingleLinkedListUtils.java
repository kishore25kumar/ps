package utils.list;

public class SingleLinkedListUtils<T> {
    public SingleLinkedListNode createList(T[] inputs) {
        SingleLinkedListNode head = null;
        for (int i = inputs.length - 1; i >= 0; i -= 1) {
            SingleLinkedListNode node = new SingleLinkedListNode(inputs[i]);
            node.setNext(head);
            head = node;
        }

        return head;
    }

    public static void printLinkedList(SingleLinkedListNode singleLinkedListNode) {
        while (singleLinkedListNode != null) {
            System.out.print(singleLinkedListNode.getValue() + " ");
            singleLinkedListNode = singleLinkedListNode.getNext();
        }

        System.out.println();
    }
}
