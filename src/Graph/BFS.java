
package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    public void traversalBFS(int [][] adj, int source){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        while(!queue.isEmpty()){
            int index = queue.remove();
            System.out.println(index);
            for(int num : adj[index]){
                queue.add(num);
            }
        }
    }
    
}
