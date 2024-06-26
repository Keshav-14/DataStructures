
package Tree;

public class BinarySearchTree {
    
    private class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    private int nodeCount;
    public BinarySearchTree(){
        root = null;
        nodeCount = 0;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public boolean insert(int data){
        // duplicates not allowed
        if(search(root, data)){
            return false;
        } else {
            root = add(root, data);
            nodeCount++;
            return true;
        }
    }
    
    private Node add(Node temp, int data){
        if(temp == null){
           temp = new Node(data);
        } else {
            if(data < temp.data){
                temp.left = add(temp.left, data);
            } else {
                temp.right = add(temp.right, data);
            }
        }
        return temp;
    }
    
    public boolean delete(int data){
        if(!isEmpty()){
            root = remove(root, data);
            nodeCount--;
            return true;
        }
        return false;
    }
    
    private Node remove(Node temp, int target){
        
        if(temp == null){
            return temp;
        }
        
        if(temp.data > target){
            // traverse left
            temp.left = remove(temp.left, target);
        } else if(temp.data < target){
            // traverse right
            temp.right = remove(temp.right, target);
        } else {
            // found the target
            
            // one child or no child case
            if(temp.left == null){
                // has no child or only right child
                return temp.right;
            } else if(temp.right == null){
                // has only left child
                return temp.left;
            }else {
                // has both child
                temp.data = minValue(temp.right);
                
                temp.right = remove(temp.right, temp.data);
            }
        }
        return temp;
    }
    
    public int minValue(Node temp) {
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }
    
    public int maxValue(Node temp){
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.data;
                
    }
    
    public boolean search(Node temp, int target){
        if(temp != null){
            if(temp.data == target){
                return true;
            } else {
                if(temp.data > target){
                    return search(temp.left, target);
                } else {
                    return search(temp.right, target);
                }
            }
        } else {
            return false;
        }
    }
    
    public void inOrder(Node temp){
        if(temp != null){
            inOrder(temp.left);
            System.out.print(" " + temp.data + " ");
            inOrder(temp.right);
        }
    }
    
    public void preOrder(Node temp){
        if(temp != null){
            System.out.print(" " + temp.data + " ");
            preOrder(temp.left);
            preOrder(temp.right);
        }
    }
    
    public void postOrder(Node temp){
        if(temp != null){
            postOrder(temp.left);
            postOrder(temp.right);
            System.out.print(" " + temp.data + " ");
        }
    }
}
