
package Graph;

import java.util.Stack;


public class DFS {
    
    public void iterativeDFS(int adj[][], int source){
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(source);
        while(!stack.isEmpty()){
            int index = stack.pop();
            System.out.println(index);
            for(int num : adj[index]){
                stack.push(num);
            }
        }
    }
    
    public void recursiveDFS(int adj[][], int source){
        System.out.println(source);
        for(int num : adj[source]){
            recursiveDFS(adj, source);
        }
    }
    
    public boolean hasPath(int adj[][], int source, int destination){
        if(source == destination){
            return true;
        }
        for(int num : adj[source]){
            if(hasPath(adj, num, destination))
                return true;
        }
        return false;
    }
    
}
