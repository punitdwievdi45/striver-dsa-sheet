package striversheet.linkedlist;

public class Node {

     Node next;
     int data;

     Node bottom;

     Node random;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public Node() {
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
