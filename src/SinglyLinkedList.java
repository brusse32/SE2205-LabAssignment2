public class SinglyLinkedList<E>{

    //Nodes to keep track of the first and last elements in the list
    private Node<E> first, last;

    //Size of the list
    private int size;

    //Private Node class to store data and a reference to the next node in the list
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E e, Node<E> n){
            data = e;
            next = n;
        }
        public E getElement(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }

    //Default constructor
    public SinglyLinkedList(){

    }

    //Returns the size of the list
    public int size(){
        return size;
    }

    //Checks if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //Returns the data stored in the first node
    public E first(){
        return first.getElement();
    }

    //Returns the data stored in the last node
    public E last(){
        return last.getElement();
    }

    //Adds a node to the front of the list
    public void addFirst(E element){
        if(size==0)
            last = first = new Node<>(element, null);
        else
            first = new Node<>(element, first);
        size++;
    }

    //Adds a node to the end of the list
    public void addLast(E element){
        if(size==0){
            addFirst(element);
            return;
        }
        Node<E> newLast = new Node<>(element, null);
        last.setNext(newLast);
        last = newLast;
        size++;
    }

    //Removes the node at the front of the list
    public E removeFirst(){
        E element = first();
        first = first.getNext();
        size--;
        return element;
    }

}