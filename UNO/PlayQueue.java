package UNO;

public class PlayQueue<E> {
    class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node(E element) { this.element = element; }
    }

    Node<E> curr;
    boolean forwards = true;

    public PlayQueue() {}

    public void add(E element) {
        if (curr == null) {
            curr = new Node<>(element);
            curr.next = curr;
            curr.prev = curr;
        } else {
            Node<E> temp = new Node<>(element);
            temp.next = curr.next;
            curr.next = temp;
            temp.prev = curr;
            temp.next.prev = temp;
        }
    }

    public void reverseDirection() {
        forwards = !forwards;
    }

    public E getNext() {
        if (forwards) {
            curr = curr.next;
        } else {
            curr = curr.prev;
        }
        return curr.element;
    }

    public int size() {
        int counter = 0;
        Node<E> next = curr.next;
        while (next != curr) {
            next = next.next;
            counter++;
        }
        return counter;
    }
}
