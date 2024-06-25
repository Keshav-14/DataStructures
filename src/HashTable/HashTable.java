
package HashTable;
import LinkedList.SinglyLinkedList;

public class HashTable<T> {
    
    SinglyLinkedList<Integer> [] table = null;
    int capacity;
    
    public HashTable(){
        this.capacity = 10;
        this.table = (SinglyLinkedList[]) new Object[this.capacity];
    }
    
    public HashTable(int cap){
        this.capacity = cap;
        this.table = (SinglyLinkedList[]) new Object[this.capacity];
    }
    
    public int hashFunction(int value){
        return value % capacity;
    }
    
    public void insert(int element){
        int index = this.hashFunction(element);
        table[index].insertAtFirst(element);
    }
    
    public int search(int element){
        int index = this.hashFunction(element);
        return table[index].search(element);
    }
    
    public boolean delete(int element){
        int index = this.search(element);
        if(index == -1){
            return false;
        }
        return table[this.hashFunction(element)].deleteAt(index);
    }
    
    @Override
    public String toString(){
        int i = 0;
        StringBuilder sb = new StringBuilder().append("[\n");
        while(i < capacity){
            sb.append(table[i].toString()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
