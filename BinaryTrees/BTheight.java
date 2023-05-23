import java.util.*;
public class BTheight {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(rh,lh) + 1;
    }
    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int leftcount = count(root.left);
        int rightcount = count(root.right);
        return leftcount + rightcount + 1;
    }
    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        return leftsum + rightsum + root.data;
    }
    public static int diameter2(Node root){ //O(n^2)
        if(root == null){
            return 0;
        }
        int leftdiam = diameter2(root.left);
        int lefth = height(root.left);
        int rightdiam = diameter2(root.right);
        int righth = height(root.right);

        int selfdiam = lefth + righth + 1;
        return Math.max(selfdiam,Math.max(leftdiam,rightdiam));
    }
    //static class Info{
      //  int diam;
      //  int ht;

      //  public Info(int diam,int ht){
       //     this.diam = diam;
       //     this.ht = ht;
       // }
   // }
   // public static Info diameter(Node root){ //O(n)
     //   if(root == null){
     //       return new Info(0,0);
      //  }
        
       // Info leftinfo = diameter(root.left);
       // Info rightinfo = diameter(root.right);
       // int diam = Math.max(Math.max(leftinfo.diam, rightinfo.diam), leftinfo.ht + rightinfo.ht + 1);

       // int ht = Math.max(leftinfo.ht,rightinfo.ht) + 1;

        
       // return new Info(diam,ht);
   // }
    public static boolean isIdentical(Node node,Node subroot){
        if(node  == null && subroot == null){
            return true;
        }else if(node  == null || subroot == null || node.data != subroot.data){
            return false;

        }
        if(!isIdentical(node.left,subroot.left)){
            return false;
        }
        if(!isIdentical(node.right,subroot.right)){
            return false;
        }
        return true;
       

    }
    public static boolean issubtree(Node root,Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        boolean leftans = issubtree(root.left,subroot);//left subtree true
        boolean rightans = issubtree(root.right,subroot);//right subtree true

        return leftans||rightans;
    }
    static class info{
        Node node;
        int hd;

        public info(Node node ,int hd){
            this.node  = node;
            this.hd = hd;
        }
    }
    public static void topview(Node root){
        Queue<info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min =0,max = 0;
        q.add(new info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            info curr = q.remove();
            if(curr == null){
               
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){ //first time my hd is occurring
                    map.put(curr.hd, curr.node);
    
                }
    
                if(curr.node.left !=null){
                q.add(new info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right !=null){
                    q.add(new info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                    }

            }
            
        }
        for(int i=min;i<max;i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();

    }
    public static void klevel(Node root,int level,int k){
        if(root==null){
            return;
        }

        if(level==k){
            System.out.print(root.data+ " ");
            return;
        }
        klevel(root.left,level+1,k);
        klevel(root.right,level+1,k);
        
    }
    public static boolean getpath(Node root, int n, ArrayList<Node> path){
        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data==n){
            return true;
        }

        boolean foundleft=getpath(root.left,n,path);
        boolean foundright=getpath(root.right,n,path);

        if(foundleft||foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    }
    public static Node lca(Node root,int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, n1, path1);
        getpath(root, n2, path2);

        //last common ancestor
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        //last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;


    }
    public static Node lca2(Node root, int n1, int n2){
        if(root.data == n1 || root.data == n2){
            return root;

        }

        Node leftlca = lca2(root.left,n1, n2);
        Node rightlca = lca2(root.right,n1, n2);

        //leftLCA right=null
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }
        return root;
       
    }
    public static int lcadist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data==n){
            return 0;

        }
        int leftdist = lcadist(root.left,n);
        int rightdist = lcadist(root.right,n);
        if(leftdist == -1 && rightdist == -1){
            return -1;
        }
        else if(leftdist==-1){
            return rightdist +1;
        }
        else{
            return leftdist+1;
        }
        

        }
    public static int mindis(Node root,int n1, int n2){
        Node lca= lca2(root,n1, n2);
        int dist1 = lcadist(lca,n1);
        int dist2 = lcadist(lca,n2);

        return dist1 + dist2;

        }
        //Kancestor
        public static int Kancestor(Node root,int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftdist = Kancestor(root.left,n, k);
            int rightdist = Kancestor(root.right,n, k);

            if(leftdist == -1 && rightdist == -1){
                return -1;
            }
            int max = Math.max(leftdist,rightdist);
            if(max+1==k){
                System.out.println(root.data);
            }
    
            return max+1;
    
            }

            //transform sum root
            public static int transform(Node root){
                if(root == null){
                    return 0;
                }
                
                int leftchild = transform(root.left);
                int rightchild = transform(root.right);
    
                int data = root.data;

                int newleft = root.left == null? 0 : root.left.data;
                int newright = root.right == null? 0 : root.right.data;
                root.data = newleft + leftchild + newright + rightchild;
                return data;
                }

                //preorder
                public static void preorder(Node root){
                    if(root == null){
                        return;
                    }
                    System.out.print(root.data + " ");
                    preorder(root.left);
                    preorder(root.right);
            
                }

    public static void main(String args[]){
      
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        //System.out.println(diameter(root).diam);
        //int k = 2;
        //klevel(root,1,k);
        int n1=4,n2=5;
        System.out.println(lca(root,n1,n2).data);
        
    }
}
