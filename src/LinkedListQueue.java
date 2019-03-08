public class LinkedListQueue<E> implements Queue<E> {

    //Linked list to hold all queue elements
    private SinglyLinkedList<E> container;

    //Constructor that initializes the linked list
    public LinkedListQueue() {
        container = new SinglyLinkedList<>();
    }

    //Returns the current queue size
    public int size() {
        return container.size();
    }

    //Checks if the queue is empty
    public boolean isEmpty() {
        return container.isEmpty();
    }

    //Returns the data in the queues first element
    public E first() {
        return container.first();
    }

    //Adds an element to the end of the queue
    public void enqueue(E node) {
        container.addLast(node);
    }

    //Takes an element from the front of the queue and returns it value
    public E dequeue() {
        return container.removeFirst();
    }
}
