
package LinkedList;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class SinglyLinkedList<T> implements Iterable<T> {
    
    // Internal Class Node
    private class Node<T> {
        T data;
        Node <T> next;
        
        public Node(T data){
            this.data = data;
            this.next = null;
        }
        
        @Override
        public String toString(){
            return data.toString();
        }
    }
    
    private Node <T> head;
    
    public SinglyLinkedList(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null ;
    }
    
    public void insertAtFirst(T data){
        Node <T> newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtLast(T data){
        if(this.isEmpty()){
            this.insertAtFirst(data);
        } else {
            Node <T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }
    
    public int size(){
        //TODO: check whether this is correct or not 
        Node <T> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public boolean insertAt(T data, int index){
        int size = this.size();
        if(index < 0 || index > size){
            return false;
        } else if (index == 0){
            this.insertAtFirst(data);
        } else if(index == size){
            this.insertAtLast(data);
        } else {
            Node <T> temp = head;
            int i = 0;
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
            head = head.next;
            return true;
        }
    }
    
    public boolean deleteAtLast(){
        if(this.isEmpty()){
            return false;
        } else {
            Node <T> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            return true;
        }
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
            int i = 0;
            Node <T> temp = head;
            while(i < index - 1){
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;            
        }
        return true;
    }
    
    public int search(T data){
        if(this.isEmpty()){
            return -1;
        } else {
            Node <T> temp = head;
            int i = 0;
            while(temp.next != null){
                if(temp.data.equals(data)){
                    return i;
                }
                temp = temp.next;
                i++;
            }
            return -1;
        }
    }
    
    @Override
    public String toString(){
        if(isEmpty()){
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder().append("[ ");
            Node <T> temp = head;
            while(temp.next != null){
                sb.append(temp.toString()).append(", ");
                temp = temp.next;
            }
            sb.append(temp.toString()).append(" ]");
            return sb.toString();
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node <T> node = head;
            @Override
            public boolean hasNext(){
                if(node == null){
                    return false;
                }
                return node.next != null ;
            }
            @Override
            public T next(){
                Node <T> temp = node;
                node = node.next;
                return temp.data;
            }
        };
    }    
}
