package utils.list;

import java.util.*;

public class SingleLinkedListNode<T> {
    T value;
    SingleLinkedListNode next;

    public SingleLinkedListNode(T value) {
        this.value = value;
    }

    public SingleLinkedListNode getNext() {
        return this.next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }
}
