package LinkedList;

@SuppressWarnings("unchecked")
public class DoublyLinkedList <T>{
    
    private class Node <T>{
        T data;
        Node <T> prev;
        Node <T> next;
        
        public Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        
        public String toString(){
            return this.data.toString();
        }
    }
    
    private Node <T> head;
    
    public DoublyLinkedList(){
        this.head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int size(){
        Node <T> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public void insertAtFirst(T element){
        Node <T> newNode = new Node(element);
        if(!this.isEmpty()){
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtLast(T element){
        
        if(isEmpty()){
            this.insertAtFirst(element);
        } else{
            Node <T> newNode = new Node(element);
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    
    public boolean insertAt(T element, int index){
        int size = this.size();
        if(index < 0 || index > size){
            return false;
        } else if (index == 0){
            this.insertAtFirst(element);
        } else if (index == size){
            this.insertAtLast(element);
        } else {
            int i = 0;
            Node <T> temp = head;
            while(i < index - 1){
                i++;
                temp = temp.next;
            }
            Node <T> newNode = new Node (element);
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next.next;
            temp.prev = newNode;
        }
        return true;
    }
    
    public boolean deleteAtFirst(){
        if(isEmpty()){
            return false;
        } else {
            head = head.next;
            head.prev = null;
            return true;
        }
    }
    
    public boolean deleteAtLast(){
        if(isEmpty()){
            return false;
        } else {
            Node <T> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next.prev = null;
            temp.next = null;
        }
        return true;
    }
    
    public boolean deleteAt(int index){
        int size = this.size();
        if(this.isEmpty() || index < 0 || index >= size){
            return false;
        } else if (index == 0){
            this.deleteAtFirst();
        } else if (index == size - 1){
            this.deleteAtLast();
        } else {
            Node <T> temp = head;
            int i = 0;
            while(i < index - 1){
                i++;
                temp = temp.next;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
        }
        return true;
    }
    
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        Node <T> temp = head;
        
        StringBuilder sb = new StringBuilder().append("[ ");
        while(temp.next != null){
            sb.append(temp.toString()).append(", ");
            temp = temp.next;
        }
        sb.append(temp.toString()).append(" ]\n[ ");
        
        while(temp.prev != null){
            sb.append(temp.toString()).append(", ");
            temp = temp.prev;
        }
        sb.append(temp.toString()).append(" ]");
        return sb.toString();
    }
}
