
package LinkedList;

public class CircularDoublyLinkedList<T> {
    
    private class Node <T>{
        T data;
        Node <T> prev;
        Node <T> next;
        
        public Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        
        @Override
        public String toString(){
            return data.toString();
        }
    }
    
    Node <T> head;
    
    public CircularDoublyLinkedList(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    public int size(){
        if(isEmpty()){
            return 0;
        }
        Node <T> temp = head;
        int count = 0;
        do{
            count++;
            temp = temp.next;
        } while(!temp.equals(head));
        return count;
    }
    
    public void insertAtFirst(T data){
        Node<T> newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node <T> temp = head;
            Node <T> tail = head.prev;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            newNode.prev = tail;
            tail.next = head;
        }
    }
    
    public void insertAtLast(T data){
        if(isEmpty()){
            this.insertAtFirst(data);
        } else {
            Node <T> tail = head.prev;
            Node <T> newNode = new Node(data);
            newNode.prev = tail;
            tail.next = newNode;
            newNode.next = head;
            head.prev = newNode;
        }
    }
    
    public boolean insertAt(T data, int index){
        int size = this.size();
        if(index < 0 || index > size){
            return false;
        } else if (index == 0){
            this.insertAtFirst(data);
        } else if (index == size) {
            this.insertAtLast(data);
        } else {
            Node <T> temp = head;
            int i = 0;
            while(i < index - 1){
                i++;
                temp = temp.next;
            }
            Node <T> newNode = new Node(data);
            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
            temp.prev = newNode;
        }
        return true;
    }
    
    public boolean deleteAtFirst(){
        if(isEmpty()){
            return false;
        } else {
            Node <T> tail = head.prev;
            tail.next = head.next;
            head.prev = null;
            head = head.next;
            head.prev = tail;
            return true;
        }
    }
    
    public boolean deleteAtLast(){
        if(isEmpty()){
            return false;
        } else {
            Node <T> tail = head.prev;
            Node <T> temp = tail.prev;
            temp.next = head;
            head.prev = temp;
            tail.next = null;
            tail.prev = null;
            return true;
        }
    }
    
    public boolean deleteAt(int index){
        int size = this.size();
        if(isEmpty() || index < 0 || index >= size){
            return false;
        } else if (index == 0) {
            this.deleteAtFirst();
        } else if (index == size - 1) {
            this.deleteAtLast();
        } else {
            int i = 0;
            Node <T> temp = head;
            while(i < index - 1){
                temp = temp.next;
                i++;
            }
            Node <T> nextTemp = temp.next;
            temp.next = nextTemp.next;
            nextTemp.next.prev = temp;
            nextTemp.prev = null;
            nextTemp.next = null;
        }
        return true;
    }
    
    public String toString(){
        if(isEmpty()){
            return "[]";
        } 
        Node <T>temp = head;
        StringBuilder sb = new StringBuilder().append(head.prev.toString()).append(" <- [ ");
        while(temp.next != head){
            sb.append(temp.toString()).append(", ");
            temp = temp.next;
        }
        sb.append(temp.toString()).append(" ] -> ").append(temp.next.toString()).append("\n").append(temp.next).append(" <- [ ");
        while(temp.prev != head.prev){
            sb.append(temp.toString()).append(", ");
            temp = temp.prev;
        }
        sb.append(temp.toString()).append(" ] -> ").append(temp.prev.toString());
        return sb.toString();
    }
}
