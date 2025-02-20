package UNO;

public class PlayQueue<E> {
    class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node(E element) { this.element = element; }
    }

    Node<E> current;

    public PlayQueue() {}

    public void add(E element) { 
        // todo: add the element after current, making sure to maintain
        // circular links both in prev and next directions
    }

    public E getNext() { 
        // todo: if this.forwards == true, advance current to next
        // otherwise advance current to prev before returning current.element
        return null;
     }

    public void reverseDirection() {
        // todo: reverse the direction of play
    }

    public int size() { 
        // todo: count the number of elements in a circular linked list
        // to accomplish this, start at curr and count iterations until returning to current
        return 0; 
    }
}
