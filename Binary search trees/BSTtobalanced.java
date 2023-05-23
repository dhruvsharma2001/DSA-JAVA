import java.util.*;
public class BSTtobalanced {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
    }
    //-----------------PREORDER------------------
    public static void preorder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    //----------INORDER----------------------
    public static void getinorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right, inorder);
        
    }
    //-------------------BALANCED BST--------------
    public static Node createbst(ArrayList<Integer> inorder, int st, int end){
        if(st>end){
            return null;
        }
        int mid =(st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createbst(inorder, st, mid-1);
        root.right = createbst(inorder, mid+1, end);
        return root;
    }
    //-----------CONVERT BALANCED BST
    public static Node balncedbst(Node root){
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getinorder(root, inorder);

        // sorted inorder->balnced bst
        root = createbst(inorder, 0, inorder.size()-1);
        return root;


    }
    //-----------MAIN FUNCTION--------------
    public static void main(String args[]){
        
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balncedbst(root);
        preorder(root);


    }
}
