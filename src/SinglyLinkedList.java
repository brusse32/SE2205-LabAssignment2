public class SinglyLinkedList<E>{

    private Node<E> first, last;
    private int size;

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
  
    public SinglyLinkedList(){

    }
  
    public int size(){
        return size;
    }
  
    public boolean isEmpty(){
        return size == 0;
    }
  
    public E first(){
        return first.getElement();
    }
  
    public E last(){
        return last.getElement();
    }
  
    public void addFirst(E element){
        if(size==0)
            last = first = new Node<>(element, null);
        else
            first = new Node<>(element, first);
        size++;
    }
  
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
  
    public E removeFirst(){
        E element = first();
        first = first.getNext();
        size--;
        return element;
    }

}