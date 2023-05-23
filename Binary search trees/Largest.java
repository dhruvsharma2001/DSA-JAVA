

public class Largest {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
    }
    //---------------INFO----------------------
    static class Info{
        boolean IsBST;
        int size;
        int min;
        int max;

        public Info(boolean IsBST,int size, int min, int max){
            this.IsBST = IsBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }

    }
    //------------------LARGEST BST------------------------
    public static int maxbst = 0;
    public static Info Largestbst(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftinfo = Largestbst(root.left);
        Info rightinfo = Largestbst(root.right);
        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));

        if(root.data<=leftinfo.max || root.data>=rightinfo.min){
            return new Info(false, size, min, max);
        }

        if(leftinfo.IsBST && rightinfo.IsBST){
            maxbst = Math.max(maxbst,size);
            return new Info(true, size, min, max);

        }
        return new Info(false, size, min, max);

    }
    public static void main(String args[]){
        
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info gaand = Largestbst(root);
        System.out.println("largest bst size =" + maxbst);

        

    }
}
