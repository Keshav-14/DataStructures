
package Stack;

import java.util.Scanner;


public class Test {
    
    public static void main(String [] args){
        
        int[] arr = new int[10];
        System.out.print("Enter the Elements : ");
        Scanner in = new Scanner(System.in);
        for(int i = 0 ; i < 10 ; i++){
            arr[i] = in.nextInt();
        }
        
        MonotonicStack obj = new MonotonicStack(arr);
        Stack <Integer> result = obj.increasingStack();
        while(!result.isEmpty()){
            System.out.print(result.pop() + " ");
        }
        result = obj.decreasingStack();
        while(!result.isEmpty()){
            System.out.println(result.pop() + " ");
        }
    }
}
