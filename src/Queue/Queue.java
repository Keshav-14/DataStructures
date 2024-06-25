
package Queue;

public class Queue <T> {
    T [] queue = null;
    int capacity;
    int front;
    int rear;
    
    public Queue(){
        this.capacity = 10;
        this.queue = (T[]) new Object[this.capacity];
        this.front = -1;
        this.rear = -1;
    }
    
    public Queue(int cap){
        this.capacity = cap;
        this.queue = (T[]) new Object[this.capacity];
        this.front = -1;
        this.rear = -1;
    }
    
    public boolean isEmpty(){
        return (this.front == -1 && this.rear == -1) || (this.front > this.rear);
    }
    
    public boolean isFull(){
        return this.rear == this.capacity - 1;
    }
    
    public boolean enqueue(T element){
        if(!isFull()){
            if(isEmpty()){
                front++;
            }
            this.queue[++rear] = element;
            return true;
        }
        return false;
    }
    
    public T peak(){
        if(isEmpty()){
            return null;
        }
        return this.queue[front];
    }
    
    public T dequeue(){
        if(isEmpty()){
            return null;
        } else {
            T element = queue[front];
            queue[front++] = null;
            return element;
        }
    }
    
    public void clear(){
        while(!isEmpty()){
            this.dequeue();
        }
    }
}
