import java.util.*;
public class twobstmer {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
    }
        //--------------CREATE BST---------------
        public static Node createbst(ArrayList<Integer> arr, int st, int end){
            if(st>end){
                return null;
            }
            int mid =(st+end)/2;
            Node root = new Node(arr.get(mid));
            root.left = createbst(arr, st, mid-1);
            root.right = createbst(arr, mid+1, end);
            return root;
        }

        //--------------INORDER------------------
        public static void getinorder(Node root, ArrayList<Integer> arr){
            if(root == null){
                return;
            }
            getinorder(root.left, arr);
            arr.add(root.data);
            getinorder(root.right, arr);
        }

        //--------------MERGE BST------------------
        public static Node mergebst(Node root1, Node root2){
            ArrayList<Integer> arr1 = new ArrayList<>();
            getinorder(root1,arr1);

            //step2
            ArrayList<Integer> arr2 = new ArrayList<>();
            getinorder(root1,arr2);

            //merge
            int i=0,j=0;
            ArrayList<Integer> finalarr = new ArrayList<>();
            while(i<arr1.size() && j<arr2.size()){
                if(arr1.get(i)<=arr2.get(j)){
                    finalarr.add(arr1.get(i));
                    i++;

                }
                else{
                    finalarr.add(arr2.get(j));
                    j++;

                }

            }
            while(i<arr1.size()){
                finalarr.add(arr1.get(i));
                    i++;

            }
            while(j<arr2.size()){
                finalarr.add(arr2.get(j));
                    j++;

            }
            //sorted arraylist -> balanced bst
            return createbst(finalarr, 0, finalarr.size()-1);


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
            
        //--------------MAIN FUNCTION--------------

        public static void main(String args[]){
        
            Node root1 = new Node(2);
            root1.left = new Node(1);
            root1.right = new Node(4);
    
            Node root2 = new Node(9);
            root2.left = new Node(3);
            root2.right = new Node(12);
    
            Node root = mergebst(root1, root2);
            preorder(root);
        }

}
