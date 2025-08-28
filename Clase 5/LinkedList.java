package Clase 5;

public class LinkedList {
    private Node head;
    
    public Node getHead(){
        return head;
    }
    public void setHead(Node head){
        this.head = head;
    }
    
    public void add(Object o){
        if( head == null) {
            head = new Node(o);
        }else{
            Node newhead = new Node (o);
            newHead.setNextNode(head);
            head = newHead;
        }
    }

}
