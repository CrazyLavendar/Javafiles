
//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/


class AVL_Insert
{
    public  Node insertToAVL(Node node,int data)
    {
        //code here
        if(node==null)
                node = new Node(data);
        else if(node.data > data)
            node.left = insertToAVL(node.left , data);
        else if(node.data < data)
             node.right = insertToAVL(node.right , data);
        else
            return node;
            
        int leftHeight = node.left == null? 0 : node.left.height;
        int rightHeight = node.right == null? 0 : node.right.height;
        
        node.height = Math.max(leftHeight , rightHeight) + 1;
        
        int balFact = leftHeight - rightHeight;
        
        if(balFact > 1 && data < node.left.data){ // LL
            node = rotateRight(node);
        }
        else if(balFact < -1 && data > node.right.data){ // RR
            node = rotateLeft(node);
        }
        else if(balFact > 1 && data > node.left.data){ //LR
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }else if(balFact < -1 && data < node.right.data){ // RL
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        
        return node;
    }
    
    
    public Node rotateLeft(Node X){
            
            Node mid =  X.right;
            Node temp = mid.left;
            X.right = null;
            mid.left  = X;
            X.right = temp;
         X.height = Math.max( X.left == null ? 0 : X.left.height , X.right == null ? 0 : X.right.height) + 1;
         mid.height = Math.max( mid.left == null ? 0 : mid.left.height , mid.right == null ? 0 : mid.right.height) + 1;
         
        return mid;
    }
        public Node rotateRight(Node Y){
        
            Node mid = Y.left;
            Node temp = mid.right;
            Y.left = null;
            mid.right = Y;
            Y.left = temp;
            Y.height = Math.max( Y.left == null ? 0 : Y.left.height , Y.right == null ? 0 : Y.right.height) + 1;
            mid.height = Math.max( mid.left == null ? 0 : mid.left.height , mid.right == null ? 0 : mid.right.height) + 1;
            
        
        return mid;
    }

    

}    