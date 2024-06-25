
package Stack;

public class Stack <T>{
    T [] stackArray = null;
    int  capacity;
    int top;
    
    public Stack(){
        this.capacity = 10;
        stackArray = (T[]) new Object[this.capacity];
        top = -1;
    }
    
    public Stack(int capacity){
        stackArray = (T[]) new Object[capacity];
        this.capacity = capacity;
        top = -1;
    }
    
    public boolean isFull(){
        return top == capacity - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean push(T element){
        if(!isFull()){
            stackArray[++top] = element;
            return true;
        }
        return false;
    }
    
    public T pop(){
        if(!isEmpty()){
            T poppedElement = stackArray[top];
            stackArray[top--] = null;
            return poppedElement;
        }
        return null;
    }
    
    public T peak(){
        if(isEmpty()){
            return null;
        }
        return this.stackArray[top];
    }
    
    public void clear(){
        while(!isEmpty()){
            this.pop();
        }
    }
}
