package LinkedList;


public class Test {
    
    public static void main(String [] args){
        CircularDoublyLinkedList <Integer> obj = new CircularDoublyLinkedList<>();
        
        obj.insertAtFirst(10);
        obj.insertAtFirst(11);
        obj.insertAtLast(9);
        obj.insertAt(17, 3);
        obj.insertAt(15, 0);
        obj.insertAt(100, 2);
        System.out.println(obj.size());
        obj.deleteAt(2);
        System.out.println(obj.toString());
    }
}
