package LinkedList;


public class Test {
    
    public static void main(String [] args){
        CircularLinkedList <Integer> obj = new CircularLinkedList<>();
        
        obj.insertAtFirst(10);
        obj.insertAtFirst(11);
        obj.insertAtLast(9);
        obj.insertAt(17, 3);
        obj.insertAt(15, 0);
        obj.insertAt(100, 2);
        System.out.println(obj.size());
        obj.deleteAt(5);
        System.out.println(obj.toString());
    }
}
