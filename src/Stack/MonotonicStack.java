
package Stack;

public class MonotonicStack<T> {
    int [] array = null;
    
    public MonotonicStack(int [] arr){
        this.array = arr;
    }
    
    public Stack <Integer> increasingStack(){
        Stack <Integer> stack = new Stack(this.array.length);
        
        for(int num : array){
            while(!stack.isEmpty() && stack.peak() > num){
                stack.pop();
            }
            stack.push(num);
        }
        return stack;
    }
    
    public Stack <Integer> decreasingStack(){
        Stack <Integer> stack = new Stack(this.array.length);
        for(int num : this.array){
            while(!stack.isEmpty() && stack.peak() < num){
                stack.pop();
            }
            stack.push(num);
        }
        return stack;
    }
}
