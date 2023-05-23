import java.util.*;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;

        }
    }
//-----------------INSER A NODE---------------
    public static Node insert(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;

        }

        if(root.data>val){
            //left subtree
            root.left = insert(root.left,val);
        }
        else{
            //right subtree
            root.right = insert(root.right,val);
        }
        return root;

    }
    //----------INORDER----------------------
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
        
    }
    
    //-------------SEARCH IN TREE-------------------
    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
     //-----------DELETE A NODE------------------
    public static Node findInorder(Node root){
        while(root.left!=null){
            root = root.left;
        }

        return root;
    }

    public static Node delete(Node root, int val){
        if(root.data<val){
            root.right = delete(root.right,val);
        }
        else if(root.data>val){
            root.left = delete(root.left,val);
        }
        else{//voilla
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }

            //single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 both children
            Node IS = findInorder(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);

        }
        return root;
    }
    //------------PRINT IN RANGE-------------
    public static void printinrange(Node root,int k1, int k2){
        if(root == null){
            return ;
        }
        if(root.data>= k1 && root.data<=k2){
            printinrange(root.left,k1,  k2);
            System.out.println(root.data + " ");
            printinrange(root.right,k1,  k2);

        }
        else if(root.data <k1 ){
            printinrange(root.left,k1,  k2);

        }
        else{
            printinrange(root.right,k1,  k2);

        }
    }
    //-------------------ROOT TO LEAF PATH---------------------
    public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }
    public static void printroot2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right == null){
            printpath(path);
        }

        printroot2leaf(root.left, path);
        printroot2leaf(root.right, path);
        path.remove(path.size()-1);

    }
    //-------------------VALIDATE BST--------------------------
    public static boolean Isvalidbst(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;

        }
        else if(max!=null && root.data>=max.data){
            return false;
        }

        return Isvalidbst(root.left, min, root)
        && Isvalidbst(root.right, root, max);

    }
    //-------------------MIRROR BST-------------------------
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }

        Node leftmirror = mirror(root.left);
        Node rightmirror = mirror(root.right);

        root.left = rightmirror;
        root.right = leftmirror;
        return root;

    }
    //-------------------MAIN FUNCTION-------------------------
    public static void main(String args[]){
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        
        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();

        root = delete(root,1);
        System.out.println();

        if(search(root,1)){
            System.out.println("found");

        }
        else{
            System.out.println("not found");
        }

        printroot2leaf(root.left, new ArrayList<>());

        if(Isvalidbst(root, null, null)){
            System.out.print("valid");

        }
        else{
            System.out.print("not valid");
        }
    }
}
