
package LinkedList;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class CircularLinkedList <T> implements Iterable<T>{
    
    private class Node <T>{
        T data;
        Node <T> next;
        
        public Node(T data){
            this.data = data;
            this.next = null;
        }
        
        @Override
        public String toString(){
            return this.data.toString();
        }
    }
    
    private Node <T> head;
    
    public CircularLinkedList(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null ;
    }
    
    public int size(){
        if(isEmpty()){
            return 0;
        }
        int count = 0;
        Node <T> temp = head;
        do{
            count++;
            temp = temp.next;
        }while(!temp.equals(head));
        return count;
    }
    
    public void insertAtFirst(T data){
        Node <T> newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            newNode.next = head;
        } else {
            Node <T> temp = head;
            while(!temp.next.equals(head)){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void insertAtLast(T data){
        Node <T> newNode = new Node(data);
        if(isEmpty()){
            this.insertAtFirst(data);
        } else {
            Node <T> temp = head;
            while(!temp.next.equals(head)){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    
    public boolean insertAt(T data, int index){
        int size = this.size();
        if(index < 0 || index > size){
            return false;
        } else if(index == 0){
            this.insertAtFirst(data);
        } else if(index == size){
            this.insertAtLast(data);
        } else {
            int i = 0;
            Node <T> temp = head;
            while(i < index - 1){
                temp = temp.next;
                i++;
            }
            Node <T> newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return true;
    }
    
    public boolean deleteAtFirst(){
        if(this.isEmpty()){
            return false;
        } else {
            Node <T> temp = head;
            while(!temp.next.equals(head)){
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
            return true;
        }
    }
    
    public boolean deleteAtLast(){
        if(this.isEmpty())
            return false;
        else {
            Node <T> temp = head;
            while(!temp.next.next.equals(head)){
                temp = temp.next;
            }
            temp.next = head;
            return true;
        }
    }
    
    public boolean deleteAt(int index){
        int size = this.size();
        if(this.isEmpty() || index < 0 || index > size){
            return false;
        } else if (index == 0){
            this.deleteAtFirst();
        } else if (index == size){
            this.deleteAtLast();
        } else {
            Node <T> temp = head;
            int i = 0;
            while( i < index - 1){
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        return true;
    }
    
    @Override
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder().append("[ ");
            Node <T> temp = head;
            while(!temp.next.equals(head)){
                sb.append(temp.toString()).append(", ");
                temp = temp.next;
            }
            sb.append(temp.toString()).append(" ] -> ");
            sb.append(temp.next.toString());
            return sb.toString();
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node <T> node = head;
            @Override
            public boolean hasNext() {
                if(node == null){
                    return false;
                }
                return !node.next.equals(head);
            }

            @Override
            public T next() {
                Node <T> temp = node;
                node = node.next;
                return temp.data;
            }
        };
    }
    
}
